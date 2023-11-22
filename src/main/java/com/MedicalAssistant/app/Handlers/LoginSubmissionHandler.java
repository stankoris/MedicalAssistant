package com.MedicalAssistant.app.Handlers;

import com.MedicalAssistant.app.Database.DAO.UserDAO;
import com.MedicalAssistant.app.Exceptions.InvalidUsernamePasswordException;
import com.MedicalAssistant.app.Models.User;
import com.google.common.hash.Hashing;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.nio.charset.StandardCharsets;

public class LoginSubmissionHandler implements Handler {
    public void handle(Context context) throws Exception {
        String username = context.formParam("username");
        String password = context.formParam("password");
        try {
            User user = UserDAO.for_username(username);
            if(user == null)
                throw new InvalidUsernamePasswordException();
            password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
            if(!password.equals(user.getPassword()))
                throw new InvalidUsernamePasswordException();
            context.sessionAttribute("user", user);
            context.html("You have logged in succesfully!");

        }catch (InvalidUsernamePasswordException ex) {
            context.html(ex.getMessage());
        }

    }
}
