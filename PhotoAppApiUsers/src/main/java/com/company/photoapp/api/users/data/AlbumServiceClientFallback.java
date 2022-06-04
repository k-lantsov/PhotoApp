package com.company.photoapp.api.users.data;

import com.company.photoapp.api.users.ui.model.AlbumResponseModel;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AlbumServiceClientFallback implements AlbumServiceClient{

    private final Throwable cause;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AlbumServiceClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public List<AlbumResponseModel> getAlbums(String id) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            logger.error("404 error took place when getAlbums was called with userId: "
                    + id + ". Error message: " + cause.getLocalizedMessage());
        } else {
            logger.error("Other error took place: " + cause.getLocalizedMessage());
        }
        return new ArrayList<>();
    }
}
