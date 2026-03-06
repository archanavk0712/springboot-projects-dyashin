package com.dyashin.empspringdatajpaapp.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.dyashin.empspringdatajpaapp.dto.EmployeeDto;
import com.dyashin.empspringdatajpaapp.request.EmployeeReqDto;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
	@Mapping(source = "LName", target = "lastName")
	
//	If the field names are different in entity and DTO
//	@Mapping(source = "dateOfBirth", target = "dob")
	
//	To ignore or avoid a field to be displayed in the output
//	@Mapping(source = "password", ignore = true)
	
//	To set default value if there is a null value
//	@Mapping(source = "status", target = "status", defaultValue = "INACTIVE")
	
//	To ignore all the fields and only map a single field
//	@BeanMapping(ignoreByDefault = true)
//	@Mapping(source = "name", target = "name")
	EmployeeDto mapEmployeeReqToDto(EmployeeReqDto employeeReqDto);
	
//	To mapp 2 entites in a single DTO 
//	@Mapping(source = "EmployeeDto.id" , target = "id")
//	@Mapping(source = "EmployeeDto.name", target= "name")
//	@Mapping(source = "ContactDto.mobileNo", target= "mob", qualifiedByName = "maskPhone")
//	@Mapping(source = "ContactDto.email", target = "emailId")
//	EmployeeDto mapEmployeeReqAndContactReqToDto(EmployeeReqDto employeeReqDto, ContactReqDto contactReqDto);
	
//	To do some special operations while mapping
//	@Named("maskPhone")
//	static String getPhoneNumber(String phoneNumber) {
//		return "****" + phoneNumber.substring(4);
//	}
}
