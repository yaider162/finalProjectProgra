package Models;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    String name;
    ArrayList<Vaccine> vaccinesApplied;
    String type;
    String raze;
    String principalResponsibleName;

    public Pet(String petName, String type, String raze,  List<Vaccine> selectedValuesList) {
        name = petName;
        vaccinesApplied = new ArrayList<>();
        this.type = type;
        this.raze = raze;
    }

    public void applyVaccine(Vaccine vaccine) {
        vaccinesApplied.add(vaccine);
    }
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getRaze() {
        return raze;
    }

    public String getResponsible() {
        return this.principalResponsibleName;
    }

    public void setPrincipalResponsible(String principalResponsible) {
        this.principalResponsibleName = principalResponsible;
    }
}
