package fi.academy.saunaback.messages;

import fi.academy.saunaback.users.Users;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "messages")
public class Messages implements Serializable {



    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String text;
    private Integer mHeatcount = 0;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "users_id")
//    @Fetch(FetchMode.JOIN)
//    private Users users;

    public Messages() {
    }

    public Messages(@NotNull String text) {
        this.text = text;

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

    public Integer getmHeatcount() {
        return mHeatcount;
    }

    public void setmHeatcount(Integer mHeatcount) {
        this.mHeatcount = mHeatcount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Messages{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", mHeatcount=").append(mHeatcount);
        sb.append('}');
        return sb.toString();
    }
}

