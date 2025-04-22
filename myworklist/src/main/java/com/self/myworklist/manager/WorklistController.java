package com.self.myworklist.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.self.myworklist.business.WorklistProcessor;
import com.self.myworklist.data.WorklistData;

@RestController
public class WorklistController {

	@Autowired
	@Qualifier("worklistProcessor")
	WorklistProcessor processor;
	
	@GetMapping("/worklist")
	public List<WorklistData> getAllWorklist() {
		List<WorklistData> worklist = processor.getWorklist();
		
	    return worklist;
	}
	
	
	@PostMapping("/worklist")
	public String createWorklist(@RequestBody WorklistData worklistData) {
		System.out.println("Updating the data >>> " + worklistData.toString());
		return processor.createWorklist(worklistData);
	}
	
	@PutMapping("/updateWorklist")
	public String updateWorklist(@RequestBody WorklistData worklistData) {
		System.out.print("Updating the data >>>" + worklistData.toString());
		return processor.updateWorklist(worklistData);
	}
}
