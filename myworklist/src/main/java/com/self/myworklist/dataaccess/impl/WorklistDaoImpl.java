package com.self.myworklist.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.myworklist.data.WorklistData;
import com.self.myworklist.dataaccessrepo.WorklistDaoRepo;

@Service
public class WorklistDaoImpl  {

	@Autowired 
	private WorklistDaoRepo worklistDao;
	
	public List<WorklistData> getAllWorklist() {
		// TODO Auto-generated method stub
		System.out.println("Inside the daoimpl. Oh yeah... autowired too");
		List<WorklistData> worklist = new ArrayList<WorklistData>();
		worklist = worklistDao.findAll();
		
		return worklist;
	}

	public String createWorklist(WorklistData worklistData) {
		// TODO Auto-generated method stub
		worklistDao.save(worklistData);
		return "Worklist was successfully created" + worklistData.toString();
	}

	public String updateWorklist(WorklistData worklistData) {
		// TODO Auto-generated method stub
		worklistDao.save(worklistData);
		return "Update Success";
	}

	public WorklistData getWorklistDetails(Long wlId) {
		// TODO Auto-generated method stub
		WorklistData worklist = null;
		try {
			Optional<WorklistData> opt = worklistDao.findById(wlId);
			worklist = opt.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No data found");
		}
		return worklist;
	}

}
