
package wad.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @ModelAttribute("kayttaja")
    private Kayttaja getKayttaja() {
        return new Kayttaja();
    }
    
    @RequestMapping(value ="/etusivu", method = RequestMethod.GET)
    public String etusivu(Model model) {
        SecurityContextHolder.clearContext();
        return "etusivu";
    }
    
    @RequestMapping(value ="/rekisterointi", method = RequestMethod.GET)
    public String rekisterointi(@ModelAttribute Kayttaja kayttaja) {
        return "rekisterointi";
    }
    
    @RequestMapping(value = "/rekisterointi", method = RequestMethod.POST)
    public String luoUusiKayttaja(@Valid @ModelAttribute Kayttaja kayttaja, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "rekisterointi";
        }
        
        kayttaja.setLevel(levelRepo.findByTaso(1));
        
        String password = kayttaja.getPassword();
        kayttaja.setPassword(passwordEncoder.encode(password));
        kayttajaRepo.save(kayttaja);
        
        return "redirect:/etusivu";
    }
}
