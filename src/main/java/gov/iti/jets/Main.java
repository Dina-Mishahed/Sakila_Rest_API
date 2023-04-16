/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gov.iti.jets;

import gov.iti.jets.persistence.daoImp.ActorDaoImp;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.service.dto.ActorDto;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        ActorDaoImp actorDaoImp = new ActorDaoImp();
        ActorDto actorDto =  new ActorDto();
//        actorDto.setFirstName("dina");
//        System.out.println(actorDto.getFirstName());
        actorDto.setFirstName("3la Ay");
        actorDto.setLastName("Toz Toz");
//        actorDto.setLastUpdate(new Date(121, 10, 1, 0, 0, 0));
//        actorDto.setActorId((short) 201);
//        actorDaoImp.createActor(actorDto);
//        actorDto = actorDaoImp.getActorById(1);
//        actorDaoImp.deleteActor(206);
//        System.out.println(actorDaoImp.getAllActors().size());
    }
}
