package Presenter;

import Models.Vet;
import Views.MainPage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<String> getVaccines(){
        ArrayList<String> vaccines = new ArrayList<>();
        for (int i = 0; i < vet.getVaccines().size(); i++) {
            vaccines.add(vet.getVaccines().get(i).getName());
        }
        return vaccines;
    }

    public void addVaccine(String name, Date expirationDate) {
        vet.addVaccine(name, expirationDate);
    }
}
