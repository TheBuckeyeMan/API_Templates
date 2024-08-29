package base.template.template.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import base.template.template.api.model.Model;
import base.template.template.service.TemplateService;
import base.template.template.service.S3Service;


//Entire purpose of the controller is to expose the api endpoints and trigger the api
@RestController
@RequestMapping("/api")
public class Controller {
    //Initialize new instance of the service for the controller
    private final TemplateService templateService;
    private final S3Service s3Service;

    public Controller(TemplateService templateService, S3Service s3Service){
        this.templateService = templateService;
        this.s3Service = s3Service;
    }

    @GetMapping("/<Name_of_Endpoint_to_call_to_trigger_api>")
    public Model getModel(){
        Model model = templateService.getModel();
        if (model != null) {
            s3Service.uploadFile("<Name_Of_Your_S3_Bucket>", "<Name_Of_Your_File>.<File_Extension>", "<Name_Of_Your_File>.<File_Extension>");
        }
        return model;
    }
    
}
