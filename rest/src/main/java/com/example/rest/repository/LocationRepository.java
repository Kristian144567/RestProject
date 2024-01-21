package com.example.rest.repository;

import com.example.rest.model.location.Location;
import com.example.rest.model.location.ResponseLocation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
    static ResponseLocation responseGenerate(Location location) {
        ResponseLocation responseLocationDTO = new ResponseLocation();
        BeanUtils.copyProperties(location, responseLocationDTO);
        return responseLocationDTO;
    }
}
