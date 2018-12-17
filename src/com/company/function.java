package com.company;

import java.util.Objects;

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
        int col = Integer.parseInt(b.substring(0,1));
        int row = Integer.parseInt(b.substring(1,2));
        if(Objects.equals(a [col] [row], ' '))
        {
            a [col] [row] = 'X';
            function.printgird(a);
            return true;
        }
        else
        {
            function.printgird(a);
            return false;
        }

    }


}
