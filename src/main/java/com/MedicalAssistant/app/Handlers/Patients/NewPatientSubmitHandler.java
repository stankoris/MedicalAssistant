package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Models.Patient;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.HashMap;

public class NewPatientSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.formParam("first_name");
        String last_name = context.formParam("last_name");
        String date_of_birth = context.formParam("date_of_birth");
        String address = context.formParam("address");
        String email = context.formParam("email");
        String jmbg = context.formParam("jmbg");
        String phone_number = context.formParam("phone_number");

        HashMap<String, Object> patient_data = new HashMap<>();

        if(first_name != null && !first_name.equals("")) patient_data.put("first_name", first_name);
        if(last_name != null && !last_name.equals("")) patient_data.put("last_name", last_name);
        if(date_of_birth != null && !date_of_birth.equals("")) patient_data.put("date_of_birth", date_of_birth);
        if(address != null && !address.equals("")) patient_data.put("address", address);
        if(email != null && !email.equals("")) patient_data.put("email", email);
        if(jmbg != null && !jmbg.equals("")) patient_data.put("jmbg", jmbg);
        if(phone_number != null && !phone_number.equals("")) patient_data.put("phone_number", phone_number);

        Patient patient = new Patient(patient_data);
        ArrayList<Patient> patients = PatientDAO.all();

        try {
            for(Patient p : patients) {

                if(p.getJmbg().equals(jmbg))  {
                    context.redirect("/technician/new_patient?jmbg=true");
                    return;
                }
            }

            int affected = PatientDAO.save(patient);
            if(affected > 0) {
                context.redirect("/technician/new_patient?savePatient=true");
                return;
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/technician/new_patient?savePatient=false");
    }
}
