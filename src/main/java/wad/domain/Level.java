
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.service.UUIDPersistable;

@Entity
public class Level extends UUIDPersistable {
    private int taso;
    
    @OneToMany
    private List<Tehtava> tehtavat = new ArrayList();
    
    public void setTaso(int taso) {
        this.taso = taso;
    }

    public int getTaso() {
        return taso;
    }
    
    public void addTehtava(Tehtava t) {
        tehtavat.add(t);
    }

    public List<Tehtava> getTehtavat() {
        return tehtavat;
    }

    public void setTehtavat(List<Tehtava> tehtavat) {
        this.tehtavat = tehtavat;
    }
    
    public String toString() {
        return "Tasolla " + taso;
    }
    
    
    
    
}
