package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.RentalDao;
import gov.iti.jets.persistence.daoImp.RentalDaoImp;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public class RentalRepository implements RentalDao {
    RentalDao rentalDao;
    public RentalRepository() {
        rentalDao = new RentalDaoImp();
    }

    @Override
    public RentalDto getRentalById(int id) {
        return rentalDao.getRentalById(id);
    }

    @Override
    public List<RentalDto> getAllRental() {
        return rentalDao.getAllRental();
    }

    @Override
    public List<PaymentDto> getPaymentListByRental(int id) {
        return rentalDao.getPaymentListByRental(id);
    }
}
