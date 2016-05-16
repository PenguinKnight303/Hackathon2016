package orion.app.service;

public class Patient {
	private String patientId;
	private String patientName;
	private String patientDob;
	private String patientGender;
	private boolean dead;
	private boolean isWaiting;
	private WaitingList currentWaitingList;
	private Ward currentWard;
	
	public Patient(String patientId, String patientName, String patientDob, String patientGender){
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientDob = patientDob;
		this.patientGender = patientGender;
		this.dead = false;
		this.isWaiting = false;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
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
		currentWard.removeFromWard(this);
		currentWaitingList.remove(this);
	}

}
