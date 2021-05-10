package com.tawseel.clients_server.db_classes;

import javax.persistence.*;

@Entity
@Table(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "choice_str")
    private String choiceStr;

    public Choice(String choiceStr) {
        this.choiceStr = choiceStr;
    }

    public Choice() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoiceStr() {
        return choiceStr;
    }

    public void setChoiceStr(String choiceStr) {
        this.choiceStr = choiceStr;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", choiceStr='" + choiceStr + '\'' +
                '}';
    }
}
