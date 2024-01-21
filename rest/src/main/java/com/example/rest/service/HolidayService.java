package com.example.rest.service;


import com.example.rest.model.holiday.CreateHoliday;
import com.example.rest.model.holiday.UpdateHoliday;
import com.example.rest.model.holiday.ResponseHoliday;

import java.util.List;

public interface HolidayService {
    ResponseHoliday create(CreateHoliday createHoliday);
    Boolean delete(Long id);
    ResponseHoliday update(UpdateHoliday update);
    List<ResponseHoliday> findAll();
    ResponseHoliday findById(Long id);

}
