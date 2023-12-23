package com.MedicalAssistant.app.Handlers.Tehnician;

import com.MedicalAssistant.app.Database.DAO.AppointmentsDAO;
import com.MedicalAssistant.app.Database.DAO.DoctorDAO;
import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class TechnicianDashboardHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {

        HashMap<String, Object> dataModel = new HashMap<>();

        dataModel.put("patients", PatientDAO.all());

        dataModel.put("doctors", DoctorDAO.all());

        dataModel.put("appointments", AppointmentsDAO.all());

        context.html(Renderer.render("technician/technician_dashboard.ftl", dataModel));
    }
}
