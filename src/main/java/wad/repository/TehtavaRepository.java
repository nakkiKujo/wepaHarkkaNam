
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Tehtava;

public interface TehtavaRepository extends JpaRepository<Tehtava, String>  {
    
}
