package Models;

import java.util.Date;

public class VaccineApplication {
    private Pet pet;
    private Vaccine vaccine;
    private Date date;

    public VaccineApplication(Pet pet, Vaccine vaccine, Date date) {
        this.pet = pet;
        this.vaccine = vaccine;
        this.date = date;
    }
}