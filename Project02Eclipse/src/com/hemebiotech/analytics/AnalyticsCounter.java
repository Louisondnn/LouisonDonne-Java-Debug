package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static Map<String, Integer> symptomCounts;
	private static Object countSymptoms;
	private ISymptomReader reader;
    private ISymptomWriter writer;



	public static void main(String[] args) {
	  // Instanciation 

	  ReadSymptomDataFromFile symptomReader = new ReadSymptomDataFromFile();
	  WriteSymptomDataToFile symptomWriter = new WriteSymptomDataToFile();

	  // Exécution des traitements dans le bon ordre
	  System.out.println();
	  ((ISymptomReader) symptomReader).readSymptoms();
	  ((ISymptomWriter) symptomWriter).writeSymptoms(symptomCounts);
	  ((ISymptomWriter) symptomWriter).countSymptoms();

	//   symptomReader.symptomCounter();
  
//   List<String> symptoms = symptomReader.readSymptoms();
// 	  symptomWriter.writeSymptoms(symptoms);
// 	  symptomWriter.countSymptoms(symptoms);
// 	  symptomWriter.sortSymptoms(symptomCounts);

	//   Map<String, Integer> symptomCounts = symptomWriter.countSymptoms(symptoms);
	//   symptomCounts = symptomWriter.sortSymptoms(symptomCounts);
	//   symptomWriter.writeSymptoms(symptomCounts);
	  
	 

  }





}





		
	

