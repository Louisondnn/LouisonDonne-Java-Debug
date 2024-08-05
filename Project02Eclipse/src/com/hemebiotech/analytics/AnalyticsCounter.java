package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static Map<String, Integer> symptomCounts;
	private static Object countSymptoms;
	private ISymptomReader reader;
    private ISymptomWriter writer;



	public static void main(String[] args) throws IOException {
	  // Instanciation

	  ReadSymptomDataFromFile symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
	  WriteSymptomDataToFile symptomWriter = new WriteSymptomDataToFile();

	  // Exécution des traitements dans le bon ordre
	  List<String> symptoms = symptomReader.getSymptoms();
	  Map<String, Integer> symptomCounts = symptomWriter.countSymptoms(symptoms);
	  Map<String, Integer> sortSymptoms = symptomWriter.sortSymptoms(symptomCounts);
	//   Map<String, Integer> symptomMap = symptomWriter.writeSymptoms(sortSymptoms);
	  symptomWriter.writeSymptoms(sortSymptoms);
	  
	
	}
}


	

