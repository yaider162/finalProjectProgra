package Models;

import java.util.ArrayList;
import java.util.Date;

public class Vet {
    ArrayList<Vaccine> vaccines;
    ArrayList<Pet> pets;

    public Vet(){
        vaccines = new ArrayList<>();
        pets = new ArrayList<>();
    }
    public void registerVaccine(Vaccine vaccine){
        vaccines.add(vaccine);
    }
    public void registerPet(Pet pet){
        pets.add(pet);
    }
    public ArrayList<Vaccine> getVaccines(){
        return vaccines;
    }
    public ArrayList<Pet> getPets(){
        return pets;
    }

    public void addVaccine(String name, Date expirationDate) {
        Vaccine vaccine = new Vaccine(name, expirationDate);
        registerVaccine(vaccine);
    }
}
