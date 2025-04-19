package com.self.myworklist.data;

public class WorklistData {

	private String name;
	private String shortRequest;
	private String requestStatus;
	private String dateRequested;
	private String dateResolved;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the shortRequest
	 */
	public String getShortRequest() {
		return shortRequest;
	}

	/**
	 * @param shortRequest the shortRequest to set
	 */
	public void setShortRequest(String shortRequest) {
		this.shortRequest = shortRequest;
	}

	/**
	 * @return the requestStatus
	 */
	public String getRequestStatus() {
		return requestStatus;
	}

	/**
	 * @param requestStatus the requestStatus to set
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	/**
	 * @return the dateRequested
	 */
	public String getDateRequested() {
		return dateRequested;
	}

	/**
	 * @param dateRequested the dateRequested to set
	 */
	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}

	/**
	 * @return the dateResolved
	 */
	public String getDateResolved() {
		return dateResolved;
	}

	/**
	 * @param dateResolved the dateResolved to set
	 */
	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

	@Override
	public String toString() {
		return "WorklistData [name=" + name + ", shortRequest=" + shortRequest + ", requestStatus=" + requestStatus
				+ ", dateRequested=" + dateRequested + ", dateResolved=" + dateResolved + "]";
	}

}
