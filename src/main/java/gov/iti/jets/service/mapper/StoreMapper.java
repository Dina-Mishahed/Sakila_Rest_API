package gov.iti.jets.service.mapper;

import gov.iti.jets.service.dto.StoreDto;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.stream.Collectors.toCollection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
public interface StoreMapper {
    Store toEntity(StoreDto storeDto);

    StoreDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);

    default ArrayList<StoreDto> toDTOs(Collection<Store> stores) {
        return stores.stream().map(entity -> toDto(entity)).collect(toCollection(ArrayList<StoreDto>::new));
    }

    default ArrayList<Store> toEntities(Collection<StoreDto> storeDtoS) {
        return storeDtoS.stream().map(dto -> toEntity(dto)).collect(toCollection(ArrayList<Store>::new));
    }
}