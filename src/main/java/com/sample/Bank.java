package com.sample;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.gson.annotations.SerializedName;
import org.threeten.bp.LocalDate;


public class Bank {
    @JsonSerialize(using = ToStringSerializer.class)
    @SerializedName(("dateOpened"))
    private LocalDate dateOpened;

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

}
