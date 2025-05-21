package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.it.E;
import utils.testdata.PrayerRequestData;

public class WorklistValidationHelper {

	/**
	 * This method is used to validate the prayer request data table header with the 
	 * reference data in the BDD feature file.
	 * 
	 * @param dataTable
	 * @param referenceColumns
	 * @return
	 */
	public boolean checkColumns(DataTable dataTable, ArrayList<String> referenceColumns) {
		// TODO Auto-generated method stub
		boolean columnExists = false;

		columnExists = dataTable.asList().stream().allMatch(column -> {
			System.out.println("Column ->" + column);
			return column.equals("Header") ? true : referenceColumns.contains(column);
		});

		return columnExists;
	}

	/**
	 * This method is used to validate the prayer request data with the 
	 * reference data in the BDD feature file.
	 * @param map - this is the reference data from the BDD feature file
	 * @param data - This is the prayer request data extracted from the UI
	 * @return
	 */
	public boolean validateRequestRow(Map<String, String> map, PrayerRequestData data) {
		// TODO Auto-generated method stub
		boolean isValidRequest = false;
		if (data != null && map != null) {
			isValidRequest = map.keySet().stream().allMatch(key -> {
				switch (key) {
				case TestConstants.TAB_HEAD_ID:
					return check(data.getId(), (String) map.get(key));
				case TestConstants.TAB_HEAD_WHO:
					return check(data.getForWho(), (String) map.get(key));
				case TestConstants.TAB_HEAD_REQUEST:
					return check(data.getRequest(), (String) map.get(key));

				case TestConstants.TAB_HEAD_DATE_REPORTED:
					return check(data.getRequestDate(), (String) map.get(key));
				case TestConstants.TAB_HEAD_DATE_ANSWERED:
					return check(data.getAnsweredDate(), (String) map.get(key));
				case TestConstants.TAB_HEAD_STATUS:
					return check(data.getStatus(), (String) map.get(key));
				default:
					break;
				}
				return false;
			});

		}
		System.out.print("isValidRequest ->" + isValidRequest);
		return isValidRequest;
	}
	
	/**
	 * This method is used to pause the execution for a given number of milliseconds.
	 * @param millis
	 */
	public void sleep (Long millis) {
        try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean check(String data, String refData) {
		// TODO Auto-generated method stub
		System.out.println("Printing the data and reference data :");
		System.out.println(data);
		System.out.println(refData);
		if (Strings.isNullOrEmpty(refData) && Strings.isNullOrEmpty(data))
			return true;
		return data.equals(refData);
	}

	/**
	 * This method is used to validate the sort order of the prayer request data 
	 * for the given header.
	 * 
	 * @param prayerRequestTableData
	 * @param header
	 * @throws Exception 
	 */
	public boolean checkSortedData(List<PrayerRequestData> prayerRequestTableData, String header) throws Exception {
		// TODO Auto-generated method stub
		if (Objects.nonNull(prayerRequestTableData) && !prayerRequestTableData.isEmpty()) {
			switch (header) {
			case TestConstants.TAB_HEAD_ID:
				ArrayList<String> ids = (ArrayList<String>) prayerRequestTableData.stream().map(
						PrayerRequestData::getId).collect(Collectors.toList());
//				return handleSortCheck(TestConstants.TAB_HEAD_ID, prayerRequestTableData, 
//						ids);
				return sortCheck(ids);
			case TestConstants.TAB_HEAD_WHO:
//				ArrayList<String> list = Collections.
				ArrayList<String> whoList = (ArrayList<String>) prayerRequestTableData.stream().map(
						PrayerRequestData::getForWho).collect(Collectors.toList());
//				return handleSortCheck(TestConstants.TAB_HEAD_WHO, prayerRequestTableData,
//						whoList);
				return sortCheck(whoList);
			case TestConstants.TAB_HEAD_REQUEST:
				ArrayList<String> reqList = (ArrayList<String>) prayerRequestTableData.stream().map(
						PrayerRequestData::getRequest).collect(Collectors.toList());
//				return handleSortCheck(TestConstants.TAB_HEAD_REQUEST, prayerRequestTableData,
//						reqList);
				return sortCheck(reqList);
			case TestConstants.TAB_HEAD_DATE_REPORTED:
				ArrayList<String> dateReportedList = (ArrayList<String>) prayerRequestTableData.stream().map(
						PrayerRequestData::getForWho).collect(Collectors.toList());
//				return handleSortCheck(TestConstants.TAB_HEAD_DATE_REPORTED, prayerRequestTableData,
//						dateReportedList);
                return sortCheck(dateReportedList);
			case TestConstants.TAB_HEAD_DATE_ANSWERED:
				ArrayList<String> dateAnsweredList = (ArrayList<String>) prayerRequestTableData.stream().map(
						PrayerRequestData::getForWho).collect(Collectors.toList());
//				return handleSortCheck(TestConstants.TAB_HEAD_DATE_ANSWERED, prayerRequestTableData,
//						dateAnsweredList);
				return sortCheck(dateAnsweredList);
			case TestConstants.TAB_HEAD_STATUS:
				ArrayList<String> statusList = (ArrayList<String>) prayerRequestTableData.stream().map(
						PrayerRequestData::getForWho).collect(Collectors.toList());
//				return handleSortCheck(TestConstants.TAB_HEAD_STATUS, prayerRequestTableData,
//						statusList);
				return sortCheck(statusList);
			default:
				break;
			}
		}
		return false;
		
	}
	
	private boolean handleSortCheck(String header, List<PrayerRequestData> masterList, ArrayList<String> listToSort) {
		boolean isSorted = false;
		try {
			isSorted = sortCheck(listToSort);
		}catch (Exception e) {
			try {
				System.out.println("Retrying the sort check for -> " + header);

				isSorted = checkSortedData(masterList, header);
			} catch (Exception e1) {
				System.out.println("Retried but failed");
			    e1.printStackTrace();
			}
		}
		return isSorted;
	}
	
	private boolean sortCheck(ArrayList<String> listToSort) throws Exception {
		return listToSort.stream().skip(1).allMatch( i -> {
			int prevIndex = listToSort.indexOf(i)-1;
			System.out.println("Comparing the data [current] =" + i + "with [prev]" + listToSort.get(prevIndex));
			return  (((String) i).compareTo((String) listToSort.get(prevIndex)) >= 0);
		});
	}

	
}
