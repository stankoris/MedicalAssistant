package com.MedicalAssistant.app.Database.DAO;

import com.MedicalAssistant.app.Database.Connection.JDBIManager;
import com.MedicalAssistant.app.Models.Doctor;
import com.MedicalAssistant.app.Models.Patient;
import org.jdbi.v3.core.Jdbi;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DoctorDAO {

    public static Doctor get(int doctor_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM doctors WHERE doctor_id = :doctor_id")
                    .bind("doctor_id", doctor_id)
                    .mapToBean(Doctor.class)
                    .one();
        });
    }

    public static ArrayList<Doctor> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Doctor>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM doctors;")
                    .mapToBean(Doctor.class)
                    .list();
        });
    }

}
