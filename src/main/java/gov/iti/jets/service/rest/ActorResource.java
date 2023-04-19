//package gov.iti.jets.service.rest;
//
//import gov.iti.jets.persistence.repository.ActorRepository;
//import gov.iti.jets.service.dto.ActorDto;
//import jakarta.jws.WebMethod;
//import jakarta.jws.WebParam;
//
//import java.util.Date;
//import java.util.List;
//
//public class ActorResource {
//    private ActorRepository actorRepository;
//
//    public ActorResource() {
//        actorRepository = new ActorRepository();
//    }
//
//    @POST
//    @Consumes({"application/xml", "application/json"})
//    public Boolean createActor(String firstName , String lastName) {
//        ActorDto actorDto = new ActorDto(null,firstName,lastName, new Date());
//        return actorRepository.createActor(actorDto);
//    }
//    public ActorDto getActorById(short id) {
//        return actorRepository.getActorById(id);
//    }
//    public Boolean updateActor(ActorDto actorDto) {
//        return actorRepository.updateActor(actorDto);
//    }
//    public void deleteActor(short id) {
//        actorRepository.deleteActor(id);
//    }
//    public List<ActorDto> getAllActors() {
//        return actorRepository.getAllActors();
//    }
//}
