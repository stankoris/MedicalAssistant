package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Models.Patient;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.HashMap;

public class NewPatientHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.formParam("first_name");
        String last_name = context.formParam("last_name");
        String date_of_birth = context.formParam("date_of_birth");
        String email = context.formParam("email");
        String jmbg = context.formParam("jmbg");


        HashMap<String, Object> patient_data = new HashMap<>();

        if(first_name != null && !first_name.equals("")) patient_data.put("first_name", first_name);
        if(last_name != null && !last_name.equals("")) patient_data.put("last_name", last_name);
        if(date_of_birth != null && !date_of_birth.equals("")) patient_data.put("date_of_birth", date_of_birth);
        if(email != null && !email.equals("")) patient_data.put("email", email);
        if(jmbg != null && !jmbg.equals("")) patient_data.put("jmbg", jmbg);

        Patient patient = new Patient(patient_data);
        try {
            PatientDAO.save(patient);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
