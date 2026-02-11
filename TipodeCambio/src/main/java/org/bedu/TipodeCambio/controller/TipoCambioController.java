package org.bedu.TipodeCambio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.bedu.TipodeCambio.model.TipoCambio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Controller = HTTP
//REST Controller = Datos
//API = Es la forma de utilizar software dentro de nuestro software "reutilizar"
//REST API = Backends donde transmitimos datos (objetos)

/**
 * usaremos google para averiguar en que cotizan:
 * 
 * USD
 *      mxn = 18.01
 *      ars = 1433.88
 * 
 * MXN
 *      usd = 0.056
 *      ars = 79.13
 * 
 * ARS
 *      usd = 0.0007
 *      mxn = 0.013
 * 
 */

@RestController
public class TipoCambioController {
   
    private List<TipoCambio> baseDatos;

    public TipoCambioController(){
        this.baseDatos=new ArrayList<>();

        HashMap<String, Double> conversionUsd = new HashMap<>();
        conversionUsd.put("MXN", 18.01);
        conversionUsd.put("ARS", 1433.88);
        this.baseDatos.add(new TipoCambio("USD", conversionUsd));

        HashMap<String, Double> conversionMxn = new HashMap<>();
        conversionMxn.put("USD", 0.056);
        conversionMxn.put("ARS", 79.13);
        this.baseDatos.add(new TipoCambio("MXN", conversionMxn));

        HashMap<String, Double> conversionArs=new HashMap<>();
        conversionArs.put ("USD",0.0007);
        conversionArs.put("MXN", 0.013);
        this.baseDatos.add(new TipoCambio("ARS", conversionArs));
    

    }
    /**
     * En un backend existen 4 formas de pasar parametros a un endpoint
     * 1. Path Variable (@PathVariable)
     * Un pedazo de la URL es una variable.
     * ejemplo: clima/toluca , clima/slp , clima/cdmx
     * 
     * 2. QueryString (@RequestParam)
     * son parametros que van al final de la url, son opcionales (pero en Spring por defecto es obligatorio) y son 
     * de la forma llave = valor
     * si son mas de una variable se utiliza el & para separarlas
     * ejemplo: ? variable1=valor1 & variable2=valor2 & variable3=valor3
     * 
     */
    //Obtener las conversiones de una moneda en especifico.
    // http://localhost:8080/conversiones/USD

    @RequestMapping("conversiones/{moneda}")
    public HashMap<String, Double> obtenerConversiones (@PathVariable("moneda") String codigo){
        //Iteramos cada tipo de cambio de la base de datos
        for (TipoCambio tipoCambio : baseDatos){
            //Si el tipo de cambio es el mismo del que nos dieron como parametro
            if (tipoCambio.getCodigo().equals(codigo.toUpperCase())){
                //Regresamos las conversiones
                return tipoCambio.getConversiones();

            }
        }
        //Si no existe el tipo de cambio, regresamos null
        return null;

    }
    // http://localhost:8080/conversiones/usd/convertir/yenes?cantidad=10
    @RequestMapping("conversiones/{moneda}/convertir/{destino}")
    public double convertir (
        @PathVariable("moneda") String codigo, 
        @PathVariable("destino") String destino,
        @RequestParam("cantidad") int cantidad){
        for (TipoCambio tipoCambio : baseDatos){
            if (tipoCambio.getCodigo().equals(codigo.toUpperCase())){
            //Wrapper Classes
            Double valor = tipoCambio.getConversiones().get(destino.toUpperCase());

            if (valor == null){
                return 0;
            } else {
                return cantidad == 0 ? valor : valor * cantidad;
            }
        }
    }
    //Si no existe el tipo de cambio, regresamos 0
    return 0;
}
}