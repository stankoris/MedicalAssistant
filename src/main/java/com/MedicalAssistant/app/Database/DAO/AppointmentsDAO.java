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
    public static int add(int patient_id, String date, String time) throws FileNotFoundException {
        int status = 1;
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createUpdate("INSERT INTO `appointments` VALUES (NULL, ?, ?, ?, ?)")
                    .bind(0,patient_id)
                    .bind(1,date)
                    .bind(2,time)
                    .bind(3,status)
                    .execute();
        });
    }

    public static Appointments get(int appointment_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM appointments WHERE appointment_id = :appointment_id")
                    .bind("appointment_id", appointment_id)
                    .mapToBean(Appointments.class)
                    .one();
        });
    }
}
