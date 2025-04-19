package com.self.myworklist.business;

import java.util.List;

import com.self.myworklist.data.WorklistData;

public interface WorklistProcessor {
	
	/**
	 * This function gets the full work-list data from the back-end
	 * @return
	 */
	public List<WorklistData> getWorklist();

	/**
	 * This function creates a work-list object in the database.
	 * @param worklistData
	 * @return
	 */
	public String createWorklist(WorklistData worklistData);

}
