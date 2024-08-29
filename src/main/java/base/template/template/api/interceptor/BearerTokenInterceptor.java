package base.template.template.api.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.stereotype.Component;

import java.io.IOException;

//the entire purpose of this java class is to add in the bearer token to the header of the request made to the external datasource
@Component
public class BearerTokenInterceptor implements ClientHttpRequestInterceptor{
    private final String bearerToken;

    public BearerTokenInterceptor(String bearerToken){
        this.bearerToken = bearerToken;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("Authorization","Bearer " + bearerToken);
        return execution.execute(request, body);
    }
}
