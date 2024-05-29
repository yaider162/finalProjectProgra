package Models;

import java.util.Date;

public class Appointment {
    private String petName, ownerName, ownerId, specie, sex;
    private Date date;

    public Appointment(String petName, String ownerName, String ownerId, String specie,String sex, Date date) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.specie = specie;
        this.sex = sex;
        this.date = date;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getSpecie() {
        return specie;
    }

    public Date getDate() {
        return date;
    }

    public String getSex() {
        return this.sex;
    }
}
