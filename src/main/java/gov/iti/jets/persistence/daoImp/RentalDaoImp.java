package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.RentalDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.mapper.CityMapper;
import gov.iti.jets.service.mapper.LanguageMapper;
import gov.iti.jets.service.mapper.PaymentMapper;
import gov.iti.jets.service.mapper.RentalMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class RentalDaoImp extends BaseDAO implements RentalDao {
    private RentalMapper rentalMapper;
    private PaymentMapper paymentMapper;

    public RentalDaoImp(){
        rentalMapper = Mappers.getMapper(RentalMapper.class);
        paymentMapper = Mappers.getMapper(PaymentMapper.class);
    }
    @Override
    public RentalDto getRentalById(int id) {
        Rental rental = (Rental) get(Rental.class,"rentalId",id);
        return rentalMapper.toDto(rental);
    }

    @Override
    public List<RentalDto> getAllRental() {
        List<Rental> rentalList = getAll(Rental.class);
        List<RentalDto> rentalDtoList = rentalList.stream().map((rental -> rentalMapper.toDto(rental))).toList();
        return rentalDtoList;
    }

    @Override
    public List<PaymentDto> getPaymentListByRental(int id) {
        Rental rental = (Rental) get(Rental.class,"rentalId",id);
        List<Payment> paymentList = rental.getPaymentList();
        List<PaymentDto> paymentDtoList = paymentList.stream().map((payment -> paymentMapper.toDto(payment))).toList();
        return paymentDtoList;
    }
}
