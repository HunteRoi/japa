package com.japa.Japa.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Language")
public class LanguageEntity {
    @Id
    @Column
    private int language_id;
    @Column
    private String name;

    public LanguageEntity(){}

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
