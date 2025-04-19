/**
 * 
 */
package com.self.myworklist.dataaccess;

import java.util.List;

import com.self.myworklist.data.WorklistData;

/**
 *  This interface defines the contract for the 
 *  Data access requirements for the work-list transactions.
 */
public interface WorklistDao {
	/**
	 * This function gets all the work-list data
	 * @return
	 */
	public List<WorklistData> getAllWorklist();

	/**
	 * This function creates a work-list data in the database
	 * @param worklistData
	 * @return
	 */
	public String createWorklist(WorklistData worklistData);

}
