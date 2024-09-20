package com.calvintam.ceilingfan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CeilingFan fan = new CeilingFan();

        Scanner s = new Scanner(System.in);

        String instructions = "Please press \"S\" for pulling the speed cord and \"D\" for pulling the direction cord. " + '\n'
                + "Please press \"C\" to check the current status of the fan. " + '\n'
                + "Please press \"E\" to exit the program. ";
        while (true){
            System.out.println(instructions);

            String str = s.nextLine();
            char input = str.toUpperCase().charAt(0);
            switch (input){
                case 'S':
                    fan.pullSpeedCord();
                    System.out.println(fan.getStatus());
                    break;
                case 'D':
                    fan.pullDirectionCord();
                    System.out.println(fan.getStatus());
                    break;
                case 'C':
                    System.out.println(fan.getStatus());
                    break;
                case 'E':
                    System.out.println("Thank you for using the program");
                    Thread.sleep(3000);
                    return;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }
    }
}
