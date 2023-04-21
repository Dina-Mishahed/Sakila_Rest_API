package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.ActorRepository;
import gov.iti.jets.service.dto.ActorDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Date;
import java.util.List;


@Path("actor")
public class ActorResource {
   private ActorRepository actorRepository;

   public ActorResource() {
       actorRepository = new ActorRepository();
   }

//    @POST
//    @Consumes({"application/xml", "application/json"})
//    public Boolean createActor(String firstName , String lastName) {
//        ActorDto actorDto = new ActorDto(null,firstName,lastName, new Date());
//        return actorRepository.createActor(actorDto);
//    }


    @GET
    @Path("{actorId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
   public ActorDto getActorById(@PathParam("actorId")short id) {
       return actorRepository.getActorById(id);
   }


//    public Boolean updateActor(ActorDto actorDto) {
//        return actorRepository.updateActor(actorDto);
//    }
//    public void deleteActor(short id) {
//        actorRepository.deleteActor(id);
//    }

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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateActor(@PathParam("id")int id, ActorDto newActor)  {
       actorRepository.updateActor(id,newActor);
        return Response.ok().build();
    }
}
