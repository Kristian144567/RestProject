package com.example.rest.service;
import com.example.rest.repository.HolidayRepository;
import com.example.rest.repository.LocationRepository;
import com.example.rest.model.holiday.Holiday;
import com.example.rest.model.location.Location;
import com.example.rest.model.holiday.CreateHoliday;
import com.example.rest.model.holiday.UpdateHoliday;
import com.example.rest.model.holiday.ResponseHoliday;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {
        private final LocationRepository locations;
        private final HolidayRepository holidays;

    public HolidayServiceImpl(LocationRepository locations, HolidayRepository holidays) {
        this.locations = locations;
        this.holidays = holidays;
    }

    @Autowired
        public HolidayServiceImpl(HolidayRepository repository, LocationRepository locationRepository) {
        this.holidays = repository;
        this.locations = locationRepository;
        }


        @Override
        public ResponseHoliday create(CreateHoliday create) {

            Holiday holiday = new Holiday();

            Location location = this.load(create.getLocation());

            holiday.setLocation(location);
            BeanUtils.copyProperties(create, holiday);
            Holiday save = holidays.save(holiday);
            ResponseHoliday response = new ResponseHoliday();
            BeanUtils.copyProperties(save, response);
            return response;
        }
    @Override
    public Boolean delete(Long id) {
        if (holidays.existsById(id)) {
            holidays.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public ResponseHoliday update(UpdateHoliday update) {
        Optional<Holiday> holidayOptional = holidays.findById(update.getId());
        if (!holidayOptional.isPresent()) {
            return null;
        }else {
            Holiday holiday = holidayOptional.get();
            BeanUtils.copyProperties(update, holiday);
            Holiday updatedHoliday = holidays.save(holiday);
            return HolidayRepository.responsGenerate(updatedHoliday);
        }

    }
    private Location load(long id){
        return locations.findById(id).get();
    }
    @Override
    public List<ResponseHoliday> findAll() {
        List<Holiday> holidays = this.holidays.findAll();
        return holidays.stream()
                .map(HolidayRepository::responsGenerate)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseHoliday findById(Long id) {
        return holidays.findById(id)
                .map(HolidayRepository::responsGenerate)
                .orElse(null);
    }
}