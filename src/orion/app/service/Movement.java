package orion.app.service;

import java.util.HashMap;

public class Movement {
	private String event_index;
	private int patient_id;
	private String from_ward;
	private String to_ward;
	private String movement_date;
	private Hospital hospital;
	private boolean moveSuccessful;

	public Movement(String event_index, String patient_id, String from_ward, String to_ward, String movement_date, Hospital h){
		this.event_index = event_index;
		this.patient_id = Integer.parseInt(patient_id);
		this.from_ward = from_ward;
		this.to_ward = to_ward;
		this.movement_date = movement_date;
		hospital = h;
	}



	public String getEvent_index() {
		return event_index;
	}

	public void setEvent_index(String event_index) {
		this.event_index = event_index;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getFrom_ward() {
		return from_ward;
	}

	public void setFrom_ward(String from_ward) {
		this.from_ward = from_ward;
	}

	public String getTo_ward() {
		return to_ward;
	}

	public void setTo_ward(String to_ward) {
		this.to_ward = to_ward;
	}

	public String getMovement_date() {
		return movement_date;
	}

	public void setMovement_date(String movement_date) {
		this.movement_date = movement_date;
	}

	/**
	 * Executes the movement
	 */
	public void execute(){
		// Get the patients and wards
		HashMap<Integer, Patient> patients = hospital.getPatients();
		HashMap<Integer, Ward> wards = hospital.getWards();
		
		Patient patient = patients.get(patient_id);
		
		// Check if the patient is being discharged
		if(!to_ward.equals("discharging")){
			Ward toWard = wards.get(Integer.parseInt(to_ward));
			// Attempt to move the patient to the ward
			moveSuccessful = toWard.moveToWard(patient);
		}else{
			// Patient is being discharged
			patient.discharge();
			// Discharging is always successful
			moveSuccessful = true;
		}
	}




}
