package org.bedu.Netflix.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Las pruebas ayudan a demostrar que el codigo funciona.
 * 
 * Nota: Por mas pruebas qye tenga el codigo siempre es propenso a errores.
 * 
 * Reglas del Testing:
 * 
 * 1. Copias la estructira de paquetes/ carpetas/archivos original.
 * 
 * 2. Todos los metodos son de tipo Void (los nombres de los metodos no importan).
 * 
 * 3. Las pruebas se tratan de los posibles casos (test cases) que puedan surgir en mi codigo.
 * 
 * 4. Para escribir una prueba, vamos a seguir la tecnica AAA:
 *      Las pruebas se dividen en:
 * 
 *      a) Arrange - Precondiciones.
 *      b) Act - La ejecucion del codigo que queremos probar.
 *      c) Assert - Verificacion de los resultados.
 *      
 *      Si la prueba cumple el resultado => PASS
 *      Si la prueba no cumple el resultado => FAIL
 * 
 * 5. Un error en produccion (o de codigo) es una prueba NO ejecutada.
 * 
 * TIPOS DE PRUEBAS:
 * 
 * 1. Smoke Testing: Verifica que un sistema o codigo "Arranque".
 * 
 * 2. Unit Testing: Probar piezas aisladas de codigo.
 *    No se realizan conexioness, ni consultas externas, todo se "Falsifica" (Mockea).
 * 
 * 3. Integration Testing: Probar piezas juntas (2 o mas) y se realizan
 *    conexiones o consultas sobre ambientes de prueba.
 * 
 * 4. E2E (End to End): Probar flujos completos en un ambiente lo mas real posible.
 *    Y se deben de considerar los flujos mas importantes del proyecto.
 * 
 */

public class CalculatorTest {

    @Test
    @DisplayName("La suma de 0 + 0 = 0")

    public void zeroSum(){
        //Arrange
        int a=0;
        int b=0;

        //Act
        int result = Calculator.sum(a, b);

        //Assert
        //Esperariamos que el resultado fuera 0

        assertEquals(0, result);
    }

    @Test
    @DisplayName("La suma de N+0 es N y la suma de 0+N es N")
    public void sumZero (){
        int n=100;

        int result1 = Calculator.sum(n, 0);
        int result2 = Calculator.sum(0, n);

    // En una sola prueba puedo tener varios asserts.

        assertEquals(n, result1);
        assertEquals(n, result2);

    }


     @Test
     @DisplayName("La division de N/1 es N")
     public void divOne(){
        int n = 500;

        int result = Calculator.div(n,1);

        assertEquals(n, result);

     }

     @Test
     @DisplayName("La division entre 0 debe lanzar una excepcion")
     public void divError(){
        assertThrows(ArithmeticException.class,() -> {
            Calculator.div(100,0);
        });

     }
}
