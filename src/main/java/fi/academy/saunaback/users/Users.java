package fi.academy.saunaback.users;

import fi.academy.saunaback.messages.Messages;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    /* Id muodostuu automaattisesti tietokannassa.
     * Toimii myös yhdistävänä tekijänä Messages-tauluun. Toteutus myöhemmin./Iiris */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String usersname;
//    private String userRole;
//    private String color;
    private Integer uHeatcount = 0;
//    @OneToMany(targetEntity = Messages.class, mappedBy = "id")
//    private List<Messages> messages;

    public Users() {
    }

    public Users(@NotNull String usersname) {
        this.usersname = usersname;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public Integer getuHeatcount() {
        return uHeatcount;
    }

    public void setuHeatcount(Integer uHeatcount) {
        this.uHeatcount = uHeatcount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Users{");
        sb.append("id=").append(id);
        sb.append(", usersname='").append(usersname).append('\'');
        sb.append(", uHeatcount=").append(uHeatcount);
        sb.append('}');
        return sb.toString();
    }
}