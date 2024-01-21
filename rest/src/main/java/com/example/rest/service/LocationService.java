package com.example.rest.service;


import com.example.rest.model.location.CreateLocation;
import com.example.rest.model.location.UpdateLocation;
import com.example.rest.model.location.ResponseLocation;

import java.util.List;

public interface LocationService {
    ResponseLocation create(CreateLocation createLocation);
    Boolean delete(Long id);
    ResponseLocation update(UpdateLocation updateLocation);
    List<ResponseLocation> findAll();
    ResponseLocation findById(Long id);

}
