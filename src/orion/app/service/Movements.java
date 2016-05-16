package orion.app.service;

public class Movements {
	private String event_index;
	private String patient_id;
	private String from_ward;
	private String to_ward;
	private String movement_date;

	public Movements(String event_index, String patient_id, String from_ward, String to_ward, String movement_date){
		this.event_index = event_index;
		this.patient_id = patient_id;
		this.from_ward = from_ward;
		this.to_ward = to_ward;
		this.movement_date = movement_date;

	}



	public String getEvent_index() {
		return event_index;
	}

	public void setEvent_index(String event_index) {
		this.event_index = event_index;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
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






}
