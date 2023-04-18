package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.StoreDao;
import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.persistence.entity.Store;
import gov.iti.jets.service.dto.*;
import gov.iti.jets.service.mapper.StoreMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class StoreDaoImp extends BaseDAO implements StoreDao {
    private StoreMapper storeMapper;
    public StoreDaoImp(){
        storeMapper = Mappers.getMapper(StoreMapper.class);
    }
    @Override
    public StoreDto getStoreById(Short id) {
        Store store = (Store) get(Store.class,"storeId",id);
        return storeMapper.toDto(store);
    }

    @Override
    public Boolean addStore(StoreDto storeDto) {
        return null;
    }

    @Override
    public Boolean editStore(StoreDto storeDto) {
        return null;
    }

    @Override
    public List<InventoryDto> getStoreInventoryList(int id) {
        return null;
    }

    @Override
    public List<StaffDto> getStoreStaffList(int id) {
        return null;
    }

    @Override
    public List<CustomerInfoDto> getStoreCustomerList(int id) {
        return null;
    }

    @Override
    public List<StoreDto> getAllStores() {
        List<Store> storeList = getAll(Store.class);
        return storeList.stream().map((store -> storeMapper.toDto(store))).toList();
    }
}
