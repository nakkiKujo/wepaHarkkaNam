

package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import wad.service.UUIDPersistable;

@Entity
public class Tehtava extends UUIDPersistable {
    private String kysymys;
    private int vastaus;
    
    @OneToOne
    private Tehtava next;

    public String getKysymys() {
        return kysymys;
    }

    public int getVastaus() {
        return vastaus;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public void setVastaus(int vastaus) {
        this.vastaus = vastaus;
    }
    
    public void setNext(Tehtava tt) {
        this.next = tt;
    }

    public Tehtava getNext() {
        return next;
    }
    
    public String getLyhennys() {
        if(kysymys.length() > 15) {
            return "" + kysymys.substring(0, 15) + "...";
        }
        
        return kysymys;
    }
    
    
}
