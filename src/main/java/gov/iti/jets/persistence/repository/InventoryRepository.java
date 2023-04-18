package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.InventoryDao;
import gov.iti.jets.persistence.daoImp.InventoryDaoImp;
import gov.iti.jets.service.dto.InventoryDto;

import java.util.List;

public class InventoryRepository implements InventoryDao {
    private InventoryDao inventoryDao;
    public InventoryRepository(){
        inventoryDao = new InventoryDaoImp();
    }
    @Override
    public InventoryDto getInventoryDById(int id) {
        return inventoryDao.getInventoryDById(id);
    }

    @Override
    public List<InventoryDto> getAllInventoryD() {
        return inventoryDao.getAllInventoryD();
    }
}
