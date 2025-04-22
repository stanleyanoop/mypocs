package com.self.myworklist.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Worklist_Data")
public class WorklistData {

	@Id
	@Column(name = "Worklist_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long worklistId;
	@Column(name = "Name")
	private String name;
	@Column(name = "Short_request")
	private String shortRequest;
	@Column(name = "Request_status")
	private String requestStatus;
	@Column(name = "Date_requested")
	private String dateRequested;
	@Column(name = "Date_resolved")
	private String dateResolved;

	public Long getId() {
		return worklistId;
	}

	public void setId(Long id) {
		this.worklistId = id;
	}

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
