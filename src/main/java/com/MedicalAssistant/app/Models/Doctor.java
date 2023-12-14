package com.MedicalAssistant.app.Models;

import java.io.Serializable;

public class Doctor implements Serializable {
    private int doctor_id;
    private String first_name;
    private String last_name;
    private String email;


    public Doctor() {}
    public Doctor(int doctor_id, String first_name, String last_name, String email) {
        this.doctor_id = doctor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String full_name() {
        return String.format("%s %s",this.first_name, this.last_name);
    }
}
