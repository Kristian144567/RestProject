package com.example.rest.repository;

import com.example.rest.model.reservation.Reservation;
import com.example.rest.model.reservation.ResponseReservation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    static ResponseReservation responseGenerate(Reservation reservation) {
        ResponseReservation response = new ResponseReservation();
        BeanUtils.copyProperties(reservation,response);
        return response;
    }
}
