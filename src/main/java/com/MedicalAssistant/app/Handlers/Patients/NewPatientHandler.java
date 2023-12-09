package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class NewPatientHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> dataModel = new HashMap<>();

        if(context.queryParam("savePatient") != null) {
            dataModel.put("savePatient", context.queryParam("savePatient"));
        }

        dataModel.put("patients", PatientDAO.all());

        context.html(Renderer.render("patients/new_patient.ftl", dataModel));
    }
}
