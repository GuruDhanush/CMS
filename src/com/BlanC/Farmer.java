package com.BlanC;
import com.csvreader.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Guru on 29-10-2016.
 */

public class Farmer extends Person
{

    public Farmer(String FName, String SurName, int ryotcode, String address)
    {
        super(FName,SurName,address);
        //this.Name = FName;
        //this.SurName = SurName;
        this.RyotCode = ryotcode;
    }

    public Farmer()
    {
        //default constructor
    }

    //we will get the data from extending
    /*public String Division;
    public String Sector;
    public String Village; */



    public long RyotCode;

    private String AreaType;
    public String GetAreaType()
    {
        return this.AreaType;
    }
    public void SetReturnType(String areatype)
    {
        //ask father
    }



    public String NativeBranch;
    public ArrayList<Farmer> Surety;
    public Person Nominee;

    private String Ryotclass;

    public void SetRyotClass(String ryotclass, String[])
    public String GetRyotClass() {return this.Ryotclass;}


    public String Category;
    public void SetCategory(String category)
    {

        for(String categor : cat)
        {
            if(category.trim().equals(categor))
            {
                this.Category = category;
            }
        }
    }
    public String getCategory() {return this.Category;}

    public String WaterSources;


    public String SoilType;









}