package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.Vehicles;
import util.Util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CHI TRANG
 */
public class Management extends Vehicles {

    Util u = new Util();
    Scanner sc = new Scanner(System.in);
    List<Vehicles> listV = new ArrayList<>();

    public Management() {
        loadVehicle();
    }

    public void addVehicle() {
        do {
            String id = u.inputString("Input id: ");
            String name = u.inputString("Input name: ");
            String color = u.inputString("Input color: ");
            Double price = Double.parseDouble(u.inputString("Input price: "));
            String brand = u.inputString("Input brand: ");
            String type = u.inputString("Input type: ");
            String proYear = u.inputString("Input product year: ");

            Vehicles newVehicle = new Vehicles(id, name, color, price, brand, type, proYear);
            listV.add(newVehicle);

            if (!listV.isEmpty()) {
                System.out.println("***Adding new vehicle success***");
            } else {
                System.out.println("Adding new vehicle fail");
            }
        } while (u.select("Do you want to continue adding more vehicle (Y/N) : ", "Y|N", "Y", "N"));
    }

    public void checkVehicle() {
        do {
            String input = u.inputString("Input id: ");
            // 1. Check List chua vehicle
            if (listV != null) {
                // 2. Search for Vehicle
                if (findVehicle(input) != null) {
                    System.out.println("Exist Vehicle!");
                } else {
                    System.out.println("No Vehicle Found!");
                }
            } else {
                System.out.println("There are no vehicle have been added");
            }
        } while (u.select("Do you want to go back to the main menu (Y/N) : ", "Y|N", "N", "Y"));
    }

    public void updateVehicle() {
        if (listV != null) {
            String input = u.inputString("Input id: ");
            Vehicles vehicle = findVehicle(input);
            if (vehicle != null) {
                String newName = u.inputString("Input name: ");
                if (!newName.isEmpty()) {
                    vehicle.setName(newName);
                }
                String newColor = u.inputString("Input color: ");
                if (!newColor.isEmpty()) {
                    vehicle.setColor(newColor);
                }
                Double newPrice = u.inputPrice("Input price: ");
                if (!newPrice.equals(0.0)) {
                    vehicle.setPrice(newPrice);
                }
                String newBrand = u.inputString("Input brand: ");
                if (!newBrand.isEmpty()) {
                    vehicle.setBrand(newBrand);
                }
                String newType = u.inputString("Input type: ");
                if (!newType.isEmpty()) {
                    vehicle.setType(newType);
                }
                String newProYear = u.inputString("Input product year: ");
                if (!newProYear.isEmpty()) {
                    vehicle.setProductYear(newProYear);
                }
                System.out.println(vehicle);
            } else {
                System.out.println("Vehicle does not exist");
            }
        } else {
            System.out.println("There are no vehicle have been added in the list");

        }
    }

    public void deleteVehicle() {
        if (listV != null) {
            String input = u.inputString("Input id: ");
            Vehicles vehicle = findVehicle(input);
            if (vehicle != null) {
                if (u.select("Are you really want to delete this vehicle (Y/N) : ", "Y|N", "Y", "N")) {
                    listV.remove(vehicle);
                }
            } else {
                System.out.println("Vehicle does not exist");
            }
        } else {
            System.out.println("There are no vehicle have been added in the list");
        }
    }

    public void searchById() {
        String input = u.inputString("Input your search: ");
        List<Vehicles> results = new ArrayList<>();
        for (Vehicles vehicle : listV) {
            if (vehicle.getId().equals(input)) {
                results.add(vehicle);
            }
        }
        for (Vehicles result : results) {
            System.out.println(result);
        }
        if (results.isEmpty()) {
            System.out.println("Vehicle does not exist");
        }
    }

    public void searchByName() {
        String input = u.inputString("Input your search: ");
        List<Vehicles> results = new ArrayList<>();
        for (Vehicles vehicle : listV) {
            if (vehicle.getName().contains(input)) {
                results.add(vehicle);
                Collections.sort(results, new Comparator<Vehicles>() {
                    @Override
                    public int compare(Vehicles o1, Vehicles o2) {
                        return o2.getName().compareTo(o1.getName()); // giam dan
                    }
                });
            }

        }
        for (Vehicles result : results) {
            System.out.println(result);
        }
        if (results.isEmpty()) {
            System.out.println("Vehicle does not exist");
        }
    }

    public void displayAll() {
        if (listV != null) {
            for (Vehicles vehicle : listV) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("The list empty");
        }
    }

    public void displayPriceD() {
        if (listV != null) {
            List<Vehicles> results = new ArrayList<>();
            for (Vehicles vehicle : listV) {
                results.add(vehicle);
            }
            Collections.sort(results, Comparator.comparingDouble(Vehicles::getPrice).reversed());
            for (Vehicles result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println("The list empty");
        }
    }

     public void printAll() {
        if (listV != null) {
            for (Vehicles vehicle : listV) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("The list empty");
        }
    }

    public void printPriceD() {
        if (listV != null) {
            List<Vehicles> results = new ArrayList<>();
            for (Vehicles vehicle : listV) {
                results.add(vehicle);
            }
            Collections.sort(results, Comparator.comparingDouble(Vehicles::getPrice).reversed());
            for (Vehicles result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println("The list empty");
        }
    }

    public void saveVehicle() {
        try {
            FileOutputStream fileOut = new FileOutputStream("vehicle.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(listV);
            System.out.println("Data saved successfully.");
        } catch (IOException ex) {
            System.out.println("Error occurred while saving data: " + ex.getMessage());
        }

    }

    public void loadVehicle() {
        try {
            FileInputStream fileIn = new FileInputStream("vehicle.dat");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            listV = (List<Vehicles>) objIn.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error occurred while loading data: " + ex.getMessage());
        }
    }

    public void printListVehicle() {
        if (listV != null) {
            for (Vehicles vehicle : listV) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("The list empty");
        }
    }

    public Vehicles findVehicle(String id) {
        for (Vehicles vehicle : listV) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

}
