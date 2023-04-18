package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.StoreRepository;
import gov.iti.jets.service.dto.StoreDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StoreService {
    private StoreRepository storeRepository = new StoreRepository();

    @WebMethod(operationName = "FindStoreById")
    public StoreDto getStoreById(@WebParam(name = "storetId") short id){
        return storeRepository.getStoreById(id);
    }

    @WebMethod(operationName = "FindAllStore")
    public List<StoreDto> getAllStore() {
        return storeRepository.getAllStores();
    }
}
