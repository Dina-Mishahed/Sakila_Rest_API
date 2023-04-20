package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.entity.Rental;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public interface InventoryDao {
    InventoryDto getInventoryById(int id);
    List<InventoryDto> getAllInventory();
    List<RentalDto> getRentalListByInventory(int id);
}
