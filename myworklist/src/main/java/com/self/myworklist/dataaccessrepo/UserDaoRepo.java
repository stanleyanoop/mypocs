package com.self.myworklist.dataaccessrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.self.myworklist.data.UserData;

/**
 *  This interface defines the contract for the 
 *  Data access requirements for the user transactions.
 */

public interface UserDaoRepo extends JpaRepository<UserData, Long>{

}
