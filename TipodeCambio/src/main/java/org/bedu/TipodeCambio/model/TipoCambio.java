/**
 * Listas + Hash Tables, Hash Map, Maps
 */

package org.bedu.TipodeCambio.model;

import java.util.HashMap;

public class TipoCambio {

    private String codigo; //usd 
    private HashMap <String, Double> conversiones; //msn, ars.
    
    public TipoCambio (String codigo, HashMap<String, Double> conversiones){
        this.codigo=codigo;
        this.conversiones=conversiones;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public HashMap<String, Double> getConversiones() {
        return conversiones;
    }
    public void setConversiones(HashMap<String, Double> conversiones) {
        this.conversiones = conversiones;
    }
    
}
