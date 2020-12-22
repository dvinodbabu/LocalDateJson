package com.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.text.SimpleDateFormat;

public class DateConversion {

    public static void main(String args[]) {
        Bank bank = new Bank();
        bank.setDateOpened(formatDates("18/08/2020"));
        System.out.println(bank.getDateOpened());
        try {
            System.out.println(converBankPojoToJson(bank));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static LocalDate formatDates(String date) {
        if (date != null && !date.trim().isEmpty()) {
            return LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            System.out.println("date is null");
            return null;
        }
    }

    public static String converBankPojoToJson(Bank bank) throws JsonProcessingException {
        if (bank != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            return objectMapper.writeValueAsString(bank);
        } else {
            System.out.println("bank object is null");
            return null;
        }
    }
}