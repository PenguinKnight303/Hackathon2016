package orion.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

public class CsvReaderExample {
	public static void main(String[] args) {
		try {

			CsvReader products = new CsvReader("res\\wards.csv");

			products.readHeaders();

			while (products.readRecord()) {
				String wardID = products.get("ward_id");
				String wardName = products.get("ward_name");
				String capacity = products.get("capacity");
				
				
				// perform program logic here
				Ward ward = new Ward(wardID, wardName, capacity);
				
				// Display
				System.out.println(wardID + ":" + wardName+" : "+capacity);
			}

			products.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
