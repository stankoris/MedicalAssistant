package com.MedicalAssistant.app.Handlers;

import com.MedicalAssistant.app.Templating.Renderer;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class testhandler implements Handler {

    public void handle(Context context) throws Exception {

        String html_content = Renderer.render("test.ftl");
        context.html(html_content);
    }
}
