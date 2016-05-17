package orion.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
		patients = new ArrayList<Patient>();
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
			p.movedToWard(this);
			return true;
		}else{
			// Ward is at capacity
			if(wardID == 1){
				// Waiting room, there is no waiting list
				return false;
			}else if(wardID == 2){
				// Emergency department, patient is dead :(
				p.patientDied();
				return false;
			}else{
				// Place patient on waiting list
				waitingList.add(p);
				p.placedOnList(waitingList);
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
		// TODO There may be patients on the waiting list and space in the ward now
		try{
			Patient topOfList = waitingList.getNextPatient();
			moveToWard(p);
		}catch(NoSuchElementException e){
			// Great, the waiting list is empty, don't need to do anything
		}
	}
	
	public String toString(){
		return "Ward: " + wardID + "\n" +
				"Name: " + wardName + "\n" +
				"Capacity: " + capacity + "\n" +
				"Patients: " + patients.size() + "\n" +
				"Waiting List: " + waitingList.size();
	}
}
