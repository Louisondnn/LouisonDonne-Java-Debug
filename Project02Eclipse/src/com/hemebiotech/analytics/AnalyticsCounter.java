package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hemebiotech.ISymptomWriter;

public class AnalyticsCounter {
	private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }


	public List<String> getSymptoms() {
	return reader.readSymptoms();
}

public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> symptomCounts = new HashMap<>();

    for (String symptom : symptoms) {
        if (symptomCounts.containsKey(symptom)) {
            int count = symptomCounts.get(symptom) + 1;
            symptomCounts.put(symptom, count);
        } else {
            symptomCounts.put(symptom, 1);
        }
    }

    return symptomCounts;
}

public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return symptoms.entrySet().stream()
            .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
}

public void writeSymptoms(Map<String, Integer> symptoms) {
    for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.writeSymptom(entry.getKey(), entry.getValue());
    }
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





		
	

