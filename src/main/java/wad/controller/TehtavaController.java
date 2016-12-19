
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kayttaja;
import wad.domain.Palaute;
import wad.domain.Tehtava;
import wad.repository.KayttajaRepository;
import wad.repository.LevelRepository;
import wad.repository.PalauteRepository;
import wad.repository.TehtavaRepository;

@Controller
public class TehtavaController {
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    
    @Autowired
    private TehtavaRepository tehtavaRepo;
    
    @Autowired
    private LevelRepository levelRepo;
    
    @Autowired
    private PalauteRepository palauteRepo;
    
    @RequestMapping(value = "/tehtava/{id}", method = RequestMethod.GET)
    public String naytaTehtava(@PathVariable String id, Model model) {
        
        Tehtava teht = tehtavaRepo.findOne(id);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String kayttajanNimi = auth.getName();
        Kayttaja kk = kayttajaRepo.findByName(kayttajanNimi);
        
        model.addAttribute("kayttaja", kk);
        model.addAttribute("ohje", "ANNA VASTAUS!");
        model.addAttribute("tehtava", teht);
        
        return "tehtava";
    }
    
    @RequestMapping(value = "/tehtava/{id}", method = RequestMethod.POST)
    public String kasitteleVastaus(@PathVariable String id, Model model, @RequestParam int vastaus) {
        Tehtava tehtava = tehtavaRepo.findOne(id);
        int oikeaVastaus = tehtava.getVastaus();
        
        if(vastaus == oikeaVastaus) {
            Tehtava uusiTehtava = tehtava.getNext();
            if(uusiTehtava == null) {
                return "redirect:/levelup";
            }
            return "redirect:/tehtava/" + uusiTehtava.getId();
        }
        
        return "redirect:/tehtava/" + id;
    }
    
    @RequestMapping(value = "/tehtava/{id}/palaute", method = RequestMethod.POST)
    public String kasittelePalaute(@PathVariable String id, Model model, @RequestParam String palauteTeksti) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Kayttaja kayttaja = kayttajaRepo.findByName(auth.getName());
        Tehtava tehtava = tehtavaRepo.findOne(id);
        Palaute palaute = new Palaute();
        palaute.setPalaute(palauteTeksti);
        palaute.setPalautteenAntaja(kayttaja);
        palaute.setPalautteenKohde(tehtava);
        palauteRepo.save(palaute);      
        return "redirect:/tehtava/" + id;
    }
    
    @RequestMapping(value="/palautteet", method = RequestMethod.GET)
    public String naytaPalautteet(Model madonna) {
        madonna.addAttribute("tehtavat", tehtavaRepo.findAll());
        return "palauteindex";
    }
    
    @RequestMapping(value="/tehtava/{id}/palaute", method = RequestMethod.GET)
    public String yhdenTehtavanPalautteet () {
        
        
        
        return "tehtavanpalautteet";
    }
}
