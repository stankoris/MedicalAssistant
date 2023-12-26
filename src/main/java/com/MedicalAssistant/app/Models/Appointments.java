package com.MedicalAssistant.app.Models;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.HashMap;

public class Appointments implements Serializable {
    private int appointment_id;
    private int patient_id;
    private int doctor_id;
    private Date date;
    private Time time;
    private int status;


    public Appointments() {}

    public Appointments(int appointment_id, int patient_id, int doctor_id, Date date, Time time, int status) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Appointments(HashMap<String, Object> appointment_data) {
        if(appointment_data.containsKey("patient_id")) {
            this.patient_id = (int) appointment_data.get("patient_id");
        }
        if(appointment_data.containsKey("patient_id")) {
            this.patient_id = (int) appointment_data.get("patient_id");
        }
        if(appointment_data.containsKey("date")) {
            this.date = (Date) appointment_data.get("date");
        }
        if(appointment_data.containsKey("time")) {
            this.time = (Time) appointment_data.get("time");
        }
        if(appointment_data.containsKey("status")) {
            this.status = (int) appointment_data.get("status");
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
