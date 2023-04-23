package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.InventoryRepository;
import gov.iti.jets.service.dto.InventoryDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("inventories")
public class InventoryResource {
    private InventoryRepository inventoryRepository = new InventoryRepository();
    @GET
    @Path("{InventoryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public InventoryDto getInventoryById(@PathParam("InventoryId") short id){
        return inventoryRepository.getInventoryById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<InventoryDto> getAllInventory() {
        return inventoryRepository.getAllInventory();
    }
}
