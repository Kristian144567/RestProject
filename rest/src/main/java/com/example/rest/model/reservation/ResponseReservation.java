package com.example.rest.model.reservation;


import com.example.rest.model.holiday.Holiday;
import lombok.Data;

@Data
public class ResponseReservation {
    private Long id;
    private Holiday holiday;
    private String contactName;
    private String phoneNumber;


    public ResponseReservation() {

    }

    public ResponseReservation(Long id, Holiday holiday, String contactName, String phoneNumber) {
        this.id = id;
        this.holiday = holiday;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
