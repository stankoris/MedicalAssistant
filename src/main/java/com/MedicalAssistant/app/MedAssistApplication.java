package com.MedicalAssistant.app;

import com.MedicalAssistant.app.Handlers.Appointment.NewAppointmentHandler;
import com.MedicalAssistant.app.Handlers.Appointment.NewAppointmentSubmitHandler;
import com.MedicalAssistant.app.Handlers.Doctor.DoctorAuthorizationHandler;
import com.MedicalAssistant.app.Handlers.Doctor.DoctorDashboardHandler;
import com.MedicalAssistant.app.Handlers.HomeHandler;
import com.MedicalAssistant.app.Handlers.Login.LoginFormHandler;
import com.MedicalAssistant.app.Handlers.Login.LoginSubmissionHandler;
import com.MedicalAssistant.app.Handlers.Patients.*;
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

		app.post("/login", new LoginSubmissionHandler());
		app.get("/login", new LoginFormHandler());


		app.before("/doctor", new DoctorAuthorizationHandler());
		app.before("/doctor/*", new DoctorAuthorizationHandler());
		app.get("/doctor", new DoctorDashboardHandler());

		app.before("/technician", new TechnicianAuthorizationHandler());
		app.before("/technician/*", new TechnicianAuthorizationHandler());
		app.get("/technician", new TechnicianDashboardHandler());

		app.post("/technician/new_patient", new NewPatientSubmitHandler());
		app.get("/technician/new_patient", new NewPatientHandler());

		app.get("/technician/all_patients", new AllPatientHandler());

		app.post("/technician/find_patient", new FindPatientsSubmitHandler());
		app.get("/technician/find_patient", new FindPatientsHandler());

		app.post("/technician/edit/{patient_id}", new EditPatientSubmitHandler());
		app.get("/technician/edit/{patient_id}", new EditPatientHandler());

		app.get("/technician/delete/{patient_id}", new DeletePatientHandler());


		app.post("/technician/new_appointment", new NewAppointmentSubmitHandler());
		app.get("/technician/new_appointment", new NewAppointmentHandler());

		app.start(9000);
	}
}
