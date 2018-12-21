package com.company;

import java.util.Objects;
import java.util.Random;

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
        if(function.checkInput(b)) {
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


}
