package com.kodlamaio.kodlamaio.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	public ModelMapper forResponse();
	public ModelMapper forRequest();

}
