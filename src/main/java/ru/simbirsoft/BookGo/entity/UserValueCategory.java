package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;

@SequenceGenerator(name = "userValueCategorySeqPK", sequenceName = "userValueCategorySeqPK")
@Entity
@Table(name = "UserValueCategory")
public class UserValueCategory {

    @Id
    @GeneratedValue(generator = "userValueCategorySeqPK")
    @Column(name = "idUserValueCategory", nullable = false)
    private int idUserValueCategory;


    @ManyToOne(targetEntity = UserList.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUserList", referencedColumnName = "idUserList")
    private UserList userList;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    private Category category;

    public int getIdUserValueCategory() {
        return idUserValueCategory;
    }

    public void setIdUserValueCategory(int idUserValueCategory) {
        this.idUserValueCategory = idUserValueCategory;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserValueCategory() {
    }
}
