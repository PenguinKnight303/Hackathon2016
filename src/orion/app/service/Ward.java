package orion.app.service;

import java.util.ArrayList;
import java.util.List;

public class Ward {
	private int wardID;
	private String wardName;
	private int capacity;
	private List<Patient> patients;
	private WaitingList waitingList;
	
	/**
	 * Constructor
	 */
	public Ward(String id, String name, String cap){
		wardID = Integer.parseInt(id);
		wardName = name;
		capacity = Integer.parseInt(cap);
		patients = new ArrayList<Patient>();
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public int getWardID() {
		return wardID;
	}

	public void setWardID(int wardID) {
		this.wardID = wardID;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
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
}
