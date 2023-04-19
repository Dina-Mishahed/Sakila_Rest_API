package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.ActorRepository;
import gov.iti.jets.service.dto.ActorDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
}
