/**
 * 
 */
package com.self.myworklist.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.self.myworklist.business.WorklistProcessor;
import com.self.myworklist.data.WorklistData;
import com.self.myworklist.dataaccess.WorklistDao;

/**
 *  This class is an implementation of the business logic interface WorklistProcessor.
 */
public class WorklistProcessorImpl implements WorklistProcessor {

	@Autowired
	@Qualifier("worklistDao")
	WorklistDao worklistDao;
	
	
	@Override
	public List<WorklistData> getWorklist() {
		// TODO Auto-generated method stub
		System.out.println("I am an autowired method.. Yeaaah hoooo...");
		return worklistDao.getAllWorklist();
	}


	@Override
	public String createWorklist(WorklistData worklistData) {
		// TODO Auto-generated method stub
		return worklistDao.createWorklist(worklistData);
	}

}
