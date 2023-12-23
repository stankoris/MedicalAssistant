package com.MedicalAssistant.app.Handlers.Appointment;

import com.MedicalAssistant.app.Database.DAO.AppointmentsDAO;
import com.MedicalAssistant.app.Database.DAO.DoctorDAO;
import com.MedicalAssistant.app.Database.DAO.PatientDAO;
import com.MedicalAssistant.app.Models.Appointments;
import com.MedicalAssistant.app.Models.Doctor;
import com.MedicalAssistant.app.Models.Patient;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;

public class NewAppointmentSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {

        String patient_id = context.pathParam("patient_id");
        int patientId = Integer.parseInt(patient_id);
        Patient patient = PatientDAO.get(patientId);

        String doctor_id = context.pathParam("doctor_id");
        int doctorId = Integer.parseInt(doctor_id);
        Doctor doctor = DoctorDAO.get(doctorId);

        String date_time = context.formParam("date_time");



        HashMap<String, Object> appointment_data = new HashMap<>();

        appointment_data.put("patient_id", patient);
        appointment_data.put("doctor_id", doctor);
        if(date_time != null && !date_time.equals("")) appointment_data.put("date_time", date_time);

        Appointments appointment = new Appointments(appointment_data);


        try {
            int affected = AppointmentsDAO.add(appointment);
            if(affected > 0) {
                context.redirect("/technician/new_appointment?saveAppoinment=true");
                return;
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        context.redirect("/technician/new_appointment?saveAppointment=false");
    }
}
