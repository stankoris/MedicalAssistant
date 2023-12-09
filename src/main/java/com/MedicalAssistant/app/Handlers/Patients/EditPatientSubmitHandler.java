package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Models.Patient;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.time.LocalDate;

public class EditPatientSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String patient_id = context.pathParam("patient_id");
        int patientId = Integer.parseInt(patient_id);


        Patient patient = PatientDAO.get(patientId);

        String date_of_birth = context.formParam("date_of_birth");
        String address = context.formParam("address");
        String email = context.formParam("email");
        String phone_number = context.formParam("phone_number");

        patient.setFirst_name(context.formParam("first_name"));
        patient.setLast_name(context.formParam("last_name"));
        if(date_of_birth != null && !date_of_birth.equals("")) patient.setDate_of_birth(LocalDate.parse(date_of_birth));
        if(address != null && !address.equals("")) patient.setAddress(address);
        if(email != null && !email.equals("")) patient.setEmail(email);
        patient.setJmbg(context.formParam("jmbg"));
        if(phone_number != null && !phone_number.equals("")) patient.setPhone_number(phone_number);

        if (address.equals("")) patient.setAddress(null);
        if (email.equals("")) patient.setEmail(null);
        if (phone_number.equals("")) patient.setPhone_number(null);

        try{
            PatientDAO.update(patient);
            context.redirect(String.format("/technician/edit/%d?updatePatient=true",patientId));
            return;
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect(String.format("/technician/edit/%d?updatePatient=true",patientId));
    }
}
