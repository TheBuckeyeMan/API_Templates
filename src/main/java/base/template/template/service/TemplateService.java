package base.template.template.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import base.template.template.api.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

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
                    log.info("Model Successful Build!");
                }
                } catch (HttpStatusCodeException e) {
                    log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);//log error if an error status code is returned
                } catch (Exception e) {
                    log.error("An Error Occured while making the reques tto external API: {}", e);
                }
       return model;
    }
    //THE BELOW CLASS ALOWS US TO CAPTURE AN ARRAY OF JSON OBJECTS, NOT JUST A SINGLE JSON OBJECT
    public List<Model> getModels() {
        String url = "<Your URL Here>";
        
        List<Model> models = null;
        try{
            Model[] responseArray = restTemplate.getForObject(url, Model[].class);
            models = Arrays.asList(responseArray);

            String jsonResponse = objectMapper.writeValueAsString(models);
            log.info("Recieved Json Array Response from External API:{}", jsonResponse);
            if (!models.isEmpty()) {
                log.info("Models Successfully Built!");
            }
        } catch (HttpStatusCodeException e) {
            log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            log.error("An Error Occured while making he request to external API: {} Line 59 TemplateService.java");
        }
        return models;
    }
}

