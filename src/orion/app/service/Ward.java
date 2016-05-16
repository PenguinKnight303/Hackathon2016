package orion.app.service;

import java.util.List;

public class Ward {
	private String wardID;
	private String wardName;
	private String capacity;
	private List<Patient> patientList;
	
	public Ward(String wardID, String wardName, String capacity){
		this.wardID = wardID;
		this.wardName = wardName;
		this.capacity = capacity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
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

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

}
