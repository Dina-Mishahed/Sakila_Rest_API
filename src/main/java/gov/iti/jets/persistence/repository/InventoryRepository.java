package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.InventoryDao;
import gov.iti.jets.persistence.daoImp.InventoryDaoImp;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public class InventoryRepository implements InventoryDao {
    private InventoryDao inventoryDao;
    public InventoryRepository(){
        inventoryDao = new InventoryDaoImp();
    }
    @Override
    public InventoryDto getInventoryById(int id) {
        return inventoryDao.getInventoryById(id);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        return inventoryDao.getAllInventory();
    }

    @Override
    public List<RentalDto> getRentalListByInventory(int id) {
        return inventoryDao.getRentalListByInventory(id);
    }
}
