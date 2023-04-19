package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.StaffRepository;
import gov.iti.jets.service.dto.StaffDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("staff")
public class StaffResource {
    private StaffRepository staffRepository = new StaffRepository();

    @GET
    @Path("{staffId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDto getStaffById(@PathParam("staffId") short id){
        return staffRepository.getStaffById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDto> getAllStaff() {
        return staffRepository.getAllStaff();
    }
}
