/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gov.iti.jets;

import gov.iti.jets.persistence.daoImp.ActorDaoImp;
import gov.iti.jets.service.dto.ActorDto;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
//        ActorDaoImp actorDaoImp = new ActorDaoImp();
        ActorDto actorDto =  new ActorDto();
        actorDto.setFirstName("dina");
        System.out.println(actorDto.getFirstName());
//        actorDto.setActorId(0);
//        actorDto.setFirstName("aaaaaa");
//        actorDto.setLastName("zzzzz");
//        actorDto.setLastUpdate(new Date(122, 0, 1, 0, 0, 0));
//        actorDaoImp.createActor(actorDto);
    }
}
