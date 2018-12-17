package day4.part1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProtocolEntry {

    Calendar date;
    String message;

    ProtocolEntry(String date, String message) throws ParseException {
        Date datetmp = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
        this.date = Calendar.getInstance();
        this.date.setTime(datetmp);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.date.toString() + " " + this.message;
    }
}
