package com.company.photoapp.api.users.shared;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception e = null;
        switch (response.status()) {
            case 400:
//                e = new BadRequestException();
                break;
            case 404:
                if (methodKey.contains("getAlbums")) {
                    e = new ResponseStatusException(
                            HttpStatus.valueOf(response.status()),
                            env.getProperty("users.exceptions.albums.not-found"));
                }
                break;
            default:
                e = new Exception(response.reason());
        }
        return e;
    }
}
