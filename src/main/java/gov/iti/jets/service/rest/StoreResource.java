package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.StoreRepository;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.List;


@Path("store")
public class StoreResource {
    private StoreRepository storeRepository = new StoreRepository();


    @GET
    @Path("{storetId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public StoreDto getStoreById(@PathParam("storetId") short id){
        return storeRepository.getStoreById(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreDto> getAllStore() {
        return storeRepository.getAllStores();
    }

    @GET
    @Path("inventories/{storetId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InventoryDto> getInventoryListByStore(@PathParam("storetId") short id){
        return storeRepository.getInventoryListByStore(id);
    }

    @GET
    @Path("customers/{storetId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getCustomerListByStore(@PathParam("storetId") short id){
        return storeRepository.getCustomerListByStore(id);
    }

    @GET
    @Path("staff/{storetId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDto> getStaffListByStore(@PathParam("storetId") short id){
        return storeRepository.getStaffListByStore(id);
    }
}
