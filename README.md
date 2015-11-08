# sakila-backend
Proyecto de prueba para TBD. 

### Consideraciones

Para acceder a actores: 
* GET /actors/: obtiene todos los actores
* POST /actors/: crea un actor
* PUT /actors/{idActor}: modifica un actor
* GET /actors/{idActor}: obtiene datos de un actor.

Para acceder a Film:
* GET /films/: obtiene todas las películas
* POST /films/: crea una película
* PUT /films/{idFilm}: modifica una película
* GET /films/{idFilm}: obtiene datos de una película.

Para acceder a la relación FilmActors:
* GET /filmActors/: obtiene todas las relaciones
* POST /filmActors/: crea una relación
* PUT /filmActors/{idFilm}: modifica una relación
* GET /filmActors/{idFilm}: obtiene datos de una relación.
* GET /filmActors/findFilmsByActor/{idActor}: obtiene films en los que actuó un actor.
* GET /filmActors/findActorsByFilm/{idFilm}: obtiene actores que trabajaron en un film.
