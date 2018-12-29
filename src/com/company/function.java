package com.company;

import java.util.Objects;
//wildasin,t
import java.util.Random;
import java.util.Scanner;

/**
 * Created by tw073 on 12/17/18.
 */
public class function {



    public static void printgird (char [] [] a)
    {
        System.out.println("\n");
        for(int i = 0; i<3; i++)
        {
            System.out.print("  " + a[0] [i] + ((i==2) ? "  " : "  |"));
        }
        System.out.println("\n------------------");

        for(int i = 0; i<3; i++)
        {
            System.out.print("  " + a[1] [i] + ((i==2) ? "  " : "  |"));
        }
        System.out.println("\n------------------");

        for(int i = 0; i<3; i++)
        {
            System.out.print("  " + a[2] [i] + ((i==2) ? "  " : "  |"));
        }
        System.out.println("\n");
    }

    public static boolean markplayer (char [] [] a, String b)
    {
        b = b.replaceAll(" ", "");
        if(function.checkInput(b)) { //TJW as here
            int col = Integer.parseInt(b.substring(0, 1));
            int row = Integer.parseInt(b.substring(1, 2));
            if (Objects.equals(a[col][row], ' '))
            {
                a[col][row] = 'X';
                function.printgird(a);
                return true;
            }
            else
            {
                function.printgird(a);
                return false;
            }
        }
        else return false;

    }

    public static String getOpen (char [] [] a)
    {
        String out = "";
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 3; k++)
            {
                if (Objects.equals(a [i] [k], ' '))
                {
                    //System.out.println("" + i + "" + k + ",");
                    out = out + "" + i + "" + k + ",";
                }
            }
        }
        return out;
    }

    public static void playRandom (char [] [] a)
    {
        String in = function.getOpen(a);
        Random rn = new Random();
        int i = rn.nextInt(in.length() / 3);
        a [Integer.parseInt(in.substring(i*3, (i*3 +1)))] [Integer.parseInt(in.substring(i*3 + 1, (i*3 +2)))] = 'O';
        function.printgird(a);

    }

    private static boolean checkInput (String a)
    {
        int first = -1;
        int second = -1;
        try
        {
            first = Integer.parseInt(a.substring(0,1));
            second = Integer.parseInt(a.substring(1,2));
        }
        catch (NumberFormatException e)
        {
            //return false;
        }

        if(first >= 0 && first < 3 && second >= 0 && second <3)
            return true;

        else
            return false;

    }

    public static int checkWin(char [] [] a)
    {
        int Xwin = -1;
        for(int i = 0; i < 3; i++)
        {
            Xwin = ((Objects.equals(a [i] [0], 'X') && (Objects.equals(a [i] [1], 'X')) && (Objects.equals(a [i] [2], 'X'))) ? 1 : Xwin);
            Xwin = ((Objects.equals(a [0] [i], 'X') && (Objects.equals(a [1] [i], 'X')) && (Objects.equals(a [2] [i], 'X'))) ? 1 : Xwin);

            Xwin = ((Objects.equals(a [i] [0], 'O') && (Objects.equals(a [i] [1], 'O')) && (Objects.equals(a [i] [2], 'O'))) ? 0 : Xwin);
            Xwin = ((Objects.equals(a [0] [i], 'O') && (Objects.equals(a [1] [i], 'O')) && (Objects.equals(a [2] [i], 'O'))) ? 0 : Xwin);
        }

        Xwin = ((Objects.equals(a [0] [0], 'X') && (Objects.equals(a [1] [1], 'X')) && (Objects.equals(a [2] [2], 'X'))) ? 1 : Xwin);
        Xwin = ((Objects.equals(a [0] [2], 'X') && (Objects.equals(a [1] [1], 'X')) && (Objects.equals(a [2] [0], 'X'))) ? 1 : Xwin);

        Xwin = ((Objects.equals(a [0] [0], 'O') && (Objects.equals(a [1] [1], 'O')) && (Objects.equals(a [2] [2], 'O'))) ? 0 : Xwin);
        Xwin = ((Objects.equals(a [0] [2], 'O') && (Objects.equals(a [1] [1], 'O')) && (Objects.equals(a [2] [0], 'O'))) ? 0 : Xwin);
    return Xwin;
    }

    public static void findMove (char [] [] a)
    {
        String compWin = function.findStop(a,'O',' ', 1);
        String playerWin = function.findStop(a,'X',' ', 1);
        String increase = function.findStop(a, ' ', 'O', 2);
        if(Objects.equals(compWin, "-1"))
        {
            if(Objects.equals(playerWin, "-1"))
            {
                if(Objects.equals(increase, "-1"))
                {
                    function.playRandom(a);
                }
                else // If system detects move to branch off of its own marker
                {
                    a [Integer.parseInt(increase.substring(0,1))] [Integer.parseInt(increase.substring(1,2))] = 'O';
                }
            }
            else // If  system found potential win for player
            {
                a [Integer.parseInt(playerWin.substring(0,1))] [Integer.parseInt(playerWin.substring(1,2))] = 'O';
            }
        }
        else // If system found potential win for computer (Made by tanner)
        {
            a [Integer.parseInt(compWin.substring(0,1))] [Integer.parseInt(compWin.substring(1,2))] = 'O';
        }

    }

    public static void askForMove (char [] [] a)
    {
        String in = "";
        Scanner kbin = new Scanner(System.in);
        System.out.println("Please enter to coordinate to play:");
        while(true)
        {
            in = kbin.nextLine();
            in = (Objects.equals(in, "11") ? "20" : in);
            in = (Objects.equals(in, "21") ? "21" : in);
            in = (Objects.equals(in, "31") ? "22" : in);
            in = (Objects.equals(in, "12") ? "10" : in);
            in = (Objects.equals(in, "22") ? "11" : in);
            in = (Objects.equals(in, "32") ? "12" : in);
            in = (Objects.equals(in, "13") ? "00" : in);
            in = (Objects.equals(in, "23") ? "01" : in);
            in = (Objects.equals(in, "33") ? "02" : in);

            if (function.markplayer(a, in) == true)
            {
                break;
            }
            else {
                System.out.println("Invalid Input, please enter a valid coordinate that is not in use (Ex: \"01\")");
            }
        }
    }

    public static String findStop (char [] [] a, char primary, char secondary, int choice)
    {
        boolean end = false;
        boolean endy = false;
        //int posb1 = 3;
        //by tanner
        //int posb2 = 3;
        int col = -1;
        int row = -1;
        int d = -1;
        int d2 = -1;
        int pos1 = 3;
        int pos2 = 3;
        int pos1y = 3;
        int pos2y = 3;
        int countx = 0;
        int count_ = 0;
        int county = 0;
        int county_ = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 3; k++)
            {

                if(Objects.equals(a [i] [k], secondary))
                {
                    count_++;
                    if(choice == 1)
                    {
                        pos1 = i;
                        pos2 = k;
                    }
                }
                if(Objects.equals(a [i] [k], primary))
                {
                    if (choice == 2)
                    {
                        pos1 = i;
                        pos2 = k;
                    }
                    countx++;
                }
                if (countx == 2 && count_ == 1)
                {
                    col = i;
                    end = true;
                }

                //-------------------------------------------------------


                if(Objects.equals(a [k] [i], secondary))
                {
                    county_++;
                    if(choice == 1)
                    {
                        pos1y = i;
                        pos2y = k;
                    }
                }
                if(Objects.equals(a [k] [i], primary))
                {
                    if (choice == 2)
                    {
                        pos1y = i;
                        pos2y = k;
                    }
                    county++;
                }
                if (county == 2 && county_ == 1)
                {
                    row = i;
                    endy = true;
                }


            }
            countx = 0;
            count_ = 0;
            county = 0;
            county_ = 0;
            //by tanner
            if (end || endy)
                break;
            pos1 = 3;
            pos2 = 3;
            pos1y = 3;
            pos2y = 3;
        }

        //---------------------------------------------------------


        boolean endd = false;
        int pos1d = 0;
        int pos2d = 0;
        int countd = 0;
        int count_d = 0;
        for(int i = 0; i < 3; i++)
        {

            if(Objects.equals(a [i] [i], secondary))
            {
                count_d++;
                if(choice == 1)
                {
                    pos1d = i;
                    pos2d = i;
                }
            }
            if(Objects.equals(a [i] [i], primary))
            {
                if(choice == 2)
                {
                    pos1d = i;
                    pos2d = i;
                }
                countd++;
            }
            if (countd == 2 && count_d == 1)
            {
                d = 1;
                endd = true;
            }
            else if (i == 2)
            {
                pos1d = 3;
                pos2d = 3;
            }
        }

        if (!endd)
        {
            count_d = 0;
            countd = 0;
            int inv = 2;


            for(int i = 0; i < 3; i++)
            {
                if(Objects.equals(a [inv] [i], primary))
                {
                    if(choice == 2)
                    {
                        pos1d = inv;
                        pos2d = i;
                    }
                    countd++;
                }
                if(Objects.equals(a [inv] [i], secondary))
                {
                    count_d++;
                    if(choice == 1)
                    {
                        pos1d = inv;
                        pos2d = i;
                    }
                }
                if (countd == 2 && count_d == 1)
                {
                    d = 2;
                    endd = true;
                }
                else if (i == 2)
                {
                    pos1d = 3;
                    pos2d = 3;
                }
                inv--;
            }


        }

        //---------------------------------------------------------
        //System.out.println(pos1d + "" + pos2d);



        if(end)
            return (pos1 + "" + pos2);
        else if (endy)
            return (pos2y + "" + pos1y);
        else if (endd)
            return (pos1d + "" + pos2d);

        else
            return ("-1");
    }



}
