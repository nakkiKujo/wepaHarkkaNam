
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Kayttaja;
import wad.domain.Level;

public interface LevelRepository extends JpaRepository<Level, String> {
    public Level findByTaso(int t);
}
