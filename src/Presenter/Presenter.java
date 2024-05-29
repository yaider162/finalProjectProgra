package Presenter;

import Models.Appointment;
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
    private List<Vaccine> vaccines = new ArrayList<>();

    public static void main(String[] args) throws IOException, FontFormatException {
        Presenter presenter = new Presenter();
        vet = new Vet();
        presenter.menu();
    }

    public void menu() throws IOException, FontFormatException {
        mainPage = new MainPage(this);
    }

    public void addVaccine(String name, String species, Date expirationDate) {
        Vaccine vaccine = new Vaccine(name, species, expirationDate);
        vaccines.add(vaccine);
    }

    public String[][] getVaccines() {
        String[][] data = new String[vaccines.size()][3];
        for (int i = 0; i < vaccines.size(); i++) {
            data[i][0] = vaccines.get(i).getName();
            data[i][1] = vaccines.get(i).getSpecies();
            data[i][2] = vaccines.get(i).getDeadLine();
        }
        return data;
    }

    public void addNewAppointment(String petName, String ownerName, String ownerId, String specie, String sex, Date date) throws IOException {
        vet.addAppointment(petName, ownerName, ownerId, specie,sex, date);
    }

    public String[][] getAppointments() {
        ArrayList<Appointment> appointments = vet.getAppointments();
        String[][] data = new String[appointments.size()][6];
        for (int i = 0; i < appointments.size(); i++) {
            data[i][0] = appointments.get(i).getPetName();
            data[i][1] = appointments.get(i).getOwnerName();
            data[i][2] = appointments.get(i).getOwnerId();
            data[i][3] = appointments.get(i).getSpecie();
            data[i][4] = appointments.get(i).getSex();
            data[i][5] = appointments.get(i).getDate().toString();
        }
        return data;
    }

    public String[][] getAppointmentsByOwner(String ownerId) {
        ArrayList<Appointment> appointments = vet.getAppointments();
        ArrayList<Appointment> appointmentsByOwner = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getOwnerId().equals(ownerId)) {
                appointmentsByOwner.add(appointment);
            }
        }
        String[][] data = new String[appointmentsByOwner.size()][6];
        for (int i = 0; i < appointmentsByOwner.size(); i++) {
            data[i][0] = appointmentsByOwner.get(i).getPetName();
            data[i][1] = appointmentsByOwner.get(i).getOwnerName();
            data[i][2] = appointmentsByOwner.get(i).getOwnerId();
            data[i][3] = appointmentsByOwner.get(i).getSpecie();
            data[i][4] = appointmentsByOwner.get(i).getSex();
            data[i][5] = appointmentsByOwner.get(i).getDate().toString();
        }
        return data;
    }

    public String[][] getAppointmentsByDate(String date) {
        ArrayList<Appointment> appointments = vet.getAppointments();
        ArrayList<Appointment> appointmentsByDate = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDate().toString().equals(date)) {
                appointmentsByDate.add(appointment);
            }
        }
        String[][] data = new String[appointmentsByDate.size()][6];
        for (int i = 0; i < appointmentsByDate.size(); i++) {
            data[i][0] = appointmentsByDate.get(i).getPetName();
            data[i][1] = appointmentsByDate.get(i).getOwnerName();
            data[i][2] = appointmentsByDate.get(i).getOwnerId();
            data[i][3] = appointmentsByDate.get(i).getSpecie();
            data[i][4] = appointmentsByDate.get(i).getSex();
            data[i][5] = appointmentsByDate.get(i).getDate().toString();
        }
        return data;
    }
}
