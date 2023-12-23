package com.MedicalAssistant.app.Models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Appointments implements Serializable {
    private int appointment_id;
    private int patient_id;
    private int doctor_id;
    private LocalDateTime date_time;


    public Appointments() {}

    public Appointments(int appointment_id, int patient_id, int doctor_id, LocalDateTime date_time) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date_time = date_time;
    }

    public Appointments(HashMap<String, Object> appointment_data) {
        if(appointment_data.containsKey("patient_id")) {
            this.patient_id = (int) appointment_data.get("patient_id");
        }
        if(appointment_data.containsKey("doctor_id")) {
            this.patient_id = (int) appointment_data.get("doctor_id");
        }
        if(appointment_data.containsKey("patient_id")) {
            this.patient_id = (int) appointment_data.get("patient_id");
        }
        if(appointment_data.containsKey("date_time")) {
            if(appointment_data.get("date_time") instanceof String) {
                this.date_time = LocalDateTime.parse( (String) appointment_data.get("date_time"));
            }else {
                this.date_time = (LocalDateTime) appointment_data.get("date_time");
            }
        }
    }


    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }


    // Metoda za formatiranje vremena
    public String formatDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date_time.format(formatter);
    }

    // Metoda za provjeru budućnosti
    public boolean isFutureAppointment() {
        LocalDateTime now = LocalDateTime.now();
        return date_time.isAfter(now);
    }
}
