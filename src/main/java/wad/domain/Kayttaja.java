
package wad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.crypto.password.PasswordEncoder;
import wad.service.UUIDPersistable;

@Entity
public class Kayttaja extends UUIDPersistable {
    @NotBlank
    @Length(min = 3, max = 20)
    
    @Column(unique=true)
    private String name;
    
    @NotBlank
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
