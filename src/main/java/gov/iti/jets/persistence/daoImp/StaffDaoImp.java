package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.StaffDao;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.persistence.entity.Store;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.mapper.StaffMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class StaffDaoImp extends BaseDAO implements StaffDao  {
    StaffMapper staffMapper;
    public StaffDaoImp(){
        staffMapper = Mappers.getMapper(StaffMapper.class);
    }
    @Override
    public StaffDto getStaffById(Short id) {
        Staff staff = (Staff) get(Staff.class,"staffId",id);
        return staffMapper.toDto(staff);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = getAll(Staff.class);
        return staffList.stream().map((staff -> staffMapper.toDto(staff))).toList();
    }
}
