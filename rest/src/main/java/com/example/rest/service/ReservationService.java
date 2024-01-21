package com.example.rest.service;

import com.example.rest.model.reservation.CreateReservation;
import com.example.rest.model.reservation.UpdateReservation;
import com.example.rest.model.reservation.ResponseReservation;

import java.util.List;

public interface ReservationService {
    ResponseReservation create(CreateReservation createReservation);
    Boolean delete(Long id);
    ResponseReservation update(UpdateReservation update);
    List<ResponseReservation> findAll();
    ResponseReservation findById(Long id);

}
