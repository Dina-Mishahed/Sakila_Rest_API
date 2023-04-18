package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.StaffRepository;
import gov.iti.jets.service.dto.StaffDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
@WebService
public class StaffService {
    private StaffRepository staffRepository = new StaffRepository();

    @WebMethod(operationName = "FindStaffById")
    public StaffDto getStaffById(@WebParam(name = "staffId") short id){
        return staffRepository.getStaffById(id);
    }

    @WebMethod(operationName = "FindAllStaff")
    public List<StaffDto> getAllStaff() {
        return staffRepository.getAllStaff();
    }
}
