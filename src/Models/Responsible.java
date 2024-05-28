package Models;

import java.util.ArrayList;

public class Responsible {
    private String name;
    private String id;

    private ArrayList<Pet> pets;

    public Responsible(String name, String id) {
        this.name = name;
        this.id = id;
        pets = new ArrayList<>();
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
