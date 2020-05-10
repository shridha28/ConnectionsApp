package com.myproject.connections.utility.impl;

/**
 * Utility class for mapping of Objects
 * 
 * @author Shreya S Jalihal
 *
 */
import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.connections.entitybeans.CustomerEntity;
import com.myproject.connections.models.CustomerDto;
import com.myproject.connections.models.ImageModel;
import com.myproject.connections.utility.Mapper;

@Component
public class MapperUtility implements Mapper {

	private static Logger logger = LoggerFactory.getLogger(MapperUtility.class);

	
	ObjectMapper mapper = new ObjectMapper();

	/*
	 * MapperUtility method to map CustomerDto Object to CustomerEntity Object
	 * 
	 * @param CustomerEntity customerEntity
	 * 
	 * @param CustomerDto customerDto
	 * 
	 * @param MultipartFile file
	 * 
	 * @return CustomerEntity customerEntity
	 */
	public CustomerEntity mapToCustomerEntity(CustomerEntity customerEntity, MultipartFile file,
			CustomerDto customerDto) {
		ModelMapper modelMapper = new ModelMapper();
		logger.info("setting configuration to skip few properties during mapping");
		modelMapper.addMappings(new PropertyMap<CustomerDto, CustomerEntity>() {
            @Override
            protected void configure() {
                skip(destination.getPassword());
                skip(destination.getUsername());
            }
        });
		logger.info("Mapping customerDto to customerEntity Object using Model Mapper");
		modelMapper.map(customerDto, customerEntity);
		if (file != null) {
			try {
				logger.info("setting the image field to customerEntity ");
				ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
				customerEntity.setImageModel(img);
			} catch (IOException e) {

			}
		}
		return customerEntity;
	}

	
	/*
	 * MapperUtility method to map String model to CustomerDto Object
	 * 
	 * @param String model
	 * 
	 * @return CustomerDto Object 
	 */
	public CustomerDto mapToCustomerDto(String model) {
		CustomerDto customerDto = null;
		try {
			logger.info("deserializing JSON content into a customerDao object ");
			customerDto = mapper.readValue(model, CustomerDto.class);

		} catch (IOException e) {

		}
		return customerDto;
	}


}
