
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kayttaja;
import wad.repository.KayttajaRepository;
import wad.repository.LevelRepository;

@Controller
public class KirjautumisController {
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    
    @Autowired
    private LevelRepository levelRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @RequestMapping(value ="/etusivu", method = RequestMethod.GET)
    public String etusivu(Model model) {
        SecurityContextHolder.clearContext();
        return "etusivu";
    }
    
    @RequestMapping(value ="/rekisterointi", method = RequestMethod.GET)
    public String rekisterointi() {
        return "rekisterointi";
    }
    
    @RequestMapping(value = "/rekisterointi", method = RequestMethod.POST)
    public String luoUusiKayttaja(@RequestParam String kayttajatunnus, @RequestParam String salasana) {
        Kayttaja uusi = new Kayttaja();
        uusi.setName(kayttajatunnus);
        uusi.setPassword(passwordEncoder.encode(salasana));
        uusi.setLevel(levelRepo.findByTaso(1));
        
        kayttajaRepo.save(uusi);
        
        return "redirect:/etusivu";
    }
}
