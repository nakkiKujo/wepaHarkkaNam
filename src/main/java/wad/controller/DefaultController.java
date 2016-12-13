
package wad.controller;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.domain.Kayttaja;
import wad.domain.Level;
import wad.domain.Tehtava;
import wad.repository.KayttajaRepository;
import wad.repository.LevelRepository;
import wad.repository.TehtavaRepository;

@Controller
public class DefaultController {

    @Autowired
    private KayttajaRepository kayttajaRepo;
    
    @Autowired
    private TehtavaRepository tehtavaRepo;
    
    @Autowired
    private LevelRepository levelRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Transactional
    @PostConstruct
    public void init() {
        Tehtava teht1 = new Tehtava();
        teht1.setKysymys("Montako omenaa on puussa?");
        teht1.setVastaus(0);
        
        
        Tehtava teht2 = new Tehtava();
        teht2.setKysymys("Paljonko on 1/0?");
        teht2.setVastaus(101010);
        
        tehtavaRepo.save(teht1);
        tehtavaRepo.save(teht2);
        
        teht1.setNext(teht2);
        tehtavaRepo.save(teht1);
        
        Tehtava teht3 = new Tehtava();
        teht3.setKysymys("Miten kaunis Viljami on asteikolla 1-10?");
        teht3.setVastaus(11);
        tehtavaRepo.save(teht3);
        
        teht2.setNext(teht3);
        tehtavaRepo.save(teht2);
        
        Level leveli = new Level();
        leveli.addTehtava(teht1);
        leveli.addTehtava(teht2);
        leveli.addTehtava(teht3);
        
        leveli.setTaso(1);
        leveli.setImage("https://upload.wikimedia.org/wikipedia/commons/3/3e/Einstein_1921_by_F_Schmutzer_-_restoration.jpg");
        
        Level leveli2 = new Level();
        Tehtava teht4 = new Tehtava();
        teht4.setKysymys("Onko nami?");
        teht4.setVastaus(666);
        tehtavaRepo.save(teht4);
        leveli2.addTehtava(teht4);
        
        leveli2.setTaso(2);
        leveli2.setImage("https://upload.wikimedia.org/wikipedia/commons/3/3e/Einstein_1921_by_F_Schmutzer_-_restoration.jpg");
        
        levelRepo.save(leveli);
        levelRepo.save(leveli2);
        
        Kayttaja kalle = new Kayttaja(leveli);
        kalle.setName("Kalle");
        kalle.setPassword(passwordEncoder.encode("joonas"));
        kayttajaRepo.save(kalle);
    }
    
    @RequestMapping("*")
    public String handleDefault() {
        return "redirect:/epeli";
    }
}
