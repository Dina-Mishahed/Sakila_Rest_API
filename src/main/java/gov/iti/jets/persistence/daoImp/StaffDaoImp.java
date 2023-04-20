package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.StaffDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.dto.StaffDto;
import gov.iti.jets.service.mapper.PaymentMapper;
import gov.iti.jets.service.mapper.RentalMapper;
import gov.iti.jets.service.mapper.StaffMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class StaffDaoImp extends BaseDAO implements StaffDao  {
    StaffMapper staffMapper;
    RentalMapper rentalMapper;
    PaymentMapper paymentMapper;
    public StaffDaoImp(){
        staffMapper = Mappers.getMapper(StaffMapper.class);
        rentalMapper = Mappers.getMapper(RentalMapper.class);
        paymentMapper = Mappers.getMapper(PaymentMapper.class);

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

    @Override
    public List<RentalDto> getRentalListByStaff(int id) {
        Staff staff = (Staff) get(Staff.class,"staffId",id);
        List<Rental> rentalList = staff.getRentalList();
        List<RentalDto> rentalDtoList = rentalList.stream().map((rental -> rentalMapper.toDto(rental))).toList();
        return rentalDtoList;
    }

    @Override
    public List<PaymentDto> getPaymentListByStaff(int id) {
        Staff staff = (Staff) get(Staff.class,"staffId",id);
        List<Payment> paymentList = staff.getPaymentList();
        List<PaymentDto> paymentDtoList = paymentList.stream().map((payment -> paymentMapper.toDto(payment))).toList();
        return paymentDtoList;
    }
}
