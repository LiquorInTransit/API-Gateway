package com.gazorpazorp.model.dtoMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.gazorpazorp.dto.DriverDetailsDto;
import com.gazorpazorp.model.Driver;
import com.gazorpazorp.model.User;

@Mapper(componentModel = "spring")
public interface DriverMapper {

	DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);
	
	@Mapping(source="driver.id", target="id")
	@Mapping(target="firstName")
	@Mapping(target="lastName")
	@Mapping(target="email")
	@Mapping(target="car")
	DriverDetailsDto customerAndUserToCustomerDetailsDto(Driver driver, User user);
}
