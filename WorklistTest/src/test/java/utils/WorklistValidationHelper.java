package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.it.E;

public class WorklistValidationHelper {

	public boolean checkColumns(DataTable dataTable, ArrayList<String> referenceColumns) {
		// TODO Auto-generated method stub
		boolean columnExists = false;
//		List<String> referenceColumns = Arrays.asList("ID", "Praying for (Who?)", "Prayer Request", 
//				"Date Reported", "Date Answered", "Status", "Header");
		
		columnExists = dataTable.asList().stream().allMatch(column -> {
				System.out.println("Column ->" + column);
				return column.equals("Header") ? true : referenceColumns.contains(column);
			});

		return columnExists;
	}



}
