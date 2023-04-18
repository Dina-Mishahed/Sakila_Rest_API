package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.InventoryRepository;
import gov.iti.jets.persistence.repository.LanguageRepository;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.LanguageDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.List;

public class InventoryService {
    private InventoryRepository inventoryRepository = new InventoryRepository();

    @WebMethod(operationName = "FindInventoryById")
    public InventoryDto getInventoryById(@WebParam(name = "InventoryId") short id){
        return inventoryRepository.getInventoryDById(id);
    }

    @WebMethod(operationName = "FindAllInventory")
    public List<InventoryDto> getAllInventory() {
        return inventoryRepository.getAllInventoryD();
    }
}
