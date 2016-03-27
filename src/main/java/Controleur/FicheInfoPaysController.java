/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Country;
import Modele.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Maxence
 */
@RequestMapping("/FicheInfoPays")
public class FicheInfoPaysController {
     @RequestMapping("Accueil")
    public String TopFlop(final ModelMap pModel) {
        // page par défaut pour TopFlop
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
 
        // renvoie la liste des indicateurs possibles
        final List<Country> country = session.createQuery("from Country").list();
        session.close();
        pModel.addAttribute("ListeCountry", country);
 
        return "FicheInfoPays";
    }
    
    @RequestMapping(value = "/FicheInfoPaysController", method = RequestMethod.GET)
    public String Fiche_info_pays(HttpServletRequest request, final ModelMap pmodel) {
 
        // Récupération des paramètres.
        String pays = request.getParameter("Pays");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List results = null;
            String hql = "SELECT E FROM Country E WHERE E.CountryName='" + pays +"'";
            Query query = session.createQuery(hql);
            results = query.list();
            Country InfoPays = (Country)results.get(0);
            pmodel.addAttribute("InfoPays", InfoPays);
            return "FicheInfoPays";
    }
}
