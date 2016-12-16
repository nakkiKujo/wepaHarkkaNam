
package wad.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Kayttaja;
import wad.domain.Level;
import wad.domain.Tehtava;
import wad.repository.KayttajaRepository;
import wad.repository.LevelRepository;
import wad.repository.TehtavaRepository;

@Controller
public class KayttajaController {
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    
    @Autowired
    private TehtavaRepository tehtavaRepo;
    
    @Autowired
    private LevelRepository levelRepo;
    
    @RequestMapping(value = "/epeli", method = RequestMethod.GET)
    public String list(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String kayttajanNimi = auth.getName();
        Kayttaja kayttaja = kayttajaRepo.findByName(kayttajanNimi);
        
        //haetaan tason ensimmäinen tehtävä
        Level leveli = kayttaja.getLevel();
        model.addAttribute("tehtava", leveli.getTehtavat().get(0));
        model.addAttribute("level", leveli);
        model.addAttribute("kayttaja", kayttaja);
        return "profiili";
    }
    
    @Transactional
    @RequestMapping(value = "/levelup", method = RequestMethod.GET)
    public String levelUpataan(Model model) {
        //haetan kayttajan leveli + profiilikuva
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String kayttajanNimi = auth.getName();
        Kayttaja kayttaja = kayttajaRepo.findByName(kayttajanNimi);
        
        int taso = kayttaja.getLevel().getTaso();
        int uusiTaso = taso + 1;
        Level uusiLevel = levelRepo.findByTaso(uusiTaso);
        
        kayttaja.setLevel(uusiLevel);
        model.addAttribute("level", uusiLevel);
        return "levelup";
    }
    
}
