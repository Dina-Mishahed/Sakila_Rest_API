//package gov.iti.jets.service.mapper;
//
//import gov.iti.jets.service.dto.InventoryDto;
//import gov.iti.jets.persistence.entity.Inventory;
//import org.mapstruct.*;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel ="cdi")
//public interface InventoryMapper {
//    Inventory toEntity(InventoryDto inventoryDto);
//
//    InventoryDto toDto(Inventory inventory);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);
//}