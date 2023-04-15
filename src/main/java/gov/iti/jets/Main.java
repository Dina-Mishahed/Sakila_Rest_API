/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gov.iti.jets;

import gov.iti.jets.persistence.daoImp.ActorDaoImp;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.ActorDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        actorDto.setFirstName("dina");
//        System.out.println(actorDto.getFirstName());
        //////////create Actor
//        actorDto.setFirstName("aaaaaa");
//        actorDto.setLastName("zzzzz");
//        actorDto.setLastUpdate(new Date(122, 0, 1, 0, 0, 0));
//        actorDaoImp.createActor(actorDto);
        //================= get actor By Id=============================
//        actorDto = actorDaoImp.getActorById(10);
//        System.out.println(actorDto.getFirstName());
    }
}
