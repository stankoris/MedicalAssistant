package com.MedicalAssistant.app.Handlers.Appointment;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.HashMap;

public class NewAppointmentHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String patient_id = context.queryParam("patient_id");
        String date = context.queryParam("date");
        String time = context.queryParam("time");

        HashMap<String, Object> dataModel = new HashMap<>();

        dataModel.put("patient_id", patient_id);
        dataModel.put("date", date);
        dataModel.put("time", time);

        dataModel.put("patients", PatientDAO.all());

        context.html(Renderer.render("appointments/new_appointment.ftl", dataModel));
    }
}
