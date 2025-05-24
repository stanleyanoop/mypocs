package com.self.myworklist.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import com.self.myworklist.data.WorklistData;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = WorklistController.class)
public class WorklistControllerTest {
	@InjectMocks
	private WorklistController controller;
	
	@Test
	public void testGetAllWorklist() {
		when(controller.getAllWorklist()).thenReturn(getAllWorklist());
		
		ResponseEntity<List<WorklistData>> response = (ResponseEntity<List<WorklistData>>) controller.getAllWorklist();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	public List<WorklistData> getAllWorklist() {
		List<WorklistData> worklist = new ArrayList<WorklistData>();
		
		WorklistData data1 = new WorklistData();
//		data1.setId((long) 1);
		data1.setName("Test");
//		data1.setRequestStatus("Open");
		data1.setShortRequest("Test Short Request");
		data1.setDateRequested("04-21-2025");
		worklist.add(data1);
		
		WorklistData data2 = new WorklistData();
//		data2.setId((long) 1);
		data2.setName("Test");
//		data2.setRequestStatus("Open");
		data2.setShortRequest("Test Short Request");
		data2.setDateRequested("04-21-2025");
		worklist.add(data2);
		
	    return worklist;
	}
	
//	
//	@PostMapping("/worklist")
//	public String createWorklist(@RequestBody WorklistData worklistData) {
//		System.out.println("Updating the data >>> " + worklistData.toString());
//		return processor.createWorklist(worklistData);
//	}
//	
//	@PutMapping("/updateWorklist")
//	public String updateWorklist(@RequestBody WorklistData worklistData) {
//		System.out.print("Updating the data >>>" + worklistData.toString());
//		return processor.updateWorklist(worklistData);
//	}
}
