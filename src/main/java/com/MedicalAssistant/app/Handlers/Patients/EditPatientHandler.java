package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Models.Patient;
import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class EditPatientHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
            String patient_id = context.pathParam("patient_id");
            Patient patient = PatientDAO.get(Integer.parseInt(patient_id));

            HashMap<String, Object> modelData = new HashMap<>();
            modelData.put("patient", patient);


        if(context.queryParam("updatePatient") != null) {
            modelData.put("updatePatient", context.queryParam("updatePatient"));
        }

        modelData.put("patients", PatientDAO.all());

        context.html(Renderer.render("patients/edit_patient.ftl", modelData));
    }
}
