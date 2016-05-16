package orion.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class CsvReaderMovements {
//	public static void main(String[] args) {
//		
//		CsvReaderMovements crm = new CsvReaderMovements();
//		List<Movements> allList = crm.readCSVMovement();
//		System.out.println("The total size is: "+allList.size());
//	}
	
	public List<Movements> readCSVMovement(){
		
		List<Movements> movementList = new ArrayList<>();
		try {

			CsvReader products = new CsvReader("C:\\Users\\user\\Desktop\\OHHackathon\\movements.csv");

			products.readHeaders();

			while (products.readRecord()) {
				
				String event_index = products.get("event_index");
				String patient_id = products.get("patient_id");
				String from_ward = products.get("from_ward");
				String to_ward = products.get("to_ward");
				String movement_date = products.get("movement_date");
				
				// perform program logic here
				Movements movement = new Movements(event_index, patient_id, from_ward,to_ward,movement_date);
				movementList.add(movement);
				
				// Display
				//System.out.println(event_index + ":" + patient_id+" : "+from_ward+" : "+ to_ward  +" : "+movement_date);
			}

			products.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return movementList;
	}
}
