package orion.app.service;

public class Ward {
	private String wardID;
	private String wardName;
	private Integer capacity;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getWardID() {
		return wardID;
	}

	public void setWardID(String wardID) {
		this.wardID = wardID;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

}
