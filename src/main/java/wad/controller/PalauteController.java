package wad.controller;

import java.util.ArrayList;
import java.util.List;
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
import wad.repository.PalauteRepository;
import wad.repository.TehtavaRepository;

@Controller
public class PalauteController {
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    
    @Autowired
    private TehtavaRepository tehtavaRepo;
    
    @Autowired
    private PalauteRepository palauteRepo;
    
    @RequestMapping(value = "/tehtava/{id}/palaute", method = RequestMethod.POST)
    public String kasittelePalaute(@PathVariable String id, Model model, @RequestParam String palauteTeksti) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Kayttaja kayttaja = kayttajaRepo.findByName(auth.getName());
        Tehtava tehtava = tehtavaRepo.findOne(id);
        
        Palaute palaute = new Palaute();
        palaute.setPalaute(palauteTeksti);
        palaute.setPalautteenAntaja(kayttaja);
        palaute.setTehtava(tehtava);
        System.out.println("");
        palauteRepo.save(palaute);
        
        return "redirect:/tehtava/" + id;
    }
    
    @RequestMapping(value="/palautteet", method = RequestMethod.GET)
    public String naytaPalautteet(Model model) {
        model.addAttribute("tehtavat", tehtavaRepo.findAll());
        return "palauteindex";
    }
    
    @RequestMapping(value="/tehtava/{id}/palaute", method = RequestMethod.GET)
    public String yhdenTehtavanPalautteet(@PathVariable String id, Model model) {
        Tehtava tehtava = tehtavaRepo.findOne(id);
        
        List<Palaute> halutut = palauteRepo.findByTehtava(tehtava);
        
        model.addAttribute("palautteet", halutut);
        
        return "tehtavanpalautteet";
    }
}
