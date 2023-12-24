package com.MedicalAssistant.app.Handlers.Appointment;

import com.MedicalAssistant.app.Database.DAO.DoctorDAO;
import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Models.Patient;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.time.LocalDateTime;
import java.util.HashMap;

public class NewAppointmentHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String patient_id = context.queryParam("patient_id");
        String doctor_id = context.queryParam("doctor_id");
        String date_time = context.queryParam("date_time");


        HashMap<String, Object> dataModel = new HashMap<>();

        dataModel.put("patient_id", patient_id);
        dataModel.put("doctor_id", doctor_id);
        dataModel.put("date_time", date_time);

        dataModel.put("patients", PatientDAO.all());
        dataModel.put("doctors", DoctorDAO.all());

        context.html(Renderer.render("appointments/new_appointment.ftl", dataModel));
    }
}
