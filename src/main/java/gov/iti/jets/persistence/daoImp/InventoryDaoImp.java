package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.InventoryDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.mapper.CityMapper;
import gov.iti.jets.service.mapper.InventoryMapper;
import gov.iti.jets.service.mapper.RentalMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class InventoryDaoImp extends BaseDAO implements InventoryDao {
    private InventoryMapper inventoryMapper;

    private RentalMapper rentalMapper;
    private Inventory inventory;
    public InventoryDaoImp(){
        inventoryMapper = Mappers.getMapper(InventoryMapper.class);
        rentalMapper = Mappers.getMapper(RentalMapper.class);
    }
    @Override
    public InventoryDto getInventoryById(int id) {
        inventory = getById(id);
        return inventoryMapper.toDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<Inventory> inventoryList = getAll(Inventory.class);
        List<InventoryDto> inventoryDtoList = inventoryList.stream().map((inventory -> inventoryMapper.toDto(inventory))).toList();
        return inventoryDtoList;
    }

    @Override
    public List<RentalDto> getRentalListByInventory(int id) {
        inventory = getById(id);
        List<Rental> rentalList = inventory.getRentalList();
        List<RentalDto> rentalDtoList = rentalList.stream().map((rental -> rentalMapper.toDto(rental))).toList();
        return rentalDtoList;
    }

    private Inventory getById(int id){
        return  (Inventory) get(Inventory.class,"inventoryId",id);
    }

}
