package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.AddressDao;
import gov.iti.jets.persistence.entity.Address;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.service.dto.AddressDto;
import gov.iti.jets.service.mapper.AddressMapper;
import gov.iti.jets.service.mapper.StaffMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class AddressDaoImp extends BaseDAO implements AddressDao {
    AddressMapper addressMapper;
    public AddressDaoImp(){
        addressMapper = Mappers.getMapper(AddressMapper.class);
    }
    @Override
    public AddressDto geAddressById(Short id) {
        Address address = (Address) get(Address.class,"addressId",id);
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList = getAll(Address.class);
        return addressList.stream().map((address -> addressMapper.toDto(address))).toList();
    }
}
