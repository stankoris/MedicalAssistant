package com.MedicalAssistant.app;

import com.MedicalAssistant.app.Handlers.Doctor.DoctorAuthorizationHandler;
import com.MedicalAssistant.app.Handlers.Doctor.DoctorDashboardHandler;
import com.MedicalAssistant.app.Handlers.HomeHandler;
import com.MedicalAssistant.app.Handlers.LoginFormHandler;
import com.MedicalAssistant.app.Handlers.LoginSubmissionHandler;
import com.MedicalAssistant.app.Handlers.Tehnician.TechnicianAuthorizationHandler;
import com.MedicalAssistant.app.Handlers.Tehnician.TechnicianDashboardHandler;
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

		app.before("/doctor", new DoctorAuthorizationHandler());
		app.before("/doctor/*", new DoctorAuthorizationHandler());
		app.get("/doctor", new DoctorDashboardHandler());

		app.before("/technician", new TechnicianAuthorizationHandler());
		app.before("/technician/*", new TechnicianAuthorizationHandler());
		app.get("/technician", new TechnicianDashboardHandler());


		app.start(9000);
	}
}
