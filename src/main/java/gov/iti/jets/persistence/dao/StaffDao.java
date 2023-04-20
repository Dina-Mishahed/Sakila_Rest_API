package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public interface StaffDao {
    public StaffDto getStaffById(Short id);
    public List<StaffDto> getAllStaff();
//    public boolean addStaff(StaffDto staffDto);
//    public boolean editStaff(Short staffId, StaffDto staffDto);

    List<RentalDto> getRentalListByStaff(int id);
    List<PaymentDto> getPaymentListByStaff(int id);
}


