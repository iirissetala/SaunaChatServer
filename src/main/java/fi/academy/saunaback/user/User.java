package fi.academy.saunaback.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    /* Id muodostuu automaattisesti tietokannassa.
    * Toimii myös yhdistävänä tekijänä Message-tauluun. Toteutus myöhemmin./Iiris */
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String username;
    private String role;
    private String color;
    private Integer userheatcount;

    /*  Tyhjä konstruktori JPAta varten/Iiris */
    public User () {}

    public User (String username) {
        this.username = username;
    }

    public User (String un, String r, String c){
        this.username = un;
        this.role = r;
        this.color = c;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getUserheatcount() {
        return userheatcount;
    }

    public void setUserheatcount(Integer userheatcount) {
        this.userheatcount = userheatcount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", color='" + color + '\'' +
                ", userheatcount=" + userheatcount +
                '}';
    }
}
