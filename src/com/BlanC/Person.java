package com.BlanC;

import java.io.IOException;

/**
 * Created by Guru on 30-10-2016.
 */

public class Person
{
    public Person()
    {

    }
    public Person(String name,String surname,String address)
    {
        this.Name = name;
        this.SurName = surname;
        this.Address = address;
    }

    private String Name;
    public void SetName(String name) throws IOException
    {
        if(Check.CheckString(name))
        {
            this.Name = name;
        }
    }
    public String GetName() {return this.Name;}


    private String SurName;
    public void SetSurName(String surname) throws IOException
    {
        if(Check.CheckString(surname))
        {
            this.SurName = surname;
        }
    }
    public String GetSurName() {return this.SurName;}

    private String Address;
    public void SetAddress(String address) throws IOException
    {
        if(Check.CheckString(address))
        {
            this.Address = address;
        }
    }
    public String GetAddress() {return this.Address;}



    public long PhoneNumber;
    public void SetPhoneNumber(String phonenumber)
    {
        if(Check.isType(phonenumber,"long"))
        {
            if(phonenumber.matches("\\d{10}"))
            {
                this.PhoneNumber = Long.parseLong(phonenumber);
            }
        }
    }
    public long GetPhoneNumber() { return this.PhoneNumber;}


    public  long MobileNumber;
    public void SetMobileNumber(String mobilenumber)
    {
        if(Check.isType(mobilenumber,"long"))
        {
            if(mobilenumber.matches("\\d{10}"))
            {
                this.MobileNumber = Long.parseLong(mobilenumber);
            }
        }
    }
    public long GetMobileNumber() { return this.MobileNumber;}

    public long AadharNumber;
    public void SetAadharNumber(String aadharnumber)
    {
        if(Check.isType(aadharnumber,"long"))
        {
            if(aadharnumber.matches("\\d{12}"))
            {
                this.AadharNumber = Long.parseLong(aadharnumber);
            }
        }
    }
    public long GetAadharNumner() {return this.AadharNumber;}

    public long PanCardNumber;
    public void SetPanCardNumber(String pancard)
    {
        if(Check.isType(pancard, "long"))
        {
            if(pancard.matches("\\d{10}"))
            {
                this.PanCardNumber = Long.parseLong(pancard);
            }
        }
    }
    public long GetPanCardNumber() { return this.PanCardNumber;}

    public String Bank;
    public void SetBank(String bank) throws IOException
    {
        if(Check.CheckString(bank))
        {
            this.Bank = bank;
        }
    }
    public String GetBank() {return this.Bank;}

    public String Branch;
    public void SetBranch(String branch) throws IOException
    {
        if(Check.CheckString(branch))
        {
            this.Branch = branch;
        }
    }
    public String GetBranch() {return this.Branch;}

    public long AccountNumber;
    public void SetAccountNumber(String accountnumber)
    {
        if(Check.isType(accountnumber,"long"))
        {
            if(accountnumber.matches("\\d{14}"))
            {
                this.AccountNumber = Long.parseLong(accountnumber);
            }
        }
    }
    public long GetAccountNumber() { return this.AccountNumber;}

    public String BankIFSCCode;
    public void SetIFSCCode(String ifsccode)
    {
        if(ifsccode.matches("\\D{4}\\d{7}"))
        {
            this.BankIFSCCode = ifsccode;
        }
    }
    public String GetIFSCCode() {return this.BankIFSCCode; }

}
