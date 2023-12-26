package com.MedicalAssistant.app.Handlers.Appointment;

import com.MedicalAssistant.app.Database.DAO.AppointmentsDAO;
import com.MedicalAssistant.app.Models.Appointments;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewAppointmentSubmitHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        try {
            if (!context.body().isEmpty()) {
                JSONObject json = new JSONObject(context.body());

                if (json.has("patient_id") && json.has("date") && json.has("time")) {
                    int patientId = json.getInt("patient_id");
                    String date = json.getString("date");
                    String time = json.getString("time");


                    if (validirajPodatke(patientId, date, time)) {
                        AppointmentsDAO.add(patientId, date, time);

                        context.status(200);
                        context.result("Uspešno dodat novi pregled.");
                    } else {

                        context.status(400);
                        context.result("Nevažeći ili nedostajući podaci.");
                    }
                } else {

                    context.status(400);
                    context.result("Nedostaju obavezni podaci.");
                }
            } else {

                context.status(400);
                context.result("Telo zahteva je prazno.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();

            context.status(500);
            context.result("Došlo je do greške prilikom dodavanja pregleda.");
        }
    }


    private boolean validirajPodatke(int patientId, String date, String time) {

        if (patientId <= 0) {
            return false;
        }

        if (date == null || date.isEmpty() || time == null || time.isEmpty()) {
            return false;
        }
        try {
            LocalDate parsedDate = LocalDate.parse(date);

            if (!parsedDate.isAfter(LocalDate.now())) {
                return false;
            }

            LocalTime parsedTime = LocalTime.parse(time);

            if (parsedTime.isBefore(LocalTime.of(8, 0)) || parsedTime.isAfter(LocalTime.of(17, 0))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
