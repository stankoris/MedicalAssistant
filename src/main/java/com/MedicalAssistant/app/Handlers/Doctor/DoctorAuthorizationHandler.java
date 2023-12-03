package com.MedicalAssistant.app.Handlers.Doctor;

import com.MedicalAssistant.app.Models.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DoctorAuthorizationHandler implements Handler {

    @Override
    public void handle(Context context) throws Exception {
        User user = (User)context.sessionAttribute("user");
        if( context.sessionAttribute("user") == null)
            context.redirect("/login");

        else if(!user.getUser_type().equals("doctor"))
            context.redirect("/login");
    }
}
