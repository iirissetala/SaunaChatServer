package fi.academy.saunaback.message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Message {
    //poista tämä

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String text;
    private Long userId;
    private Integer mHeatcount;

    public Message() {}

    public Message(@NotNull String text) {
        this.text = text;
        this.mHeatcount = 0;
    }

    public Integer getmHeatcount() {
        return mHeatcount;
    }

    public void setmHeatcount(Integer mHeatcount) {
        this.mHeatcount = mHeatcount;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
