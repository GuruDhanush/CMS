package com.BlanC;
import com.BlanC.Check;

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

    public Farmer(String FName, String SurName, String address)
    {
        super(FName,SurName,address);
        //this.Name = FName;
        //this.SurName = SurName;
       // this.RyotCode = ryotcode;
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
    public void SetRyotCode(String ryotcode)
    {

    }

    private String AreaType;
    public String GetAreaType()
    {
        return this.AreaType;
    }
    public void SetReturnType(String areatype)
    {
        //ask father
    }


    private static String ftypes[] = {"Small","Medium","Large"};
    private static  String cat[] = {"O.C","B.C","S.C","S.T"};
    private static String watersourc[] = {"Bore Well", "Open Well", "Canal"};
    private static String soils[] = {"Black", "Red", "Sandy"};

    //public String NativeBranch;
    public ArrayList<Farmer> Surety;
    public Person Nominee;



    private String Category;
    public void SetCategory(String category)
    {
        if(Check.checklist(category,cat))
        {
            this.Category = category;
        }
    }
    public String getCategory() {return this.Category;}


    private String WaterSources;
    public void SetWaterSources(String watersources)
    {
        if(Check.checklist(watersources,watersourc))
        {
            this.WaterSources = watersources;
        }
    }
    public String GetWaterSources() {return this.WaterSources;}



    private String SoilType;
    public void SetSoilType(String soil)
    {
        if(Check.checklist(soil,soils))
        {
            this.SoilType = soil;
        }
    }
    public String GetSoilType() {return this.SoilType;}










}