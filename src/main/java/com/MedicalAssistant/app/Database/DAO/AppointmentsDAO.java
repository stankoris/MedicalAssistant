package com.MedicalAssistant.app.Database.DAO;


import com.MedicalAssistant.app.Database.Connection.JDBIManager;
import com.MedicalAssistant.app.Models.Appointments;
import com.MedicalAssistant.app.Models.Patient;
import org.jdbi.v3.core.Jdbi;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
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

    public static int add(int p, int d, LocalDateTime t) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createUpdate("INSERT INTO `appointments` VALUES (NULL, ?, ?, ?)")
                    .bind(0, p)
                    .bind(1,d)
                    .bind(2,t)
                    .execute();
        });
    }
}
