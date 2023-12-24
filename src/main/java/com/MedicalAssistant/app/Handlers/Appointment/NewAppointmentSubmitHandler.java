package com.MedicalAssistant.app.Handlers.Appointment;

import com.MedicalAssistant.app.Database.DAO.AppointmentsDAO;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.json.JSONObject;
import java.time.LocalDateTime;

public class NewAppointmentSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        JSONObject json = new JSONObject(context.body());

        int patientId = json.getInt("patient_id");
        int doctorId = json.getInt("doctor_id");
        LocalDateTime dateTime = LocalDateTime.parse(json.getString("date_time"));


        try {
            AppointmentsDAO.add(patientId, doctorId, dateTime);
            context.redirect("/technician");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
