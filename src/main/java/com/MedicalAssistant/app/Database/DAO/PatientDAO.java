package com.MedicalAssistant.app.Database.DAO;

import com.MedicalAssistant.app.Database.Connection.JDBIManager;
import com.MedicalAssistant.app.Models.Patient;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
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
    public static int save(Patient patient) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO patients VALUES (NULL, :first_name, :last_name, :date_of_birth, :address, :email, :jmbg, :phone_number);")
                    .bindBean(patient)
                    .execute();
        });
        return jdbi.withHandle(handle -> {
           return handle.createQuery("SELECT * FROM patients ORDER BY patient_id DESC LIMIT 1")
                   .mapToBean(Patient.class)
                   .one().getPatient_id();
        });
    }
    public static Patient get(int patient_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM patients WHERE patient_id = :patient_id")
                    .bind("patient_id", patient_id)
                    .mapToBean(Patient.class)
                    .one();
        });
    }
    public static void delete(int patient_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM patients WHERE patient_id = :patient_id")
                    .bind("patient_id", patient_id)
                    .execute();
        });
    }
    public static void update(Patient patient) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                            UPDATE patients SET
                            first_name = :first_name,
                            last_name = :last_name,
                            date_of_birth = :date_of_birth,
                            address = :address,
                            email = :email,
                            jmbg = :jmbg,
                            phone_number = :phone_number
                            WHERE patient_id = :patient_id;
                            """)
                    .bindBean(patient)
                    .execute();
        });
    }

    public static ArrayList<Patient> find(String first_name) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Patient>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM patients WHERE first_name = :first_name;")
                    .bind("first_name", first_name)
                    .mapToBean(Patient.class)
                    .list();
        });
    }
}
