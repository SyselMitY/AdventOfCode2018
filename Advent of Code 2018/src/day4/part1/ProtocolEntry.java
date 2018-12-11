package day4.part1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProtocolEntry {

    Date date;
    String message;

    ProtocolEntry(String date, String message) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd hh:ss").parse(date);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.date.toString() + " " + this.message;
    }
}
