
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.KayttajaRepository;

@Controller
public class LeaderboardController {
    
    @Autowired
    private KayttajaRepository kayttisRepo;
    
    @RequestMapping(value ="/leaderboard", method = RequestMethod.GET)
    public String naytetaanLeaderboard(Model model) {
        model.addAttribute("kayttajat", kayttisRepo.findAll());
        return 
    }
}
