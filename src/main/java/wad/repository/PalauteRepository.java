
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Kayttaja;
import wad.domain.Palaute;

public interface PalauteRepository extends JpaRepository<Palaute, String> {
    
}
