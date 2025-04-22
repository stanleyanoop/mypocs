package com.self.myworklist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.self.myworklist.business.WorklistProcessor;
import com.self.myworklist.business.impl.WorklistProcessorImpl;
import com.self.myworklist.dataaccess.impl.WorklistDaoImpl;

@Configuration
public class WorklistConfiguration {
	
	@Bean(name="worklistProcessor")
	public WorklistProcessor worklistProcessor() {
		return new WorklistProcessorImpl();
		
	}
	
	@Bean(name="worklistDaoImpl")
	public WorklistDaoImpl worklistDao() {
		return new WorklistDaoImpl();
	}

	
}
