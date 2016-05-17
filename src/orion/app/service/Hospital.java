package orion.app.service;

import java.util.HashMap;
import java.util.List;

public class Hospital {

	private HashMap<Integer, Ward> wardList;
	private HashMap<Integer, Patient> patientList;
	private List<Movement> movementList;
	
	public Hospital(){
		initialisePatients();
		initialiseWards();
		initialiseMovementList();
	}
	
	public HashMap<Integer, Ward> initialiseWards() {
		CsvReaderWard crw = new CsvReaderWard();
		wardList = crw.readCSVWard();
		return wardList;
	}

	public HashMap<Integer, Patient> initialisePatients() {
		CsvReaderPatients crp = new CsvReaderPatients();
		patientList = crp.readCSVPatients();
		return patientList;
	}

	public List<Movement> initialiseMovementList() {
		CsvReaderMovements crm = new CsvReaderMovements(this);
		movementList = crm.readCSVMovement();
		return movementList;
	}
	
	public HashMap<Integer, Ward> getWards(){
		return wardList;
	}
	
	public HashMap<Integer, Patient> getPatients(){
		return patientList;
	}
	
	public List<Movement> getMovementList(){
		return movementList;
	}

	public void setMovementList(List<Movement> movementList) {
		this.movementList = movementList;
	}

	public int getDeaths(){
		int dead = 0;
		for(Patient p : patientList.values()){
			if(p.isDead()){
				dead++;
			}
		}
		
		return dead;
	}

	public static void main(String[] args) {
		Hospital h = new Hospital();
		int limit = 0;
		for(Movement m : h.getMovementList()){
			m.execute();
			limit++;
			if(limit > Integer.MAX_VALUE){
				break;
			}
		}
		for(Ward w : h.wardList.values()){
			System.out.println(w.toString());
		}
		System.out.println("Dead: " + h.getDeaths());
	}

}
