package Controleur;

import Modele.Country;
import Modele.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/listepays")
public class RecupererListePaysController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String afficherPays(ModelMap pModel) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
        
        List<Country> listePays = session.createQuery("from Country").list();
       
        pModel.addAttribute("listePays", listePays);
        session.close();
        
        return "listePays";
    }
}