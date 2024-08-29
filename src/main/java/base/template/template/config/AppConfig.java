package base.template.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//The entire purpose of the configuration file is to simply configure ther RestTemplate as a bean in the application s it can be autowired
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

