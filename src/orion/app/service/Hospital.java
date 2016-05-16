package orion.app.service;

import java.util.List;

public class Hospital {

	private List<Ward> wardList;
	private List<Patient> patientList;
	private List<Movements> movementList;
	
	
	public List<Ward> getWardList() {
		CsvReaderWard crw = new CsvReaderWard();
		wardList = crw.readCSVWard();
		return wardList;
	}

	public void setWardList(List<Ward> wardList) {
		this.wardList = wardList;
	}

	public List<Patient> getPatientList() {
		CsvReaderPatients crp = new CsvReaderPatients();
		patientList = crp.readCSVPatients();
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public List<Movements> getMovementList() {
		CsvReaderMovements crm = new CsvReaderMovements();
		movementList = crm.readCSVMovement();
		return movementList;
	}

	public void setMovementList(List<Movements> movementList) {
		this.movementList = movementList;
	}

	

//	public static void main(String[] args) {
//		Hospital h = new Hospital();
//		List<Patient> pat = h.getPatientList();
//		System.out.println(pat.size());
//	}

}
