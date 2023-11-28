package com.MedicalAssistant.app.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Patient implements Serializable {
    private int patient_id;
    private String first_name;
    private String last_name;
    private LocalDate date_of_birth;
    private String email;
    private String jmbg;

    public Patient() {}

    public Patient(HashMap<String, Object> patient_data) {
        if(patient_data.containsKey("patient_id")) {
            this.patient_id = (int) patient_data.get("patient_id");
        }
        if(patient_data.containsKey("first_name")) {
            this.first_name = (String) patient_data.get("first_name");
        }
        if(patient_data.containsKey("last_name")) {
            this.last_name = (String) patient_data.get("last_name");
        }
        if(patient_data.containsKey("date_of_birth")) {
            if(patient_data.get("date_of_birth") instanceof String) {
                this.date_of_birth = LocalDate.parse( (String) patient_data.get("date_of_birth"));
            }else {
                this.date_of_birth = (LocalDate) patient_data.get("date_of_birth");
            }
        }
        if(patient_data.containsKey("email")) {
            this.email = (String) patient_data.get("email");
        }
        if(patient_data.containsKey("jmbg")) {
            this.jmbg = (String) patient_data.get("jmbg");
        }

    }
    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
