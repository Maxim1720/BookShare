package ru.simbirsoft.BookGo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "categorySeqPK", sequenceName = "categorySeqPK")
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(generator = "categorySeqPK")
    @Column(name = "idCategory", nullable = false)
    private int idCategory;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idParent", referencedColumnName = "idCategory")
    private Category category;

    @Column(name = "multiSelect", columnDefinition = "boolean default false")
    private Boolean multiSelect;

    @OneToMany(targetEntity = UserValueCategory.class, mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserValueCategory> userValueCategories = new HashSet<>();

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public Set<UserValueCategory> getUserValueCategories() {
        return userValueCategories;
    }

    public void setUserValueCategories(Set<UserValueCategory> userValueCategories) {
        this.userValueCategories = userValueCategories;
    }

    public Category() {
    }
}
