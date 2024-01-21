package com.example.rest.controller;

import com.example.rest.model.reservation.CreateReservation;
import com.example.rest.model.reservation.UpdateReservation;
import com.example.rest.model.reservation.ResponseReservation;
import com.example.rest.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/reservations")
@RestController
public class ReservationController {
    private final ReservationService reservation;

    public ReservationController(ReservationService service) {
        this.reservation = service;
    }

    @PostMapping
    public ResponseEntity<ResponseReservation> create(@RequestBody CreateReservation create) {
        ResponseReservation response = reservation.create(create);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Boolean deleted = reservation.delete(id);
        return ResponseEntity.ok(deleted);
    }

    @PutMapping
    public ResponseEntity<ResponseReservation> update(@org.springframework.web.bind.annotation.RequestBody UpdateReservation update) {
        ResponseReservation updatedReservation = reservation.update(update);
        return ResponseEntity.ok(updatedReservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseReservation> findById(@PathVariable Long id) {
        ResponseReservation reservation = this.reservation.findById(id);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<List<ResponseReservation>> findAll() {
        List<ResponseReservation> allReservations = reservation.findAll();
        return ResponseEntity.ok(allReservations);
    }
}
