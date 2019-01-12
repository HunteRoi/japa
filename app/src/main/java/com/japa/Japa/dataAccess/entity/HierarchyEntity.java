package com.japa.Japa.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "Hierarchy")
public class HierarchyEntity {
    @Id
    @Column
    private Integer hierarchy_id;
    @JoinColumn(name = "main_category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity main_category;
    @JoinColumn(name = "sub_category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity sub_category;

    public HierarchyEntity(){}

    public Integer getHierarchy_id() {
        return hierarchy_id;
    }

    public void setHierarchy_id(Integer hierarchy_id) {
        this.hierarchy_id = hierarchy_id;
    }

    public CategoryEntity getMain_category() {
        return main_category;
    }

    public void setMain_category(CategoryEntity main_category) {
        this.main_category = main_category;
    }

    public CategoryEntity getSub_category() {
        return sub_category;
    }

    public void setSub_category(CategoryEntity sub_category) {
        this.sub_category = sub_category;
    }
}
