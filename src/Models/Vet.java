package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vet {
    ArrayList<Vaccine> vaccines;
    ArrayList<Responsible> responsibles;
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

    public void addVaccine(String name, Date expirationDate) {
        Vaccine vaccine = new Vaccine(name, expirationDate);
        registerVaccine(vaccine);
    }

    public void registerPet(String petName, String type, String raze, String principalResponsible, String id, List<Vaccine> selectedValuesList) {
        Pet pet = new Pet(petName, type, raze, selectedValuesList);
        pet.setPrincipalResponsible(principalResponsible);
        if(responsibles.isEmpty()) {
            Responsible responsible = new Responsible(principalResponsible, id);
            responsible.addPet(pet);
            responsibles.add(responsible);
        }else{
            for (Responsible responsible : responsibles) {
                if (responsible.getId().equals(id)) {
                    responsible.addPet(pet);
                }
            }
        }
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

    public void addAppointment(String petName, String vaccineName) {
        for (Responsible responsible : responsibles) {
            for (Pet pet : responsible.getPets()) {
                if (pet.getName().equals(petName)) {
                    for (Vaccine vaccine : vaccines) {
                        if (vaccine.getName().equals(vaccineName)) {
                            pet.applyVaccine(vaccine);
                        }
                    }
                }
            }
        }
    }
}
