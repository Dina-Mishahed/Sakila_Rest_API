package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.StaffDao;
import gov.iti.jets.persistence.daoImp.StaffDaoImp;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public class StaffRepository implements StaffDao {
    StaffDao staffDao;
    public StaffRepository() {
        staffDao = new StaffDaoImp();
    }

    @Override
    public StaffDto getStaffById(Short id) {
        return staffDao.getStaffById(id);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public List<RentalDto> getRentalListByStaff(int id) {
        return staffDao.getRentalListByStaff(id);
    }

    @Override
    public List<PaymentDto> getPaymentListByStaff(int id) {
        return null;
    }
}
