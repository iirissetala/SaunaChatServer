package fi.academy.saunaback.messages;

import fi.academy.saunaback.users.Users;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Sauna -tietokannan taulu. Pakollisia kenttiä viestin sisältö sekä käyttäjän id, joka on
 * tiedossa viestiä kirjoitettaessa. Löylymäärä asetetaan aluksi nollaksi ja sitä voidaan lisätä
 * asiattomasta viestisisällöstä. Iiris
 */

@Entity
@Table(name = "messages")
public class Messages implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String text;
    /** Viestille on annettava käyttäjän id omana muuttujanaan (se tiedetään koska käyttäjä luodaan ensin. Iiris*/
    @NotNull
    private long userid;
    private Integer mHeatcount = 0;

    // Taulujen yhdistys onnistui, mutta ei saatu ajoissa käyttäjän id:tä viestille. Toteutettiin toisin. Iiris
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "users_id")
//    @Fetch(FetchMode.JOIN)
//    private Users users;

/** Tyhjä konstruktori JPA:n käyttöön */
    public Messages() {
    }

    public Messages(@NotNull String text, @NotNull long userid) {
        this.text = text;
        this.userid = userid;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Integer getmHeatcount() {
        return mHeatcount;
    }

    public void setmHeatcount(Integer mHeatcount) {
        this.mHeatcount = mHeatcount;
    }
    public void addMessagesHeat(){
        this.mHeatcount=mHeatcount + 1;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userid=" + userid +
                ", mHeatcount=" + mHeatcount +
                '}';
    }
}

