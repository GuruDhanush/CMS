package com.BlanC;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 13-11-2016.
 */
public  class Check
{
    File f = new File("Errors.txt");;

    public boolean CheckName(String name) throws IllegalArgumentException,IOException
    {
        boolean error = false;

        try
        {
            if (name.isEmpty())
            {
                throw new IllegalArgumentException("Name can't be empty");
            }
            else
            if (!(name.matches("[a-zA-Z]")))
            {
                throw new IllegalArgumentException("Name must have to be in alphabets");
            }

        }
        catch(IllegalArgumentException ie)
        {

            PrintWriter output = new PrintWriter(f);
            output.print(ie.getMessage());
            error = true;

        }
        catch (Exception e)
        {
            PrintWriter output = new PrintWriter(f);
            output.print(e.getMessage());
            error = true;
        }

        return !error;



    }

    public boolean checklist(String item, String[] category)   //for predefined list objects
    {
        boolean check = false;

        for(String object : category)
        {
            if(item.trim().equals(category))
            {
                check = true;
            }
        }
        return check;



    }

    public Boolean isType(String Str, String type) {
        try {
            if (type.equalsIgnoreCase("float")) {
                Float.parseFloat(Str);
            } else if (type.equalsIgnoreCase("int")) {
                Integer.parseInt(Str);
            } else if (type.equalsIgnoreCase("double")) {
                Double.parseDouble(Str);
            }
            return true;
        } catch(Exception e) {
            return false;
        }

    }
}
