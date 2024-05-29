package Models;

import Views.panels.NewAppointment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Vet {
    ArrayList<Vaccine> vaccines;
    ArrayList<Responsible> responsibles;
    ArrayList<Appointment> appointments = new ArrayList<>();
    public Vet(){
        vaccines = new ArrayList<>();
        responsibles = new ArrayList<>(20);
    }
    public void registerVaccine(Vaccine vaccine){
        vaccines.add(vaccine);
    }
    public ArrayList<Vaccine> getVaccines(){
        return vaccines;
    }

    public void addVaccine(String name,String specie, Date expirationDate) {
        Vaccine vaccine = new Vaccine(name,specie, expirationDate);
        registerVaccine(vaccine);
    }

    public void registerPet(String petName, String ownmerName, String ownerId, String specie, String sex, Date date) throws IOException {
        Responsible responsible = new Responsible(ownmerName, ownerId);
        Pet pet = new Pet(petName, ownmerName, ownerId,specie,sex,date);
        BufferedWriter writer = new BufferedWriter(new FileWriter(GLOBALS.properties.getProperty("appointments"), true));
        writer.write(petName + "," + ownmerName + "," + ownerId + "," + specie + "," );
        writer.newLine();
        responsible.addPet(pet);
    }

    public ArrayList<Pet> getPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        for (Responsible responsible : responsibles) {
            pets.addAll(responsible.getPets());
        }
        return pets;
    }

    public ArrayList<Responsible> getResponsibles() {
        return responsibles;
    }

    public void addAppointment(String petName, String ownerName, String ownerId, String specie,String sex,Date date) throws IOException {
        Appointment appointment = new Appointment(petName, ownerName, ownerId, specie, sex, date);
        Pet pet = new Pet(petName, ownerName, ownerId,specie,sex,date);
        registerPet(petName, ownerName, ownerId, specie,sex,date);
        appointments.add(appointment);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}
