package com.example.rest.service;


import com.example.rest.repository.HolidayRepository;
import com.example.rest.repository.ReservationRepository;
import com.example.rest.model.holiday.Holiday;
import com.example.rest.model.reservation.Reservation;
import com.example.rest.model.reservation.CreateReservation;
import com.example.rest.model.reservation.UpdateReservation;
import com.example.rest.model.reservation.ResponseReservation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final HolidayRepository holidayRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(HolidayRepository holidayRepository, ReservationRepository reservationRepository) {
        this.holidayRepository = holidayRepository;
        this.reservationRepository = reservationRepository;
    }
    private Holiday load(long id){
        return holidayRepository.findById(id).get();
    }

    @Override
    public ResponseReservation create(CreateReservation create) {

        Reservation reservation = new Reservation();

        Holiday holiday = this.load(create.getHoliday());
        reservation.setHoliday(holiday);
        BeanUtils.copyProperties(create,reservation);

        Reservation savedReservation = reservationRepository.save(reservation);

        return ReservationRepository.responseGenerate(savedReservation);
    }
    @Override
    public Boolean delete(Long id) {
        if (!reservationRepository.existsById(id)) {
            return false;
        }
        reservationRepository.deleteById(id);
        return true;
    }

    @Override
    public ResponseReservation update(UpdateReservation update) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(update.getId());
        if (!reservationOptional.isPresent()) {

            return null;
        }
        Reservation reservation = reservationOptional.get();
        BeanUtils.copyProperties(update, reservation);
        reservation.setHoliday(holidayRepository.findById(update.getHoliday()).orElse(null));

        Reservation updatedReservation = reservationRepository.save(reservation);
        return ReservationRepository.responseGenerate(updatedReservation);
    }

    @Override
    public List<ResponseReservation> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservation -> {
                    ResponseReservation response = new ResponseReservation();
                    BeanUtils.copyProperties(reservation, response);
                    return response;
                })
                .collect(Collectors.toList());
    }


    @Override
    public ResponseReservation findById(Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    ResponseReservation response = new ResponseReservation();
                    BeanUtils.copyProperties(reservation, response);
                    return response;
                })
                .orElse(null);
    }







}

