package base.template.template.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import base.template.template.api.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//Entire purpose of service is to consume the data from api
@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {
    
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();//Add in object for the JSON Response Object

    //Make getter method for our model
    public Model getModel(){
        String url = "<Your URL Here>";

        Model model = null;
        try {
            model = restTemplate.getForObject(url,Model.class);

            String jsonResponse = objectMapper.writeValueAsString(model);
            log.info("Recieved JSON Response from external API: {}", jsonResponse);//Log the JSON Response from Extenral API
                if (model != null) {
                    saveToFile(model);
                }
                } catch (HttpStatusCodeException e) {
                    log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);//log error if an error status code is returned
                } catch (Exception e) {
                    log.error("An Error Occured while making the reques tto external API: {}", e);
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
