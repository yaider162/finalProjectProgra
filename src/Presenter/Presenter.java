package Presenter;

import Models.Vaccine;
import Models.Vet;
import Views.MainPage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Presenter {
    private static Vet vet;
    private MainPage mainPage;
    public static void main(String[] args) throws IOException, FontFormatException {
        Presenter presenter = new Presenter();
        vet = new Vet();
        presenter.menu();
    }

    public void menu() throws IOException, FontFormatException {
        mainPage = new MainPage();
    }

    public ArrayList<String> getVaccinesName(){
        ArrayList<String> vaccines = new ArrayList<>();
        for (int i = 0; i < vet.getVaccines().size(); i++) {
            vaccines.add(vet.getVaccines().get(i).getName());
        }
        return vaccines;
    }

    public ArrayList<String> getVaccinesDeadline() {
        ArrayList<String> vaccines = new ArrayList<>();
        for (int i = 0; i < vet.getVaccines().size(); i++) {
            vaccines.add(vet.getVaccines().get(i).getDeadLine());
        }
        return vaccines;
    }

    public void addVaccine(String name, Date expirationDate) {
        vet.addVaccine(name, expirationDate);
    }

    public ArrayList<Vaccine> getVaccines(){
        return vet.getVaccines();
    }
    public void registerPet(String petName, String type, String raze,String responsibleName,String id, List<Vaccine> selectedValuesList) {
        vet.registerPet(petName, type, raze, responsibleName,id,selectedValuesList);
    }
    
    public ArrayList<String> getPetTypes() {
        ArrayList<String> petTypes = new ArrayList<>();
        for (int i = 0; i < vet.getPets().size(); i++) {
            petTypes.add(vet.getPets().get(i).getType());
        }
        return petTypes;
    }

    public List<String> getPetNames() {
        List<String> petNames = new ArrayList<>();
        for (int i = 0; i < vet.getPets().size(); i++) {
            petNames.add(vet.getPets().get(i).getName());
        }
        return petNames;
    }

    public List<String> getPetRazes() {
        List<String> petRazes = new ArrayList<>();
        for (int i = 0; i < vet.getPets().size(); i++) {
            petRazes.add(vet.getPets().get(i).getRaze());
        }
        return petRazes;
    }

    public List<String> getPetResponsibles() {
        List<String> petResponsibles = new ArrayList<>();
        for (int i = 0; i < vet.getPets().size(); i++) {
            petResponsibles.add(vet.getPets().get(i).getResponsible());
        }
        return petResponsibles;
    }

    public void addAppointment(String petName, String vaccineName) {
        vet.addAppointment(petName, vaccineName);
    }
}
