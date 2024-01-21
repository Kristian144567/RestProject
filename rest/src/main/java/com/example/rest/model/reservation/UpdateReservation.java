package com.example.rest.model.reservation;

import lombok.Data;

@Data
public class UpdateReservation {
    private Long id;
    private Long holiday;
    private String contactName;
    private String phoneNumber;


    public UpdateReservation() {

    }

    public UpdateReservation(Long id, Long holiday, String contactName, String phoneNumber) {
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

    public Long getHoliday() {
        return holiday;
    }

    public void setHoliday(Long holiday) {
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
