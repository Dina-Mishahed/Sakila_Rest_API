package gov.iti.jets.service;

import gov.iti.jets.persistence.repository.ActorRepository;
import gov.iti.jets.service.dto.ActorDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

//<!--    createActor: /soap/actors-->
//<!--    getActorById: /soap/actors/{id}-->
//<!--    updateActor: /soap/actors/{id}-->
//<!--    deleteActor: /soap/actors/{id}-->
//<!--    getAllActors: /soap/actors-->
@WebService
public class ActorService {
    private ActorRepository actorRepository = new ActorRepository();
    @WebMethod(operationName = "AddNewActor")
    public Boolean createActor(@WebParam(name = "actorFirstName")String firstName ,@WebParam(name = "actorLastName")String lastName) {
        ActorDto actorDto = new ActorDto(null,firstName,lastName, new Date());
        return actorRepository.createActor(actorDto);
    }
    @WebMethod
    public ActorDto getActorById(@WebParam(name = "actorId")short id) {
        return actorRepository.getActorById(id);
    }
   @WebMethod
   public Boolean updateActor(@WebParam(name = "actor")ActorDto actorDto) {
       return actorRepository.updateActor(actorDto);
   }
    @WebMethod
    public void deleteActor(@WebParam(name = "actorId")short id) {
        actorRepository.deleteActor(id);
    }
    @WebMethod
    public List<ActorDto> getAllActors() {
        return actorRepository.getAllActors();
    }
}
