package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.RentalRepository;
import gov.iti.jets.service.dto.RentalDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class RentalService {
    private RentalRepository rentalRepository = new RentalRepository();

    @WebMethod(operationName = "FindRentalById")
    public RentalDto getRentalById(@WebParam(name = "rentalId") short id){
        return rentalRepository.getRentalById(id);
    }

    @WebMethod(operationName = "FindAllRental")
    public List<RentalDto> getAllRental() {
        return rentalRepository.getAllRental();
    }
}
