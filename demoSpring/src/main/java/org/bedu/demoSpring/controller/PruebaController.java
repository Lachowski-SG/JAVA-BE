package org.bedu.demoSpring.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//**
// El Controlador (Controller) es el cerebro de un Backend
// Decide que hacer para resolver una petición. Tiene un conjunto de "endpoints".
//  */
@RestController //Agregamos una anotación para que Spring detecte el controlador que creamos.
public class PruebaController {
    // URL: http://localhost:8080/Hellow
    @RequestMapping ("Hellow")
    public String Hellow(){
        return "Hellow World";
    }
    // URL: http:localhost:8080/Bye
    @RequestMapping ("Bye")
    public String Bye(){
        return "Goodbye";
    }
    
}
