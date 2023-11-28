package com.MedicalAssistant.app.Database.DAO;

import com.MedicalAssistant.app.Database.Connection.JDBIManager;
import com.MedicalAssistant.app.Models.Patient;
import org.jdbi.v3.core.Jdbi;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PatientDAO {

    public static ArrayList<Patient> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Patient>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM patients;")
                    .mapToBean(Patient.class)
                    .list();
        });
    }
    public static void save(Patient patient) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO patients VALUES (NULL, :first_name, :last_name, :date_of_birth, :email, :jmbg);")
                    .bindBean(patient).execute();
        });
    }
}
