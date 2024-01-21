package com.example.rest.controller;

import com.example.rest.model.location.CreateLocation;
import com.example.rest.model.location.UpdateLocation;
import com.example.rest.model.location.ResponseLocation;
import com.example.rest.service.LocationService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/locations")
@RestController
public class LocationController {

    private final LocationService location;


    public LocationController(LocationService service) {
        this.location = service;
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CreateLocation create) {
        ResponseLocation responseLocationDTO = location.create(create);
        return new ResponseEntity<>("saved successfully!", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Boolean deleted = location.delete(id);
        return ResponseEntity.ok(deleted);
    }
    @PutMapping
    public ResponseEntity<ResponseLocation> update(@RequestBody UpdateLocation update) {
        ResponseLocation updatedLocation = location.update(update);
        return ResponseEntity.ok(updatedLocation);
    }

    @GetMapping
    public ResponseEntity<List<ResponseLocation>> findAll() {
        List<ResponseLocation> allLocations = location.findAll();
        return ResponseEntity.ok(allLocations);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseLocation> findById(@PathVariable Long id) {
        ResponseLocation location = this.location.findById(id);
        return ResponseEntity.ok(location);
    }

}

