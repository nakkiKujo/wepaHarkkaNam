
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;
import wad.service.UUIDPersistable;

@Entity
public class Kayttaja extends UUIDPersistable {
    
    private String name;
    private String password;
    
    @ManyToOne
    private Level level;
    
    public Kayttaja() {
    }
    public Kayttaja(Level ll) {
        this.level = ll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    
    
    
    
}
