package com.demo.authentication.security;
/*
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    private String headerValue;

    public FeignRequestInterceptor() {
    }

    public FeignRequestInterceptor(String username, String password) {
        this(username, password, ISO_8859_1);
    }

    public FeignRequestInterceptor(String username, String password, Charset charset) {
        checkNotNull(username, "username");
        checkNotNull(password, "password");
        this.headerValue = "Basic " + base64encode((username + ":" + password).getBytes(charset));
    }

    private static String base64encode(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", headerValue);
    }
}

*/