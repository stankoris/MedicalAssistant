package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class FindPatientsHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.queryParam("first_name");
        HashMap<String, Object> modelData = new HashMap<>();

        modelData.put("patients", PatientDAO.find(first_name));

        context.html(Renderer.render("patients/find_patient.ftl",modelData));
    }
}
