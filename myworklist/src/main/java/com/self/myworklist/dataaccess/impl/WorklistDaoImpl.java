package com.self.myworklist.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;

import com.self.myworklist.data.WorklistData;
import com.self.myworklist.dataaccess.WorklistDao;

public class WorklistDaoImpl implements WorklistDao {

	@Override
	public List<WorklistData> getAllWorklist() {
		// TODO Auto-generated method stub
		System.out.println("Inside the daoimpl. Oh yeah... autowired too");
		
		//Write the logic to connect to the DB and fetch the data. 
		List<WorklistData> worklist = new ArrayList<WorklistData>();
		
		WorklistData data1 = new WorklistData();
		data1.setDateRequested("04/14/2025");
		data1.setDateResolved("");
		data1.setName("Anoop");
		data1.setRequestStatus("Open");
		data1.setShortRequest("Pray for a good job");
		worklist.add(data1);
		
		WorklistData data2 = new WorklistData();
		data2.setDateRequested("04/14/2025");
		data2.setDateResolved("");
		data2.setName("Anoop");
		data2.setRequestStatus("Open");
		data2.setShortRequest("Pray for H1B extension");
		worklist.add(data2);
		return worklist;
	}

	@Override
	public String createWorklist(WorklistData worklistData) {
		// TODO Auto-generated method stub
		return "Worklist was successfully created" + worklistData.toString();
	}

}
