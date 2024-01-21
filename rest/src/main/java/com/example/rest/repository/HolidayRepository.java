package com.example.rest.repository;

import com.example.rest.model.holiday.Holiday;
import com.example.rest.model.holiday.ResponseHoliday;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday,Long> {
    static ResponseHoliday responsGenerate(Holiday holiday) {
        ResponseHoliday response = new ResponseHoliday();
        BeanUtils.copyProperties(holiday, response);
        return response;
    }
}
