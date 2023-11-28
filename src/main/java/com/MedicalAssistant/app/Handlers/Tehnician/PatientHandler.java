package com.MedicalAssistant.app.Handlers.Tehnician;

import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PatientHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.html(Renderer.render("technician/new_patient.ftl"));
    }
}
