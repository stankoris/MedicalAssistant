package com.MedicalAssistant.app.Handlers;

import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class LoginFormHandler implements Handler {
    public void handle(Context context) throws Exception {
        context.html(Renderer.render("login.ftl"));
    }
}
