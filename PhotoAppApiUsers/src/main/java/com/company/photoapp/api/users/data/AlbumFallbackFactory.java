package com.company.photoapp.api.users.data;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class AlbumFallbackFactory implements FallbackFactory<AlbumServiceClient> {

    @Override
    public AlbumServiceClient create(Throwable cause) {
        return new AlbumServiceClientFallback(cause);
    }
}
