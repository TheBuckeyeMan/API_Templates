package base.template.template.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import base.template.template.api.model.Model;


//Entire purpose of service is to consume the data from api
@Service
public class TemplateService {
    
    private final RestTemplate restTemplate;

    //Assign the rest template to this Service
    public TemplateService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    //Make getter method for our model
    public Model getModel(){
        String url = "<Your URL Here>";
        Model model = restTemplate.getForObject(url,Model.class);
        if (model != null) {
            saveToFile(model);
        }
       return model;
    }
    private void saveToFile(Model model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("<Name Of Your File Here>.<File Extension>"))){
            //ADD IN ALL DATA POINTS TO WRITE TO FILE HERE - FOR BIG API'S WE WILL HAVE MORE HERE
            writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");
            writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");
            writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
