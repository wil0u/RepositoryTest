/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.HibernateUtil;
import Modele.Indicateur;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ut
 */
//@RequestMapping(method = RequestMethod.GET)

@Controller
public class TopPaysController {

    @RequestMapping("/TopFlop")
    public String TopFlop(final ModelMap pModel) {
        // page par défaut pour TopFlop
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // renvoie la liste des indicateurs possibles
        final List<Indicateur> indicateur = session.createQuery("from Indicateur").list();
        session.close();
        pModel.addAttribute("ListeIndicateur", indicateur);

        return "TopFlop";
    }

    public static String IndicatorName_vers_IndicatorCode(String indicateurname, Session session)
    {
        List results = null;
        String hql = "SELECT E.IndicatorCode FROM Indicateur E WHERE E.IndicatorName='"+indicateurname+"'";
        Query query = session.createQuery(hql);
        results = query.list();
        String indicateurcode = (String)results.get(0);
        return indicateurcode;
    }
    
    
    public static Object[][] Top_pays_indicateur(String indicateur, String date, String top) {
        
           if(top.equals("top"))
        {
            top="asc";
        }
        else
        {
            top ="desc";
        }
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        indicateur = IndicatorName_vers_IndicatorCode(indicateur,session);
        
        //selection des noms de pays
        String hql = "SELECT E.CountryName FROM Country E, IndicateurValeur Z WHERE Z.IndicatorCode='"+indicateur+"' AND E.CountryCode=Z.CountryCode AND Date=" +date+" order by Z.Valeur " +top;
        System.out.println(hql);
        Query query = session.createQuery(hql);
        
        List results = null;
        results = query.list();
        
        //selection des valeurs associées
        String hql_valeur = "SELECT Z.Valeur FROM Country E, IndicateurValeur Z WHERE Z.IndicatorCode='"+ indicateur +"' AND E.CountryCode=Z.CountryCode AND Date=" +date+" order by Z.Valeur "+top;
        System.out.println(hql_valeur);
        Query query_valeur = session.createQuery(hql_valeur);
        
        List results_valeur = null;
        results_valeur = query_valeur.list();
        
        Object[][] top_pays_valeur = new Object[results.size()][2];
        
        // remplissage du tableau 
        for(int i=0;i<results.size();i++)
        {
            top_pays_valeur[i][0] = results.get(i);
            top_pays_valeur[i][1] = results_valeur.get(i);
        }
                     
        //affichage console        
        for(int j=0;j<top_pays_valeur.length;j++)
        {
            for(int k=0;k<top_pays_valeur[0].length;k++)
            {
                System.out.print(top_pays_valeur[j][k]+"   ");
            }
            System.out.println();
        }

        session.close();
        return top_pays_valeur;
    }
    
 
    @RequestMapping(value = "/TopPaysController", method = RequestMethod.GET)
    public String Top_pays_indicateur(HttpServletRequest request, final ModelMap pmodel) {

        // Récupération des paramètres.
        String indicateur = request.getParameter("Indicateur");
        String date = request.getParameter("Date");
        String top = request.getParameter("TopFlop");
        System.out.println("Indicateur : " +indicateur);
        System.out.println("Date : " +date);
        System.out.println("Top : " +top);
        
       // appelle la fonction qui me renvoie country et valeur pour l'indicateur donné 
       //
       Object[][] top_pays_valeur = Top_pays_indicateur(indicateur, date, top);
       
       final List<String> noms = new ArrayList<String>();
       final List <String>valeurs = new ArrayList<String>();
       
       
       // remise des données dans deux listes différentes               
        for(int i=0;i<top_pays_valeur.length;i++)
        {   noms.add((String)top_pays_valeur[i][0]);
            System.out.println("Nom["+i+"] : " +(String)top_pays_valeur[i][0]);
            String wait = String.valueOf(top_pays_valeur[i][1]);
            valeurs.add(wait);
            System.out.println("Valeurs["+i+"] : " +String.valueOf(top_pays_valeur[i][1]));
        }
       
       pmodel.addAttribute("Noms", noms);
       pmodel.addAttribute("Valeurs", valeurs);
       return "TopFlop2";

        }
    
   

    }

