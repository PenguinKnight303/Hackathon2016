package orion.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csvreader.CsvReader;

public class CsvReaderWard {
//	public static void main(String[] args) {
//		CsvReaderWard crp = new CsvReaderWard();
//		List<Ward> patientsList = crp.readCSVWard();
//		System.out.println(patientsList.size());
//
//	}
	
	public HashMap<Integer, Ward> readCSVWard(){
		
		HashMap<Integer, Ward> wardsList = new HashMap<Integer, Ward>();
		try {

			CsvReader products = new CsvReader("C:\\Users\\user\\Desktop\\OHHackathon\\wards.csv");

			products.readHeaders();

			while (products.readRecord()) {
				
				String wardID = products.get("patient_id");
				String wardName = products.get("ward_name");
				String capacity = products.get("capacity");
				
				
				// perform program logic here
				Ward ward = new Ward(wardID, wardName, capacity);
				wardsList.put(ward.getWardID(), ward);
				// Display
				//System.out.println(wardID + ":" + wardName+" : "+capacity);
			}

			products.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wardsList;
	}
}
