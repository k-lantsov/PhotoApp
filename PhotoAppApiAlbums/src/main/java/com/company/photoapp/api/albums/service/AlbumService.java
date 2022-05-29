package com.company.photoapp.api.albums.service;

import com.company.photoapp.api.albums.data.AlbumEntity;

import java.util.List;

public interface AlbumService {
    List<AlbumEntity> getAlbums(String userId);
}
