/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author CHI TRANG
 */
public class Util {

    private final Scanner sc = new Scanner(System.in);

    public String inputString(String msg) {
        System.out.print(msg);
        String input = sc.nextLine();
        return input;
    }

    public int inputInt(String msg) {
        boolean check = true;
        String input = "";
        String regex = "\\d+";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.matches(regex)) {
                check = false;
            } else if(input.isEmpty()){
                System.out.println("You cannot leave the input field blank");
            }else {
                System.out.println("Invalid value - Please input the number");
            }
        } while (check);
        return Integer.parseInt(input);

    }
    public Double inputPrice(String msg) {
        boolean check = true;
        String input = "";
        String regex = "\\d+";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.matches(regex)) {
                check = false;
            } else if (input.isEmpty()) {
                double out = 0;
                return out;
            } else {
                System.out.println("Invalid value: Please input the number");
            }
        } while (check);
        return Double.parseDouble(input);

    }

    public String updatePrice(String msg) {
        boolean check = true;
        String input = "";
        String regex = "\\d+";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.matches(regex)) {
                check = false;
            } else if (input.isEmpty()) {
                return input;
            } else {
                System.out.println("Invalid value: Please input the number");
            }
        } while (check);
        return input;

    }

    public boolean select(String msg, String pattern, String option1, String option2) {
        boolean check = true;
        boolean result = true;
        String choice = inputString(msg).toUpperCase();
        do {
            if (!choice.matches(pattern)) {
                System.out.println("Please enter one of the options given");
            } else if (choice.equals(option1)) {
                check = false;
                result = true;
            } else {
                check = false;
                result = false;
            }
        } while (check);
        return result;
    }
}
