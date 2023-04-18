package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public interface RentalDao {
    RentalDto getRentalById(int id);
    List<RentalDto> getAllRental();
}
