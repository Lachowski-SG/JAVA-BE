package org.bedu.Games.controller;

import java.util.LinkedList;
import java.util.List;

import org.bedu.Games.model.Game;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * El Backend es un API pero un API no siempre es un backend.
 * API: Application Programming Interface
 * Es un software que permite conectar a otro software.
 * 
 * 
 * ADMINISTRAR INFORMACION DE VIDEOJUEGOS:
 * - Obtener informacion de un videojuego en especifico. (Path Variable)
 * - Obtener informacion de todos los videojuegos.
 * - Dar de alta nuevos videojuegos. (Body)
 * - Editar videojuegos. (Body)
 * - Dar de baja videojuegos. (Path Variable)
 * 
 * C.R.U.D. (Create, Read, Update, Delete)
 * 
 * Un CRUD es un API/Backend que realiza dichas operaciones.
 * 
 */
@RestController
public class GameController {

    private int currentId =3;

    private List<Game> db = new LinkedList<>();

    public GameController(){
        //En memoria
        db.add(new Game(1, "Super Mario Bros 64", 1996 ,"Plataform"));
        db.add(new Game(2, "the King of Fighters", 1995 ,"Fighters"));
        db.add(new Game(3, "The Legend of Zelda", 1992 ,"Adventure"));

    }

/**
 * Formas de pasar parametros a un API (4)
 * 
 * 1 - Querrystring (@RequestParam)
 * http://localhost:8080/endpoint ? parametro1 = valor1 & parametro2 = valor2
 * 
 * 2 - PathVariable (@PathVariable)
 * http://localhost:8080/endpoint/(variable)
 * 
 * 3 - Request Body (@RequestBody)
 * 
 * 4 - Head
 */

//Primer Endpoint obtener la informacion de todos los videojuegos.
@RequestMapping("getAllGames")
public List<Game> getAll(){
    return db;
}

//Segundo Endpoint obtener la info de un videojuego en especifico.
@RequestMapping("getOneGame/{id}")
public Game getOne(@PathVariable("id")Integer id){
    for (Game game :db){
        if (game.getId()== id){
            return game;

        }
    }
    return null;
}

//Tercer  Endpoint para elimar un videojuego en especifico.
@RequestMapping("deleteGame/{id}")
public void deleteOne(@PathVariable("id") int id){
    for (int i=0; i < db.size(); i++){
        Game game = db.get(i);

        if (game.getId() == id){
            db.remove(i);
            break;
        }
    }
}

//Cuarto Endpoint para crear una entrada nueva de un videojuego.
// ++currentId: Incremente en uno y luego asigna el valor.
// currentId++: Asigna el valor y luego incrementa en uno.
@RequestMapping("createGame")
public int create(@RequestBody Game newGame){
    System.out.println(newGame);
    newGame.setId(++currentId);
    db.add(newGame);
    return newGame.getId();
}

//Quinto Endpoint para actualizar los datos de un videojuego.
@RequestMapping("updateGame/{id}")
public void update (@RequestBody Game updateGame, @PathVariable("id") int id){
    for (Game game : db){
        if (game.getId()==id){
            
            if (updateGame.getTitle()!= null){
                game.setTitle(updateGame.getTitle());
            }

            if (updateGame.getYear()!= null){
                game.setYear(updateGame.getYear());
            }

            if (updateGame.getGenre()!= null){
                game.setGenre(updateGame.getGenre());
            }
            break;
        }
    }
}

}

