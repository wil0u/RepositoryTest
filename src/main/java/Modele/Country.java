/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author val41
 */
@Entity
@Table(name = "country")
public class Country {

    @Column(name = "CountryName", nullable = false, length = 50)
    private String CountryName;
    @Id
    @Column(name = "CountryCode",unique= true, nullable = false, length = 50)
    private String CountryCode;

    @Column(name = "Region", nullable = false, length = 50)
    private String Region;

    @Column(name = "Income_Group", nullable = false, length = 300)
    private String Income_Group;

    @Column(name = "PIB", nullable = false)
    private double PIB;
    
    @Column(name = "IDH", nullable = false)
    private double IDH;

    @Column(name = "Superficie", nullable = false)
    private double Superficie;

    @Column(name = "Population", nullable = false, length = 10)
    private int Population;

    public Country() {
    }

    public Country(String CN, String CC, String R, String IG, double PI, double ID, double SUP, int POP) {
        CountryName = CN;
        CountryCode = CC;
        Region = R;
        Income_Group = IG;
        PIB = PI;
        IDH = ID;
        Superficie = SUP;
        Population = POP;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getIncome_Group() {
        return Income_Group;
    }

    public void setIncome_Group(String Income_Group) {
        this.Income_Group = Income_Group;
    }

    public double getPIB() {
        return PIB;
    }

    public void setPIB(double PIB) {
        this.PIB = PIB;
    }

    public double getIDH() {
        return IDH;
    }

    public void setIDH(double IDH) {
        this.IDH = IDH;
    }

    public double getSuperficie() {
        return Superficie;
    }

    public void setSuperficie(double Superficie) {
        this.Superficie = Superficie;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }
}
