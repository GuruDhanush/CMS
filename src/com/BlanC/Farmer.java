package com.BlanC;
import com.csvreader.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 29-10-2016.
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

    }

    /*public String Division;
    public String Sector;
    public String Village; */



    public long RyotCode;
    public String AreaType;
    public String NativeBranch;
    public ArrayList<Farmer> Surety;
    public Person Nominee;
    public String Ryotclass;
    public String Category;
    public String WaterSources;
    public String SoilType;









}