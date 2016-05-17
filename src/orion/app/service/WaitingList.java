package orion.app.service;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The waiting list for a given ward
 * @author sbutc
 *
 */
public class WaitingList {
	private int wardId;
	private LinkedList<Patient> patients;
	
	public WaitingList(int id){
		wardId = id;
		patients = new LinkedList<Patient>();
	}

	/**
	 * Add a patient to the waiting list
	 * @param p the patient
	 */
	public void add(Patient p){
		patients.add(p);
	}
	
	/**
	 * Remove a patient from the waiting list, they have either died or the transfer
	 * has been cancelled
	 * @param p the patient
	 */
	public void remove(Patient p){
		patients.remove(p);
	}
	
	/**
	 * There is a space in the ward, get the patient at the start of the list
	 * @return
	 */
	public Patient getNextPatient() throws NoSuchElementException{
		return patients.pop();
	}
}
