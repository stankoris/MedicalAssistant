package com.MedicalAssistant.app.Database.DAO;

import com.MedicalAssistant.app.Database.Connection.JDBIManager;
import com.MedicalAssistant.app.Models.User;
import org.jdbi.v3.core.Jdbi;

import java.io.FileNotFoundException;

public class UserDAO {
    public static User for_username(String username) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM users WHERE username = :username;")
                    .bind("username", username)
                    .mapToBean(User.class)
                    .findFirst().orElse(null);
        });
    }
}
