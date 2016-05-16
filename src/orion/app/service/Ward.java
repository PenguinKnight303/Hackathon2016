package orion.app.service;

import java.util.List;

public class Ward {
	private int wardID;
	private String wardName;
	private int capacity;
	private List<Patient> patients;
	WaitingList waitingList;
	
	public Ward(String wardID, String wardName, String capacity){
		this.wardID = Integer.parseInt(wardID);
		this.wardName = wardName;
		this.capacity = Integer.parseInt(capacity);
		this.waitingList = new WaitingList(this.wardID);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = Integer.parseInt(capacity);
	}

	public int getWardID() {
		return wardID;
	}

	public void setWardID(String wardID) {
		this.wardID = Integer.parseInt(wardID);
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public List<Patient> getPatientList() {
		return patients;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patients = patientList;
	}

	/**
	 * Move a patient to this ward
	 * @param p
	 * @return true if the patient is now in the ward, false if they're on the waiting list
	 */
	public boolean moveToWard(Patient p){
		// Check we aren't at capacity
		if(patients.size() < capacity){
			patients.add(p);
			return true;
		}else{
			// Ward is at capacity
			if(wardID == 1){
				// Waiting room, there is no waiting list
				return false;
			}else if(wardID == 2){
				// Emergency department, patient is dead :(
				// TODO deal with killing patients
				return false;
			}else{
				// Place patient on waiting list
				waitingList.add(p);
				return false;
			}
		}	
	}
	
	/**
	 * Patient has left the ward
	 * @param p the patient to be removed
	 */
	public void removeFromWard(Patient p){
		patients.remove(p);
	}
}
