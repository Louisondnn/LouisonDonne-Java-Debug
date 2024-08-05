package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    Object countSymptoms = null;

    /**
     * Writes symptoms to a destination, such as a file or database.
     * 
     * @param symptoms A map of symptoms where the key is the symptom name and the value is the count of occurrences.
     */
   
public void writeSymptoms(Map<String, Integer> symptoms);

    public void writeSymptom(String key, Integer value);

    
   
}
