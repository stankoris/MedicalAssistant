package com.MedicalAssistant.app.Controllers;

import com.MedicalAssistant.app.Templating.Renderer;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public @ResponseBody String index() throws TemplateException, IOException {
        return Renderer.render("home.ftl");
    }
}
