package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.CustomerInfoDto;
import gov.iti.jets.service.dto.InventoryDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;

import java.util.List;

public interface StoreDao {
    StoreDto getStoreById(Short id);
    Boolean addStore(StoreDto storeDto);
    Boolean editStore(StoreDto storeDto);
    List<InventoryDto> getStoreInventoryList(int id);
    List<StaffDto> getStoreStaffList(int id);
    List<CustomerInfoDto> getStoreCustomerList(int id);
    List<StoreDto> getAllStores();

}
