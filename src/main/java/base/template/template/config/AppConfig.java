package base.template.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import base.template.template.api.interceptor.ToExternalLoggingInterceptor;
import base.template.template.api.interceptor.BearerTokenInterceptor;
import base.template.template.api.interceptor.IncommingLoggingInterceptor;

//The entire purpose of the configuration file is to simply configure ther RestTemplate as a bean in the application s it can be autowired
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(BearerTokenInterceptor bearerTokenInterceptor, ToExternalLoggingInterceptor toExternalLoggingInterceptor,IncommingLoggingInterceptor incommingLoggingInterceptor){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList(incommingLoggingInterceptor,toExternalLoggingInterceptor)); //If we have any other requests we want to intercept, we can capture them registering here
        return restTemplate;
    }

    @Bean
    public BearerTokenInterceptor bearerTokenInterceptor(){
        return new BearerTokenInterceptor(System.getenv("<Add Environment Variable Here for Bearer Token>"));
    }
}

