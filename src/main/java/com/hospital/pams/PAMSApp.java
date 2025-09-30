package com.hospital.pams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Main application class for Patient Appointment Management System (PAMS).
 * Creates patient data, converts to JSON, sorts by age, and writes to file.
 */
public class PAMSApp {
    
    public static void main(String[] args) {
        System.out.println("Patient Appointment Management System (PAMS) - Starting...");
        
        try {
            // Create array of Patient objects with provided data
            Patient[] patients = createPatientData();
            
            // Sort patients by age in descending order (oldest first)
            Arrays.sort(patients, Comparator.comparing(Patient::getAge).reversed());
            
            // Convert to JSON and write to file
            writePatientsToJsonFile(patients);
            
            System.out.println("Patient data successfully processed and written to patients.json");
            System.out.println("Patients sorted by age (oldest to youngest):");
            
            // Display sorted patients
            for (Patient patient : patients) {
                System.out.printf("ID: %d, Name: %s %s, Age: %d%n", 
                    patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getAge());
            }
            
        } catch (Exception e) {
            System.err.println("Error processing patient data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Creates an array of Patient objects with the provided test data
     * @return array of Patient objects
     */
    private static Patient[] createPatientData() {
        return new Patient[]{
            new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
            new Patient(2, "Ana", "Smith", null, "amsith@te.edu", null, LocalDate.of(1948, 12, 5)),
            new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave", LocalDate.of(2001, 9, 18)),
            new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null, LocalDate.of(1995, 2, 28)),
            new Patient(5, "Mary", "Washington", null, null, "30 W Burlington", LocalDate.of(1932, 5, 31))
        };
    }
    
    /**
     * Converts patient array to JSON format and writes to file
     * @param patients array of Patient objects
     * @throws IOException if file writing fails
     */
    private static void writePatientsToJsonFile(Patient[] patients) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        // Configure mapper for pretty printing and Java 8 time support
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // Write to file
        File outputFile = new File("patients.json");
        mapper.writeValue(outputFile, patients);
        
        System.out.println("JSON data written to: " + outputFile.getAbsolutePath());
    }
}
