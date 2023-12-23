package com.MedicalAssistant.app.Handlers.Appointment;
import com.MedicalAssistant.app.Database.DAO.DoctorDAO;
import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class NewAppointmentHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {

        HashMap<String, Object> modelData = new HashMap<>();

        String patientId = context.pathParam("patient_id");
        modelData.put("patient_id", patientId);


        modelData.put("patients", PatientDAO.all());
        modelData.put("doctors", DoctorDAO.all());

        context.html(Renderer.render("appointments/new_appointment.ftl", modelData));
    }
}
