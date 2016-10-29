package com.BlanC;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 29-10-2016.
 */
public class Farmer
{
        public String FirstName;
        public String LastName;
        public int ID;

       public Farmer(String FName, String LName, int id)
        {
            this.FirstName = FName;
            this.LastName = LName;
            this.ID = id;
        }

        public Farmer()
        {

        }


        public void Entry() throws IOException
        {
            PrintWriter PW = new PrintWriter("Ryot.csv");
            PW.print("Name "); PW.println("RollNum");
            PW.print("Dhanush "); PW.println(123);
            PW.print("Guru "); PW.println(456);
            PW.print("QWERTY "); PW.println(567);

            PW.close();
        }
    }

