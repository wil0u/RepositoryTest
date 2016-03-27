package Controleur;
 
import Modele.Country;
import Modele.HibernateUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class ComparerPaysController {
   
    @RequestMapping(value="/menuComparer", method = RequestMethod.GET)
    public String menuComparerPays(ModelMap pModel) {
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
       
        List<Country> listePays = session.createQuery("FROM Country E").list();
        List<Country> listeIndicateurs = session.createQuery("FROM Indicateur E").list();
       
        pModel.addAttribute("listePays", listePays);
        pModel.addAttribute("listeIndicateurs", listeIndicateurs);
       
        session.close();
       
        return "menuComparerPays";
    }
   
    @RequestMapping(value="/comparer", method = RequestMethod.GET)
    public String comparerPays(HttpServletRequest request, ModelMap pModel) {
       
        String erreur = "Aucune erreur";
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
       
        //Implementer le nombre d'indic et pays dynamiquement + tard
        //Constante de 2 pour tester
        int nbPays = 2;
        int nbIndic = 2;
       
        String pays[] = new String[nbPays];
        String paysCode[] = new String[nbPays];
        String indicateurs[] = new String[nbIndic];
        String indicateursCode[] = new String[nbIndic];
        double valeurs[][] = new double[nbPays][nbIndic];
       
        //Insertion des données basiques
        pModel.addAttribute("nbPays", nbPays);
        pModel.addAttribute("nbIndic", nbIndic);
       
        //Insertion des pays
        for (int i = 0 ; i < nbPays ; i++) {
            pays[i] = request.getParameter("pays"+(i+1));
            pModel.addAttribute("pays"+(i+1), pays[i]);
            paysCode[i] = (String) session.createQuery("SELECT E.CountryCode FROM Country E WHERE E.CountryName='"+pays[i]+"'").list().get(0);
            pModel.addAttribute("pays"+(i+1)+"Code", paysCode[i]);
        }
       
        //Insertion des indicateurs
        for (int i = 0 ; i < nbIndic ; i++) {
            indicateurs[i] = request.getParameter("indicateur"+(i+1));
            pModel.addAttribute("indic"+(i+1), indicateurs[i]);
            indicateursCode[i] = (String) session.createQuery("SELECT E.IndicatorCode FROM Indicateur E WHERE E.IndicatorName='"+indicateurs[i]+"'").list().get(0);
            pModel.addAttribute("indic"+(i+1)+"Code", indicateursCode[i]);
        }
       
        //Insertion des valeurs
        for (int i = 0 ; i < nbPays ; i++) {
            for (int j = 0 ; j < nbIndic ; j++) {
                if (session.createQuery("SELECT E.Valeur FROM IndicateurValeur E WHERE (E.CountryCode='"+paysCode[i]+"') AND (E.IndicatorCode='"+indicateursCode[j]+"')").list().isEmpty()) {
                    valeurs[i][j] = 0.0;
                    erreur = "Attention, certains indicateurs n'ont pas de valeurs";
                } else {
                    valeurs[i][j] = (double) session.createQuery("SELECT E.Valeur FROM IndicateurValeur E WHERE (E.CountryCode='"+paysCode[i]+"') AND (E.IndicatorCode='"+indicateursCode[j]+"')").list().get(0);
                }
                pModel.addAttribute("val"+(i+1)+"et"+(j+1), valeurs[i][j]);
            }
        }
       
        pModel.addAttribute("errorCode", erreur);
        session.close();
       
        return "comparerPays";
    }
    
    @RequestMapping(value="/histogramme", method = RequestMethod.GET)
    public void afficherGraphiqueHistogramme(final ModelMap pModel, HttpServletRequest request, HttpServletResponse response) throws IOException{

        String pays1 = request.getParameter("pays1");
        String pays2 = request.getParameter("pays2");
        double val1pays1 = Double.parseDouble(request.getParameter("val1pays1"));
        double val2pays1 = Double.parseDouble(request.getParameter("val2pays1"));
        double val1pays2 = Double.parseDouble(request.getParameter("val1pays2"));
        double val2pays2 = Double.parseDouble(request.getParameter("val2pays2"));
        String indicateur1 = request.getParameter("indic1");
        String indicateur2 = request.getParameter("indic2");

        System.out.println(pays1);
        System.out.println(pays2);
        System.out.println(val2pays2);
        System.out.println(val1pays2);
        System.out.println(val2pays1);
        System.out.println(val1pays1);

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(val1pays1, pays1, "Indicateur1");
        dataset.addValue(val2pays1, pays1, "Indicateur2");

        dataset.addValue(5534444.204, "Italie", "Indicateur1");
        dataset.addValue(2534444.204, "Italie", "Indicateur2");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Graphique de comparaison",
                "Indicateur", "Valeur",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 1200;
        /* Width of the image */
        int height = 800;
        /* Height of the image */


        OutputStream out = response.getOutputStream();
        response.setContentType("image/png");
        ChartUtilities.writeChartAsPNG(out, barChart, width, height);

    }
}