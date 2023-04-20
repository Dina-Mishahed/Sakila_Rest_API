package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.AddressDao;
import gov.iti.jets.persistence.daoImp.AddressDaoImp;
import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;

import java.util.List;

public class AddressService implements AddressDao {
    private AddressDao addressDao;
    public AddressService(){
        addressDao = new AddressDaoImp();
    }
    @Override
    public AddressDto geAddressById(Short id) {
        return addressDao.geAddressById(id);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public List<StaffDto> getStaffListByAddress(int id) {
        return addressDao.getStaffListByAddress(id);
    }

    @Override
    public List<StoreDto> getStoreListByAddress(int id) {
        return addressDao.getStoreListByAddress(id);
    }

    @Override
    public List<CustomerDto> getCustomerListByAddress(int id) {
        return addressDao.getCustomerListByAddress(id);
    }
}
