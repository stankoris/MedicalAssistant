package com.MedicalAssistant.app.Database.DAO;


import com.MedicalAssistant.app.Database.Connection.JDBIManager;
import com.MedicalAssistant.app.Models.Appointments;
import org.jdbi.v3.core.Jdbi;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AppointmentsDAO {

    public static ArrayList<Appointments> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Appointments>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM appointments;")
                    .mapToBean(Appointments.class)
                    .list();
        });
    }

    public static int add(Appointments appointment) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO `appointments` VALUES (NULL, :patient_id, :doctor_id, :date_time)")
                    .bindBean(appointment)
                    .execute();
        });
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM appointments ORDER BY appointment_id DESC LIMIT 1")
                    .mapToBean(Appointments.class)
                    .one().getAppointment_id();
        });
    }
}
