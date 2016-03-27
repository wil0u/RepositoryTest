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
@Table(name = "indicateur")
public class Indicateur {
    @Id
    @Column(name = "IndicatorCode",unique= true, nullable = false, length = 50)
    private String IndicatorCode;
    @Column(name = "IndicatorName", nullable = false, length = 300)
    private String IndicatorName;
    @Column(name = "Source_note", nullable = false, length = 1500)
    private String Source_note;
    @Column(name = "Source_Organization", nullable = false, length = 300)
    private String Source_Organization;
    @Column(name = "Theme", nullable = false, length = 20)
    private String Theme;

    public Indicateur() {
    }

    public Indicateur(String IndicatorCode, String IndicatorName, String Source_note, String Source_Organization, String Theme) {
        this.IndicatorCode = IndicatorCode;
        this.IndicatorName = IndicatorName;
        this.Source_note = Source_note;
        this.Source_Organization = Source_Organization;
        this.Theme = Theme;
    }

    public String getIndicatorCode() {
        return IndicatorCode;
    }

    public void setIndicatorCode(String IndicatorCode) {
        this.IndicatorCode = IndicatorCode;
    }

    public String getIndicatorName() {
        return IndicatorName;
    }

    public void setIndicatorName(String IndicatorName) {
        this.IndicatorName = IndicatorName;
    }

    public String getSource_note() {
        return Source_note;
    }

    public void setSource_note(String Source_note) {
        this.Source_note = Source_note;
    }

    public String getSource_Organization() {
        return Source_Organization;
    }

    public void setSource_Organization(String Source_Organization) {
        this.Source_Organization = Source_Organization;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String Theme) {
        this.Theme = Theme;
    }
    
    
}
