package fi.academy.saunaback.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fi.academy.saunaback.messages.Messages;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    /* Id muodostuu automaattisesti tietokannassa.
     * Toimii myös yhdistävänä tekijänä Messages-tauluun. Toteutus myöhemmin./Iiris */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotNull
    private String usersname;
    private String usersrole;
    private String color;
    private Integer uHeatcount = 0;
    /*
        @Transient
        @JsonIgnore
        @OneToMany(targetEntity = Messages.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Messages> messages;
    */
    public Users() {
    }

    public Users(@NotNull String usersname) {
        this.usersname = usersname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public String getUsersrole() {
        return usersrole;
    }

    public void setUsersrole(String usersrole) {
        this.usersrole = usersrole;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getuHeatcount() {
        return uHeatcount;
    }

    public void setuHeatcount(Integer uHeatcount) {
        this.uHeatcount = uHeatcount;
    }

    public void addUsersHeat(){
        this.uHeatcount = uHeatcount + 1;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", usersname='" + usersname + '\'' +
                ", usersrole='" + usersrole + '\'' +
                ", color='" + color + '\'' +
                ", uHeatcount=" + uHeatcount +
                '}';
    }
}
