/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author val41
 */
import Controleur.SimilariteController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
  
import Modele.Country;
import Modele.Indicateur;
import Modele.IndicateurValeur;
import Modele.HibernateUtil; 

public class App 
{   
     public static void main(String[] args) {
        SimilariteController test = new SimilariteController();
    }
}