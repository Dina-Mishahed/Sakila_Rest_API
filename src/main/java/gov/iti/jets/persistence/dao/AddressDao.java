package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.dto.StoreDto;

import java.util.List;

public interface AddressDao {
    public AddressDto geAddressById(Short id);
    public List<AddressDto> getAllAddress();
    List<StaffDto> getStaffListByAddress(int id);
    List<StoreDto> getStoreListByAddress(int id);
    List<CustomerDto> getCustomerListByAddress(int id);
}
