package com.MedicalAssistant.app.Controllers;

import com.MedicalAssistant.app.Database.DAO.DoctorsDAO;
import com.MedicalAssistant.app.Templating.Renderer;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public @ResponseBody String index() throws TemplateException, IOException, SQLException {
        HashMap<String, Object> dataModel = new HashMap<>();

        dataModel.put("doctors", DoctorsDAO.all());

        return Renderer.render("home.ftl", dataModel);
    }
}
