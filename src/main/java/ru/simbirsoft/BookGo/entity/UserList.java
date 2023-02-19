package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;

@SequenceGenerator(name = "userListSeqPK", sequenceName = "userListSeqPK")
@Entity
@Table(name = "UserList")
public class UserList {

    @Id
    @GeneratedValue(generator = "userListSeqPK")
    @Column(name = "idUserList", nullable = false)
    private int idUserList;

    @Column(name = "typeList", nullable = false)
    private int typeList;

    @Column(name = "idList", nullable = false)
    private int id;

    public int getIdUserList() {
        return idUserList;
    }

    public void setIdUserList(int idUserList) {
        this.idUserList = idUserList;
    }

    public int getTypeList() {
        return typeList;
    }

    public void setTypeList(int typeList) {
        this.typeList = typeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserList() {
    }
}
