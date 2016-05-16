package orion.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class CsvReaderPatients {
//	public static void main(String[] args) {
//		CsvReaderPatients crp = new CsvReaderPatients();
//		List<Patients> patientsList = crp.readCSVPatients();
//		System.out.println(patientsList.size());
//	}
	
	public List<Patient> readCSVPatients(){
		
		List<Patient> patientsList = new ArrayList<>();

		try {

			CsvReader products = new CsvReader("C:\\Users\\user\\Desktop\\OHHackathon\\patients.csv");

			products.readHeaders();

			while (products.readRecord()) {
				String patientID = products.get("patient_id");
				String patientName = products.get("name");
				String patientdob = products.get("date_of_birthity");
				String patientGender = products.get("gender");
				

				// perform program logic here
				Patient patient = new Patient(patientID, patientName, patientdob,patientGender);
				patientsList.add(patient);
				// Display
				//System.out.println(patientID + ":" + patientName + " : " + patientdob+ " : "+patientGender);
			}

			products.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return patientsList;

	}
}
