package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.AddressDao;
import gov.iti.jets.persistence.entity.Address;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.persistence.entity.Store;
import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;
import gov.iti.jets.service.mapper.AddressMapper;
import gov.iti.jets.service.mapper.CustomerMapper;
import gov.iti.jets.service.mapper.StaffMapper;
import gov.iti.jets.service.mapper.StoreMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class AddressDaoImp extends BaseDAO implements AddressDao {
    AddressMapper addressMapper;
    private StaffMapper staffMapper;
    private StoreMapper storeMapper;
    private CustomerMapper customerMapper;
    private Address address;
    public AddressDaoImp(){
        addressMapper = Mappers.getMapper(AddressMapper.class);
        staffMapper = Mappers.getMapper(StaffMapper.class);
        storeMapper = Mappers.getMapper(StoreMapper.class);
        customerMapper = Mappers.getMapper(CustomerMapper.class);
    }
    @Override
    public AddressDto geAddressById(Short id) {
        address =getById(id);
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList = getAll(Address.class);
        return addressList.stream().map((address -> addressMapper.toDto(address))).toList();
    }

    @Override
    public List<StaffDto> getStaffListByAddress(int id) {
        address =getById(id);
        List<Staff> staffList = address.getStaffList();
        List<StaffDto> staffDtoList = staffList.stream().map((staff -> staffMapper.toDto(staff))).toList();
        return staffDtoList;
    }

    @Override
    public List<StoreDto> getStoreListByAddress(int id) {
        address =getById(id);
        List<Store> storeList = address.getStoreList();
        List<StoreDto> storeDtos = storeList.stream().map((store -> storeMapper.toDto(store))).toList();
        return storeDtos;
    }

    @Override
    public List<CustomerDto> getCustomerListByAddress(int id) {
        address =getById(id);
        List<Customer> customerList = address.getCustomerList();
        List<CustomerDto> customerDtoList = customerList.stream().map((customer -> customerMapper.toDto(customer))).toList();
        return customerDtoList;
    }


    private Address getById(int id){
        return (Address) get(Address.class,"addressId",id);
    }

}
