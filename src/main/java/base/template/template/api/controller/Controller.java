package base.template.template.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import base.template.template.api.model.Model;
import base.template.template.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

//Entire purpose of the controller is to expose the api endpoints and trigger the api
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class Controller {
    //Initialize new instance of the service for the controller
    private final TemplateService templateService;

    @GetMapping("/<Name_of_Endpoint_to_call_to_trigger_api>")
    public List<Model> getModel(){
        List<Model> model = templateService.getModel();
        return model;
    }
}
