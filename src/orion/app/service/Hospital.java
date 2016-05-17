package orion.app.service;

import java.util.HashMap;
import java.util.List;

public class Hospital {

	private HashMap<Integer, Ward> wardList;
	private HashMap<Integer, Patient> patientList;
	private List<Movement> movementList;
	
	
	public HashMap<Integer, Ward> getWards() {
		CsvReaderWard crw = new CsvReaderWard();
		wardList = crw.readCSVWard();
		return wardList;
	}

	public HashMap<Integer, Patient> getPatients() {
		CsvReaderPatients crp = new CsvReaderPatients();
		patientList = crp.readCSVPatients();
		return patientList;
	}

	public List<Movement> getMovementList() {
		CsvReaderMovements crm = new CsvReaderMovements();
		movementList = crm.readCSVMovement();
		return movementList;
	}

	public void setMovementList(List<Movement> movementList) {
		this.movementList = movementList;
	}

	

//	public static void main(String[] args) {
//		Hospital h = new Hospital();
//		List<Patient> pat = h.getPatientList();
//		System.out.println(pat.size());
//	}

}
