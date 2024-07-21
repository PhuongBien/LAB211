/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Management;
import java.util.Scanner;
import util.Util;

/**
 *
 * @author CHI TRANG
 */
public class Menu {

    Management m = new Management();
    Scanner sc = new Scanner(System.in);
    Util u = new Util();

    public void printMenu() {
        boolean tf = true;
        System.out.println("===Menu===");
        while(tf){
        System.out.println("0. Adding new vehicle.");
        System.out.println("1. Checking exits Vehicle.");
        System.out.println("2. Updating vehicle.");
        System.out.println("3. Deleting vehicle.");
        System.out.println("4. Searching vehicle.");
        System.out.println("5. Displaying vehicle list.");
        System.out.println("6. Saving Vehicle to file.");
        System.out.println("7. Printing list Vehicles the file.");
        System.out.println("8.  Others Quit");
        
        int choice;
        choice = u.inputInt("Input your choice: ");
        
        switch (choice) {
            case 0:
                m.addVehicle();
                break;
            case 1:
                m.checkVehicle();
                break;
            case 2:
                m.updateVehicle();
                break;
            case 3:
                m.deleteVehicle();
                break;
            case 4:
                searchMenu();
                break;
            case 5:
                displayMenu();
                break;
            case 6:
                m.saveVehicle();
                break;
            case 7:
                printOutMenu();
                break;
            default:
                tf = false;
                System.out.println("bái bai!!");
                System.exit(0);
        }
    }}

    public void searchMenu() {
        while (true) {
            System.out.println("\nSEARCHING VEHICLE");
            System.out.println("1. Searching by id.");
            System.out.println("2. Searching by name.");
            System.out.println("3. Back to main menu.");
            int choice;
            choice = u.inputInt("Input your choice: ");
            switch (choice) {
                case 1:
                    m.searchById();
                    break;
                case 2:
                    m.searchByName();
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nDISPLAYING VEHICLE LIST");
            System.out.println("1. Displaying all.");
            System.out.println("2. Display prices in descending order");
            System.out.println("3. Back to main menu.");
            int choice;
            choice = u.inputInt("Input your choice: ");
            switch (choice) {
                case 1:
                    m.displayAll();
                    break;
                case 2:
                    m.displayPriceD();
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    public void printOutMenu() {
        while (true) {
            System.out.println("\nPRINTING VEHICLE LIST");
            System.out.println("1. Printing all.");
            System.out.println("2. Printing prices in descending order");
            System.out.println("3. Back to main menu.");
            int choice;
            choice = u.inputInt("Input your choice: ");
            switch (choice) {
                case 1:
                    m.printAll();
                    break;
                case 2:
                    m.printPriceD();
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
}
