package com.MedicalAssistant.app;

import com.MedicalAssistant.app.Handlers.HomeHandler;
import com.MedicalAssistant.app.Handlers.LoginFormHandler;
import com.MedicalAssistant.app.Handlers.LoginSubmissionHandler;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


public class MedAssistApplication {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
			config.staticFiles.add(System.getenv("MA_RESOURCES") + "/static", Location.EXTERNAL);
		});

		app.get("/", new HomeHandler());
		app.get("/login", new LoginFormHandler());
		app.post("/login", new LoginSubmissionHandler());
		app.start(9000);
	}
}
