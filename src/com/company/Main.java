package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        char grid [] [] = new char [3] [3];
        Scanner kbin = new Scanner(System.in);
        String in;
        boolean playerfirst = false;

        //clear the grid
        for(int i = 0; i<3; i++)
        {
            grid [0] [i] = ' ';
            grid [1] [i] = ' ';
            grid [2] [i] = ' ';
        }

        System.out.println("Welcome to tic tac toe!\nInstructions:\n1: You are \"X's\", the computer is \"O's\"\n2: chose a position to place a marker by giving two coordinates");
        System.out.println("\nExamples, inputting \"01\" will place a marker to look like this:");
        grid [0] [1] = 'X';
        function.printgird(grid);
        grid [0] [1] = ' ';
        System.out.println("Please choose who would like to go first, player or computer?");

        //Fail-safe system to make sure user inputs to correct input
        while(true)
        {
            in = kbin.nextLine().toLowerCase();
            if(Objects.equals(in, "player"))
            {
                playerfirst = true;
                break;
            }
            else if (Objects.equals(in,"computer"))
            {
                playerfirst = false;
                break;
            }
            else
            {
                System.out.println("Invalid input, please input either \"player\" or \" computer\"");
            }
        }

        if (!playerfirst)
        {
            grid[0][0] = 'O';
            function.printgird(grid);
        }
        System.out.println("Please enter to coordinate to play:");
        in = kbin.nextLine();
        if(function.markplayer(grid, in) == true)
        {

        }
        else
        {
            System.out.println("Coordinate already in use, please enter another input");
        }





    }

}
