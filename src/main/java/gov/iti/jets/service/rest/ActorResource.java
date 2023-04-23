package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.ActorRepository;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmActorDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Date;
import java.util.List;


@Path("actors")
public class ActorResource {
   private ActorRepository actorRepository;

   public ActorResource() {
       actorRepository = new ActorRepository();
   }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Boolean createActor(ActorDto actorDto) {
        return actorRepository.createActor(actorDto);
    }


    @GET
    @Path("{actorId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
   public ActorDto getActorById(@PathParam("actorId")short id) {
       return actorRepository.getActorById(id);
   }


    @PUT
    @Path("{actorId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean updateActor(@PathParam("actorId")short id,ActorDto actorDto) {
        return actorRepository.updateActor(id,actorDto);
    }

    @DELETE
    @Path("{actorId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteActor(@PathParam("actorId") short id) {
        actorRepository.deleteActor(id);
        return "Deleted....";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorDto> getAllActors() {
       return actorRepository.getAllActors();
   }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean addActor(ActorDto newActor)  {
       return actorRepository.createActor(newActor);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Boolean updateActor(@PathParam("id")int id, ActorDto newActor)  {
       actorRepository.updateActor(id,newActor);
        return actorRepository.updateActor(id,newActor);
    }

    @GET
    @Path("{name}/getActorByName")
//    @Path("{id}/getCategories")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ActorDto> getActorByName(@PathParam("name")String name){
       return actorRepository.getActorByName(name);
    }

    @GET
    @Path("{id}/getFilms")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FilmActorDto> getFilmListByActor(@PathParam("id")int id){
        return actorRepository.getFilmListByActor(id);
    }


}
