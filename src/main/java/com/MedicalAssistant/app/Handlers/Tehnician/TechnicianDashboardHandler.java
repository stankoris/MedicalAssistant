package com.MedicalAssistant.app.Handlers.Tehnician;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class TechnicianDashboardHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> dataModel = new HashMap<>();

        if(context.queryParam("savePatient") != null) {
            dataModel.put("savePatient", context.queryParam("savePatient"));
        }

        if(context.queryParam("updatePatient") != null) {
            dataModel.put("updatePatient", context.queryParam("updatePatient"));
        }

        dataModel.put("patients", PatientDAO.all());

        context.html(Renderer.render("technician/technician_dashboard.ftl", dataModel));
    }
}
