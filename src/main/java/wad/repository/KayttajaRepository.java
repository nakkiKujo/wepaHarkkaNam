
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Kayttaja;

public interface KayttajaRepository extends JpaRepository<Kayttaja, String>  {
    Kayttaja findByName(String name);
}
