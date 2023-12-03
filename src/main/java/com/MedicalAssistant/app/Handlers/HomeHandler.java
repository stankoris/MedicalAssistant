package com.MedicalAssistant.app.Handlers;

import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;


public class HomeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {

        String html_content = Renderer.render("home.ftl");
        context.html(html_content);
    }
}
