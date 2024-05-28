package Models;

import java.time.LocalDate;
import java.util.Date;

public class Vaccine {
    private String type;
    private LocalDate deadLine;

    public Vaccine(String type, Date date) {
        this.type = type;
        this.deadLine = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    public String getName() {
        return type;
    }

    public String getDeadLine() {
        return deadLine.toString();
    }
}
