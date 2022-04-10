package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	// TO DO: Implement HIPAACompliantUser!
    // TO DO: Constructor that takes an ID
    
    public Physician(int i) {
    	super(i);
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    
    @Override
    public boolean assignPin(int pin) {
    	if (pin <= 1000 && pin >= 9999) {
    		System.out.println("Pin must be at least 4 digits.");
    		return false;
    	}
    		this.pin = pin;
    		return true;
    }
    
    @Override
    public boolean accessAuthorized(Integer comfirmedAuthID) {
    	if(this.pin == comfirmedAuthID) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
	
    // TO DO: Setters & Getters

}
