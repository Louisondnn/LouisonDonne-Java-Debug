package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WriteSymptomDataToFile implements ISymptomWriter {
  
    /**
     * Writes symptoms to a file.
     * 
     * @param symptoms A map of symptoms where the key is the symptom name and the value is the count of occurrences.
     */
    
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter("symptoms.txt")) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
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

@Override
public void writeSymptom(String key, Integer value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'writeSymptom'");
}

@Override
public void countSymptoms() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'countSymptoms'");
}
    }
    

