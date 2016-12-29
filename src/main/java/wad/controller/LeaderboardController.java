
package wad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Kayttaja;
import wad.repository.KayttajaRepository;

@Controller
public class LeaderboardController {
    
    @Autowired
    private KayttajaRepository kayttisRepo;
    
    @RequestMapping(value ="/leaderboard", method = RequestMethod.GET)
    public String naytetaanLeaderboard(Model model) {
        //haetaan 10 korkeimmalla tasolla olevaa käyttäjää
        Pageable page = new PageRequest(0, 10, Sort.Direction.ASC, "level");
        Page<Kayttaja> kayttajaPage = kayttisRepo.findAll(page);
        List<Kayttaja> kayttajaLista = kayttajaPage.getContent();
        
        model.addAttribute("kayttajat", kayttajaLista);
        return "leaderboard";
    }
}
