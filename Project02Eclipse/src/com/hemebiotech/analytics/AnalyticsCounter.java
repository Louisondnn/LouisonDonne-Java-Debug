package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	// public static void main(String args[]) throws Exception {
		// // first get input
		// BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		// String line = reader.readLine();

		// int i = 0;	// set i to 0
		// int headCount = 0;	// counts headaches
		// while (line != null) {
		// 	i++;	// increment i
		// 	System.out.println("symptom from file: " +  line);
		// 	if (line.equals("headache")) {
		// 		headCount++;
		// 		System.out.println("number of headaches: " + headCount);
		// 	}
		// 	else if (line.equals("rush")) {
		// 		rashCount++;
		// 	}
		// 	else if (line.contains("pupils")) {
		// 		pupilCount++;
		// 	}
			
		// 	// nombre d'occurences 

		// 	line = reader.readLine();	// get another symptom
		// } 
		// reader.close(); 

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


    // // Helper method to get the category for a symptom
    // private static String getCategory(String symptom) {
    //     // You can add more categories as needed
    //     if (symptom.contains("flashback") || symptom.contains("memory") || symptom.contains("dream")) {
    //         return "Re-experiencing symptoms";
    //     } else if (symptom.contains("avoid") || symptom.contains("stay away")) {
    //         return "Avoidance symptoms";
    //     } else if (symptom.contains("startle") || symptom.contains("tense") || symptom.contains("irritable")) {
    //         return "Arousal and reactivity symptoms";
    //     } else {
    //         return "Cognition and mood symptoms";
    //     }
    // }



		
	
}
