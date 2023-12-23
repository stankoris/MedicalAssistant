package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class FindPatientsSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.formParam("first_name");

        try {
            PatientDAO.find(first_name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
