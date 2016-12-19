
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.service.UUIDPersistable;

@Entity
public class Palaute extends UUIDPersistable{
    
    private String palaute;
    
    @ManyToOne
    private Kayttaja palautteenAntaja;
    
    @ManyToOne
    private Tehtava palautteenKohde;

    public String getPalaute() {
        return palaute;
    }

    public Kayttaja getPalautteenAntaja() {
        return palautteenAntaja;
    }

    public Tehtava getPalautteenKohde() {
        return palautteenKohde;
    }

    public void setPalaute(String palaute) {
        this.palaute = palaute;
    }

    public void setPalautteenAntaja(Kayttaja palautteenAntaja) {
        this.palautteenAntaja = palautteenAntaja;
    }

    public void setPalautteenKohde(Tehtava palautteenKohde) {
        this.palautteenKohde = palautteenKohde;
    }
    
    
}
