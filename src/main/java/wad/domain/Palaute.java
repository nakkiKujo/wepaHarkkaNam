

package wad.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.service.UUIDPersistable;

@Entity
public class Palaute extends UUIDPersistable{
    
    private String palaute;
    
    @ManyToOne
    private Kayttaja palautteenAntaja;
    
    @ManyToOne
    @JoinColumn(name="tehtava")
    private Tehtava tehtava;

    public String getPalaute() {
        return palaute;
    }

    public Kayttaja getPalautteenAntaja() {
        return palautteenAntaja;
    }

    public Tehtava getTehtava() {
        return tehtava;
    }

    public void setPalaute(String palaute) {
        this.palaute = palaute;
    }

    public void setPalautteenAntaja(Kayttaja palautteenAntaja) {
        this.palautteenAntaja = palautteenAntaja;
    }

    public void setTehtava(Tehtava palautteenKohde) {
        this.tehtava = palautteenKohde;
    }

    @Override
    public String toString() {
        return "Nimi: " + palautteenAntaja.getName() + ", "
                + "Palaute: " + palaute;
    }
    
    
}
