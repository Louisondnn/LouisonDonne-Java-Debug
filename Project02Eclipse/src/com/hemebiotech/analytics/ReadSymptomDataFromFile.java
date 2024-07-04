package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	public ReadSymptomDataFromFile() {
        //TODO Auto-generated constructor stub
    }
	
	// public List<String> getSymptoms() {
	// 	return reader.readSymptoms();
	// }
    @Override
	public List<String> readSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
// public void readSymptomss() {
	
// 	 throw new UnsupportedOperationException("Unimplemented method 'readSymptoms'");

// 	public Map<String, Integer> countSymptoms(List<String> symptoms) {
// 		Map<String, Integer> symptomCounts = new HashMap<>();
	
// 		for (String symptom : symptoms) {
// 			if (symptomCounts.containsKey(symptom)) {
// 				int count = symptomCounts.get(symptom) + 1;
// 				symptomCounts.put(symptom, count);
// 			} else {
// 				symptomCounts.put(symptom, 1);
// 			}
// 		}
	
// 		return symptomCounts;
// 	}




	@Override
	public List<String> GetSymptoms() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'GetSymptoms'");
	}


	public class SymptomCounter {
		public static void main(String[] args) throws Exception {
			// Create a map to store the symptom categories and their counts
			Map<String, Integer> symptomCounts = new HashMap<>();
		
				// Read the symptoms.txt file
				try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
					String line;
					while ((line = reader.readLine())!= null) {
						// Split 
						String[] symptoms = line.split(",");
		
						// Count
						for (String symptom : symptoms) {
							symptom = symptom.trim(); 
							if (symptomCounts.containsKey(symptom)) {
								// increment the count for this symptom
								symptomCounts.put(symptom, symptomCounts.get(symptom) + 1);
							} else {
								// first occurrence of this symptom
								symptomCounts.put(symptom, 1);
							}
						}
					}
				} catch (IOException e) {
					// errors
					System.err.println("Error reading file: " + e.getMessage());
				}
		
				// symptom counts
				System.out.println("Symptom Count:");
				for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
					System.out.println(entry.getKey() + ": " + entry.getValue());
				}
				System.out.println("Total Symptoms: " + symptomCounts.values().stream().mapToInt(i -> i).sum());
			}
		}

}
