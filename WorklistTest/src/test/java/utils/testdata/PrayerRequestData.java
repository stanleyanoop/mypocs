package utils.testdata;

public class PrayerRequestData {

	private String id;
	private String forWho;
	private String request;
	private String requestDate;
	private String answeredDate;
	private String status;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the forWho
	 */
	public String getForWho() {
		return forWho;
	}
	/**
	 * @param forWho the forWho to set
	 */
	public void setForWho(String forWho) {
		this.forWho = forWho;
	}
	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}
	/**
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return requestDate;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * @return the answeredDate
	 */
	public String getAnsweredDate() {
		return answeredDate;
	}
	/**
	 * @param answeredDate the answeredDate to set
	 */
	public void setAnsweredDate(String answeredDate) {
		this.answeredDate = answeredDate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PrayerRequestData [id=" + id + ", forWho=" + forWho + ", request=" + request + ", requestDate="
				+ requestDate + ", answeredDate=" + answeredDate + ", status=" + status + "]";
	}
	
	
}
