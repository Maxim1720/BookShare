package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "userMsgSeqPK", sequenceName = "userMsgSeqPK")
@Entity
@Table(name = "UserMsg")
public class UserMsg {

    @Id
    @GeneratedValue(generator = "userMsgSeqPK")
    @Column(name = "idUserMsg", nullable = false)
    private int idUserMsg;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "createAt", nullable = false)
    private Date createAt;

    @Column(name = "text", nullable = false, length = 250)
    private String text;

    @Column(name = "notes", length = 150)
    private String notes;

    @ManyToOne(targetEntity = Status.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idStatus", referencedColumnName = "idStatus")
    private Status status;

    @Column(name = "type", nullable = false)
    private int type;


    public int getIdUserMsg() {
        return idUserMsg;
    }

    public void setIdUserMsg(int idUserMsg) {
        this.idUserMsg = idUserMsg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserMsg() {
    }
}
