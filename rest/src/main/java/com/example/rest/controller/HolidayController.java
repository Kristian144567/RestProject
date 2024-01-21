package com.example.rest.controller;

import com.example.rest.model.holiday.CreateHoliday;
import com.example.rest.model.holiday.UpdateHoliday;
import com.example.rest.model.holiday.ResponseHoliday;
import com.example.rest.service.HolidayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/holidays")
@RestController
public class HolidayController {

    private final HolidayService holiday;

    public HolidayController(HolidayService service) {
        this.holiday = service;
    }


    @PostMapping()
    public ResponseEntity<ResponseHoliday> create(@RequestBody CreateHoliday create) {
        ResponseHoliday responseHolidayDTO = this.holiday.create(create);
        return new ResponseEntity<>(responseHolidayDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseHoliday>> findAll() {
        List<ResponseHoliday> allHolidays = this.holiday.findAll();
        return ResponseEntity.ok(allHolidays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseHoliday> findById(@PathVariable Long id) {
        ResponseHoliday holiday = this.holiday.findById(id);
        return ResponseEntity.ok(holiday);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Boolean deleted = this.holiday.delete(id);
        return ResponseEntity.ok(deleted);
    }
    @PutMapping
    public ResponseEntity<ResponseHoliday> update(@RequestBody UpdateHoliday update) {
        ResponseHoliday updatedHoliday = holiday.update(update);
        return ResponseEntity.ok(updatedHoliday);
    }


}
