package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.StoreDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.service.dto.*;
import gov.iti.jets.service.mapper.CustomerMapper;
import gov.iti.jets.service.mapper.InventoryMapper;
import gov.iti.jets.service.mapper.StaffMapper;
import gov.iti.jets.service.mapper.StoreMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class StoreDaoImp extends BaseDAO implements StoreDao {
    private StoreMapper storeMapper;
    private InventoryMapper inventoryMapper;
    private CustomerMapper customerMapper;
    private StaffMapper staffMapper;
    private Store store;

    public StoreDaoImp(){
        storeMapper = Mappers.getMapper(StoreMapper.class);
        inventoryMapper = Mappers.getMapper(InventoryMapper.class);
        customerMapper = Mappers.getMapper(CustomerMapper.class);
        staffMapper = Mappers.getMapper(StaffMapper.class);

    }
    @Override
    public StoreDto getStoreById(Short id) {
        store = store = getById(id);
        return storeMapper.toDto(store);
    }

//    @Override
//    public void addStore(int managerStaffId,int addressId) {
//        StoreDto storeDto = new StoreDto();
//        storeDto.setManagerName(managerStaffId);
//        storeDto.setStoreAddress(addressId);
//        create(Store.class,storeDto);
//    }

    @Override
    public Boolean editStore(StoreDto storeDto) {
        return null;
    }

    @Override
    public List<InventoryDto> getInventoryListByStore(int id) {
        store = getById(id);
        List<Inventory> inventoryList = store.getInventoryList();
        List<InventoryDto> inventoryDtoList = inventoryList.stream().map((inventory -> inventoryMapper.toDto(inventory))).toList();
        return inventoryDtoList;
    }

    @Override
    public StaffDto getManagerStaff(int storeId) {
        store = getById(storeId);
        Staff staff = (Staff) get(Staff.class,"staffId",store.getManagerStaffId().getStaffId());
        return staffMapper.toDto(staff);
//        return executeWithEntityManager(entityManager -> {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
//            Root<Store> storeRoot = cq.from(Store.class);
//            Join<Store, Staff> staffJoin = storeRoot.join("managerStaffId", JoinType.INNER);
//            cq.multiselect(storeRoot, staffJoin);
//            cq.where(cb.equal(storeRoot.get("storeId"), storeId));
//            TypedQuery<Tuple> query = entityManager.createQuery(cq);
//            Tuple result = query.getSingleResult();
//            Store store = result.get(0, Store.class);
//            Staff staff = result.get(1, Staff.class);
//            return staffMapper.toDto(staff);
//        });
    }

    @Override
    public List<CustomerDto> getCustomerListByStore(int id) {
        store = getById(id);
        List<Customer> customerList = store.getCustomerList();
        List<CustomerDto> customerDtoList = customerList.stream().map((customer -> customerMapper.toDto(customer))).toList();
        return customerDtoList;
    }

    @Override
    public List<StaffDto> getStaffListByStore(int id) {
        store = getById(id);
        List<Staff> staffList = store.getStaffList();
        List<StaffDto> staffDtoList = staffList.stream().map((staff -> staffMapper.toDto(staff))).toList();
        return staffDtoList;
    }

    @Override
    public List<StoreDto> getAllStores() {
        List<Store> storeList = getAll(Store.class);
        return storeList.stream().map((store -> storeMapper.toDto(store))).toList();
    }
    private Store getById(int id){
        return (Store) get(Store.class,"storeId",id);
    }

}
