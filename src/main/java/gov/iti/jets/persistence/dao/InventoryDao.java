package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.InventoryDto;

import java.util.List;

public interface InventoryDao {
    InventoryDto getInventoryDById(int id);
    List<InventoryDto> getAllInventoryD();
}
