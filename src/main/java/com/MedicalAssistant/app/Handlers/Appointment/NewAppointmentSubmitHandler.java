package com.MedicalAssistant.app.Handlers.Appointment;

import com.MedicalAssistant.app.Database.DAO.AppointmentsDAO;
import com.MedicalAssistant.app.Models.Appointments;
import com.MedicalAssistant.app.Models.Patient;
import io.javalin.http.Context;
import io.javalin.http.Handler;


import java.time.LocalDateTime;
import java.util.HashMap;


public class NewAppointmentSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String patient_id = context.formParam("patient_id");
        int patienId = Integer.parseInt(patient_id);
        String doctor_id = context.formParam("doctor_id");
        int doctorId = Integer.parseInt(doctor_id);
        String date_time = context.formParam("date_time");
        LocalDateTime dateTime = LocalDateTime.parse(date_time);

        HashMap<String, Object> patient_data = new HashMap<>();

        if(patient_id != null && !patient_id.equals("")) patient_data.put("patien_id", patienId);
        if(doctor_id != null && !doctor_id.equals("")) patient_data.put("doctor_id", doctorId);
        if(date_time != null && !date_time.equals("")) patient_data.put("date_time", dateTime);

        try{

            AppointmentsDAO.add(patienId,doctorId,dateTime);
            context.redirect("/technician");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
