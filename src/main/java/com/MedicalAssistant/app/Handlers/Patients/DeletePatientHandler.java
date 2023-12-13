package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeletePatientHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String patient_id = context.pathParam("patient_id");
        int patientId = Integer.parseInt(patient_id);

        try{
            PatientDAO.delete(patientId);
            context.redirect("/technician?deletePatient=true");
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/technician?deletePatient=true");
    }
}

