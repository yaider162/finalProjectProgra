package Models;

import java.time.LocalDate;
import java.util.Date;

public class Vaccine {
    private String type;
    private Date deadLine;
    private String specie;

    public Vaccine(String type,String specie, Date date) {
        this.type = type;
        this.specie = specie;
        this.deadLine = date;
    }

    public String getName() {
        return type;
    }

    public String getDeadLine() {
        return deadLine.toString();
    }

    public String getSpecies() {
        return specie;
    }

    public Object getExpirationDate() {
        return deadLine.toString();
    }
}
