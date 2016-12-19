
package wad.controller;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.domain.Kayttaja;
import wad.domain.Level;
import wad.domain.Tehtava;
import wad.repository.KayttajaRepository;
import wad.repository.LevelRepository;
import wad.repository.TehtavaRepository;
import wad.service.LuoLevelitService;

@Controller
public class DefaultController {
    
    @Autowired
    private LuoLevelitService leveliService;
    
    @Autowired 
    private KayttajaRepository kayttajaRepo;
    
    @Autowired
    private LevelRepository levelRepo;
    
    @Autowired
    private PasswordEncoder PE;
    @PostConstruct
    public void init() {
        leveliService.luoLevelit();
        Kayttaja testiKayttaja = new Kayttaja();
        testiKayttaja.setLevel(levelRepo.findByTaso(1));
        testiKayttaja.setName("testi");
        testiKayttaja.setPassword(PE.encode("testi"));
        kayttajaRepo.save(testiKayttaja);
    }
    
    @RequestMapping("*")
    public String handleDefault() {
        return "redirect:/etusivu";
    }
}
