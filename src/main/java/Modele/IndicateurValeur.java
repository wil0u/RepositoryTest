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
@Table(name = "indicateurvaleur")
public class IndicateurValeur {
    @Id
    @Column(name = "id",unique= true, nullable = false, length = 20)
    private int Id;
    @Column(name = "CountryCode", nullable = false, length = 20)
    private String CountryCode;
    @Column(name = "IndicatorCode", nullable = false, length = 50)
    private String IndicatorCode;
    @Column(name = "Date", nullable = false, length = 10)
    private int Date;
    @Column(name = "Valeur", nullable = false)
    private double Valeur;
    @Column(name = "Nbrefoisrecherche", nullable = false, length = 11)
    private int Nbrefoisrecherche;

     public IndicateurValeur(){}
    
    public IndicateurValeur(int Id, String Country_Code, String Indicator_Code, int Date, double Valeur, int Nbrefoisrecherche) {
        this.Id = Id;
        this.CountryCode = Country_Code;
        this.IndicatorCode = Indicator_Code;
        this.Date = Date;
        this.Valeur = Valeur;
        this.Nbrefoisrecherche = Nbrefoisrecherche;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCountry_Code() {
        return CountryCode;
    }

    public void setCountry_Code(String Country_Code) {
        this.CountryCode = Country_Code;
    }

    public String getIndicator_Code() {
        return IndicatorCode;
    }

    public void setIndicator_Code(String Indicator_Code) {
        this.IndicatorCode = Indicator_Code;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int Date) {
        this.Date = Date;
    }

    public double getValeur() {
        return Valeur;
    }

    public void setValeur(double Valeur) {
        this.Valeur = Valeur;
    }

    public int getNbrefoisrecherche() {
        return Nbrefoisrecherche;
    }

    public void setNbrefoisrecherche(int Nbrefoisrecherche) {
        this.Nbrefoisrecherche = Nbrefoisrecherche;
    }
           
}
