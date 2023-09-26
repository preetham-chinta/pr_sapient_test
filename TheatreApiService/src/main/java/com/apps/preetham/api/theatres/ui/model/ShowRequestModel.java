package com.apps.preetham.api.theatres.ui.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ShowRequestModel {

    private LocalDate fromDate;
    private LocalDate toDate;
    private List<LocalTime> showTimes;
    private List<LocalTime> newShowTimes; // This is for the update endpoint

    // Getters and Setters

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public List<LocalTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<LocalTime> showTimes) {
        this.showTimes = showTimes;
    }

    public List<LocalTime> getNewShowTimes() {
        return newShowTimes;
    }

    public void setNewShowTimes(List<LocalTime> newShowTimes) {
        this.newShowTimes = newShowTimes;
    }
}
