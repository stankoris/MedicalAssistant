package com.MedicalAssistant.app.Handlers.Doctor;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DoctorDashboardHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.html("You are at DOCTOR dashboard!");
    }
}
