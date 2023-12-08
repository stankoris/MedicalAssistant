package com.MedicalAssistant.app.Handlers.Patients;

import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class FindPatientsHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.html(Renderer.render("patients/find_patients.ftl"));
    }
}
