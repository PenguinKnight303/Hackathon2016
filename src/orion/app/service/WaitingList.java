package orion.app.service;

import java.util.ArrayList;
import java.util.List;

/**
 * The waiting list for a given ward
 * @author sbutc
 *
 */
public class WaitingList {
	private int wardId;
	private List<Patient> patients;
	
	public WaitingList(int id){
		wardId = id;
		patients = new ArrayList<Patient>();
	}

	/**
	 * Add a patient to the waiting list
	 * @param p the patient
	 */
	public void add(Patient p){
		patients.add(p);
	}
}
