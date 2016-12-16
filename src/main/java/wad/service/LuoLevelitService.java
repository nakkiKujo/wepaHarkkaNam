package wad.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Level;
import wad.domain.Tehtava;
import wad.repository.LevelRepository;
import wad.repository.TehtavaRepository;

@Service
public class LuoLevelitService {

    @Autowired
    private LevelRepository levelRepo;

    @Autowired
    private TehtavaRepository tehtavaRepo;

    public void luoLevelit() {
        Tehtava teht11 = new Tehtava();
        teht11.setKysymys("1 + 1 = ?");
        teht11.setVastaus(2);

        Tehtava teht12 = new Tehtava();
        teht12.setKysymys("5 + 2 = ?");
        teht12.setVastaus(7);

        Tehtava teht13 = new Tehtava();
        teht13.setKysymys("13 - 6 = ?");
        teht13.setVastaus(7);

        teht11.setNext(teht12);
        teht12.setNext(teht13);

        tehtavaRepo.save(teht13);
        tehtavaRepo.save(teht12);
        tehtavaRepo.save(teht11);

        Level level1 = new Level();
        level1.addTehtava(teht11);
        level1.addTehtava(teht12);
        level1.addTehtava(teht13);
        level1.setTaso(1);
        level1.setImage("https://upload.wikimedia.org/wikipedia/commons/b/b8/Kiwi_(Actinidia_chinensis)_1_Luc_Viatour.jpg");

        levelRepo.save(level1);

        Tehtava teht21 = new Tehtava();
        teht21.setKysymys("3 * 3 = ?");
        teht21.setVastaus(9);

        Tehtava teht22 = new Tehtava();
        teht22.setKysymys("6 / 2 = ?");
        teht22.setVastaus(3);

        Tehtava teht23 = new Tehtava();
        teht23.setKysymys("1 + 2 * 2 = ?");
        teht23.setVastaus(5);

        teht21.setNext(teht22);
        teht22.setNext(teht23);

        tehtavaRepo.save(teht23);
        tehtavaRepo.save(teht22);
        tehtavaRepo.save(teht21);

        Level level2 = new Level();
        level2.addTehtava(teht21);
        level2.addTehtava(teht22);
        level2.addTehtava(teht23);
        level2.setTaso(2);
        level2.setImage("https://upload.wikimedia.org/wikipedia/commons/3/3e/Einstein_1921_by_F_Schmutzer_-_restoration.jpg");

        levelRepo.save(level2);

        Tehtava teht31 = new Tehtava();
        teht31.setKysymys("Kuusi pollevaa poikaa haluaa ostaa jäätelöä." +
                " Yksi jäätelö maksaa 3,5e. Kuinka paljon poikien jäätelöt maksavat?");
        teht31.setVastaus(21);

        Tehtava teht32 = new Tehtava();
        teht32.setKysymys("(3 + 5) * 2 + 4 / 2 = ?");
        teht32.setVastaus(18);

        Tehtava teht33 = new Tehtava();
        teht33.setKysymys("Kolmiossa kulmien summa on 180 astetta. Yhden kulman suuruus on 19 astetta ja toisen 25 astetta."
                + "Kuinka suuri on kolmas kulma?");
        teht33.setVastaus(136);

        teht31.setNext(teht32);
        teht32.setNext(teht33);

        tehtavaRepo.save(teht33);
        tehtavaRepo.save(teht32);
        tehtavaRepo.save(teht31);

        Level level3 = new Level();
        level3.addTehtava(teht31);
        level3.addTehtava(teht32);
        level3.addTehtava(teht33);
        level3.setTaso(3);
        level3.setImage("https://c2.staticflickr.com/4/3174/2635503092_e418351b43.jpg");

        levelRepo.save(level3);

        Tehtava teht41 = new Tehtava();
        teht41.setKysymys("(6 * 6 * 6 / 4 ) / 2 = ?");
        teht41.setVastaus(27);

        Tehtava teht42 = new Tehtava();
        teht42.setKysymys("Sinulla on kaksi noppaa. Odotusarvoisesti, jotta heittäisit lukuarvon 12"
                + ", monestiko sinun tulee heittää noppia?");
        teht42.setVastaus(36);

        Tehtava teht43 = new Tehtava();
        teht43.setKysymys("Mikä on elämän tarkoitus?");
        teht43.setVastaus(42);

        teht41.setNext(teht42);
        teht42.setNext(teht43);

        tehtavaRepo.save(teht43);
        tehtavaRepo.save(teht42);
        tehtavaRepo.save(teht41);

        Level level4 = new Level();
        level4.addTehtava(teht41);
        level4.addTehtava(teht42);
        level4.addTehtava(teht43);
        level4.setTaso(4);
        level4.setImage("https://upload.wikimedia.org/wikipedia/commons/f/f5/Urho_Kaleva_Kekkonen.jpg");

        levelRepo.save(level4);

    }
}
