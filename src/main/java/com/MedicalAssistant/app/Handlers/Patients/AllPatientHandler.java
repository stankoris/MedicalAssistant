package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class AllPatientHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> modelData = new HashMap<>();

        modelData.put("patients", PatientDAO.all());
        context.html(Renderer.render("patients/all_patients.ftl", modelData));
    }
}
