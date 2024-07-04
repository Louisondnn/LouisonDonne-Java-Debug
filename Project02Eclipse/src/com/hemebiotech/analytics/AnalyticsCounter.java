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
	private ISymptomReader reader;
    private ISymptomWriter writer;

    // public AnalyticsCounter() {
    //     this.reader = reader;
    //     this.writer = writer;
    // }


	



public class Main {
	public static void main(String[] args) {
	  // Instanciation 

	  ReadSymptomDataFromFile symptomReader = new ReadSymptomDataFromFile( "/com/hemebiotech/ReadSymptomDataFromFile.java");
	  WriteSymptomDataToFile symptomWriter = new WriteSymptomDataToFile();
	  AnalyticsCounter analyticsCounter = new AnalyticsCounter(IsymptomReader, IsymptomWriter);

	  // Exécution des traitements dans le bon ordre
	  analyticsCounter.readSymptoms("com/hemebiotech/ISymptomReader.java");
	  analyticsCounter.processSymptoms();
	  analyticsCounter.writeAnalytics("com/hemebiotech/analytics/output.txt");
  }
  }




}





		
	

