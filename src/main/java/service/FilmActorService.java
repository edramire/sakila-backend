package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.FilmActorFacade;
import model.FilmActor;

@Path("/filmActors")
public class FilmActorService {
	
	@EJB 
	FilmActorFacade filmActorFacadeEJB;
	
	Logger logger = Logger.getLogger(FilmActorService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FilmActor> findAll(){
		return filmActorFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public FilmActor find(@PathParam("id") Integer id) {
        return filmActorFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(FilmActor entity) {
        filmActorFacadeEJB.create(entity);
    }

	/**
	 * Edita por id de actor
	 * @param id
	 * @param entity
	 */
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, FilmActor entity) {
    	entity.setActorId(id.intValue());
        filmActorFacadeEJB.edit(entity);
    }
	

}


