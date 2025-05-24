/**
 * 
 */
package com.self.myworklist.dataaccessrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.myworklist.data.WorklistData;

/**
 *  This interface defines the contract for the 
 *  Data access requirements for the work-list transactions.
 */
public interface WorklistDaoRepo extends JpaRepository<WorklistData, Long> {

}
