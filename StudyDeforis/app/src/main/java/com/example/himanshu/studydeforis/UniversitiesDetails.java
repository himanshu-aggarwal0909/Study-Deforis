package com.example.himanshu.studydeforis;

/**
 * Created by Himanshu on 19-10-2016.
 */
public class UniversitiesDetails {
    public String Name, Country , Type , Fees;
    public UniversitiesDetails(String Name , String Country , String Type , String Fees) {
        this.setName(Name);
        this.setCountry(Country);
        this.setType(Type);
        this.setFees(Fees);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFees() {
        return Fees;
    }

    public void setFees(String fees) {
        Fees = fees;
    }



}
