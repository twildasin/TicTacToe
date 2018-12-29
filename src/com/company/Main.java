package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        int moves = 0;
        char grid [] [] = new char [3] [3];
        Scanner kbin = new Scanner(System.in);
        String in;
        boolean playerfirst = false;

        //clear the grid
        for(int i = 0; i<3; i++)
        { //made by tanner
            for (int k = 0; k < 3; k++) {
                grid[k][i] = ' ';
            }
        }

        System.out.println("Welcome to tic tac toe!\nInstructions:\n1: You are \"X's\", the computer is \"O's\"\n2: chose a position to place a marker by giving two coordinates");
        System.out.println("\nExamples, inputting \"23\" will place a marker to look like this:");
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
            moves++;
        }



        function.askForMove(grid);
        moves++;

        if(playerfirst && Objects.equals(grid [1] [1] , ' '))
        {
            grid [1] [1] = 'O';
            moves++;
            function.printgird(grid);
        }




        boolean tie;
        for(int i = moves; i < 9; i++)
        {
            if((playerfirst && moves % 2 == 0) || (!playerfirst && moves %  2 != 0))
            {
                function.askForMove(grid);
                moves++;
            }
            else
            {
                function.findMove(grid);
                moves++;
                function.printgird(grid);

            }
            if(function.checkWin(grid) == 0)
            {
                tie =false;
                System.out.println("Computer Won!");
                break;
            }
        }
        System.out.println("Tie!");







        /*for(int i = 0; i<3; i++)
        {
            for (int k = 0; k < 3; k++) {
                grid[k][i] = ' ';
            }
        }

        grid [1] [0] = 'O';
        grid [1] [1] = ' ';
        grid [2] [2] = ' ';
        grid [0] [0] = 'X';
        grid [0] [1] = ' ';
        grid [1] [2] = 'X';
        function.printgird(grid);
        //System.out.println(function.checkWin(grid));
        function.findMove(grid);
        //System.out.println(function.findStop(grid, ' ', 'O', 2));
        function.printgird(grid);*/



    }

}
