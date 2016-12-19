
package wad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Kayttaja;
import wad.domain.Palaute;
import wad.domain.Tehtava;

public interface PalauteRepository extends JpaRepository<Palaute, String> {
    List<Palaute> getByPalautteenKohde(Tehtava tehtava);
}
