package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.BufferedReader;

import com.hemebiotech.ISymptomWriter;

public class AnalyticsCounter {
	private ISymptomReader reader;
    private ISymptomWriter writer;
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;


	// public static <ReadSymptomDataFromFile> void main(String[] args) {

		public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

}
	  // Instanciation 

// 	  ReadSymptomDataFromFile symptomReader = new ReadSymptomDataFromFile( "symptoms.txt");
// 	  WriteSymptomDataToFile symptomWriter = new WriteSymptomDataToFile("result.out");

// 	  // Exécution des traitements dans le bon ordre
// 	  System.out.println();
// 	  ((ISymptomReader) symptomReader).readSymptoms();
// 	  ((Object) symptomReader).symptomCounter();
// 	  ((Object) symptomReader).symptomCounter();
  
//   List<String> symptoms = symptomReader.readSymptoms();
// // 	  symptomWriter.writeSymptoms(symptoms);
// // 	  symptomWriter.countSymptoms(symptoms);
// // 	  symptomWriter.sortSymptoms(symptomCounts);

// 	  Map<String, Integer> symptomCounts = symptomWriter.countSymptoms(symptoms);
// 	  symptomCounts = symptomWriter.sortSymptoms(symptomCounts);
// 	  symptomWriter.writeSymptoms(symptomCounts);
	  
// 	  List<String> symptoms = readSymptomData.getSymptoms();
// 	  // compter les symptomes

// 	  HashMap<String, Integer> symptomsAnalytics = readSymptomData.countSymptoms();

//   }





// }





		
	

