package orion.app.service;

/**
 * Class representing a patient in the hospital
 * Patients know the ward and waiting lists they are currently in and are
 * responsible for removing themselves from these if they are moved
 * @author sbutc
 *
 */
public class Patient {
	private int patientId;
	private String patientName;
	private String patientDob;
	private String patientGender;
	private boolean dead;
	private boolean isWaiting;
	private WaitingList currentWaitingList;
	private Ward currentWard;
	
	public Patient(String patientId, String patientName, String patientDob, String patientGender){
		this.patientId = Integer.parseInt(patientId);
		this.patientName = patientName;
		this.patientDob = patientDob;
		this.patientGender = patientGender;
		this.dead = false;
		this.isWaiting = false;
		currentWaitingList = null;
		currentWard = null;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientDob() {
		return patientDob;
	}

	public void setPatientDob(String patientDob) {
		this.patientDob = patientDob;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	
	/**
	 * Patient was moved to the Emergency department when it was full
	 * Notify the current ward and waiting list that this patient has been removed
	 */
	public void patientDied(){
		dead = true;
		// Remove patient from their current ward
		removeFromCurrentWard();
		currentWard = null;
		// Remove patient from their current waiting list
		removeFromCurrentWaitingList();
		currentWaitingList = null;
	}

	/**
	 * The patient has been placed in a new ward
	 * @param w the ward
	 */
	public void movedToWard(Ward w){
		// Remove patient from their current ward and waiting list
		removeFromCurrentWard();
		removeFromCurrentWaitingList();
		currentWard = w;
		currentWaitingList = null;
	}
	
	/**
	 * The patient has been placed on a waiting list
	 * @param wL the waiting list
	 */
	public void placedOnList(WaitingList wL){
		// Remove the patient from any previous waiting lists
		removeFromCurrentWaitingList();
		currentWaitingList = wL;
	}

	private void removeFromCurrentWard(){
		if(currentWard != null){
			currentWard.removeFromWard(this);
		}
	}
	
	private void removeFromCurrentWaitingList() {
		if(currentWaitingList != null){
			currentWaitingList.remove(this);
		}
	}

	public void discharge() {
		// Remove patient from current ward and waiting list
		removeFromCurrentWard();
		removeFromCurrentWaitingList();
		currentWard = null;
		currentWaitingList = null;
	}
}
