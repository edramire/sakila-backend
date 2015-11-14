# sakila-backend
Proyecto de prueba para TBD. 

### Consideraciones

Para acceder a actores: 
* GET /actors/: obtiene todos los actores
* POST /actors/: crea un actor
* PUT /actors/{idActor}: modifica un actor
* GET /actors/{idActor}: obtiene datos de un actor.

Para acceder a Film:
* GET /films/: obtiene todas las pel�culas
* POST /films/: crea una pel�cula
* PUT /films/{idFilm}: modifica una pel�cula
* GET /films/{idFilm}: obtiene datos de una pel�cula.

Para acceder a la relaci�n FilmActors:
* GET /filmActors/: obtiene todas las relaciones
* POST /filmActors/: crea una relaci�n
* PUT /filmActors/{idFilm}: modifica una relaci�n
* GET /filmActors/{idFilm}: obtiene datos de una relaci�n.
* GET /filmActors/findFilmsByActor/{idActor}: obtiene films en los que actu� un actor.
* GET /filmActors/findActorsByFilm/{idFilm}: obtiene actores que trabajaron en un film.