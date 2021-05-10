package com.tawseel.clients_server.db_classes;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "multiple_choice")
public class MultipleChoice extends ArrayList<Choice> implements CustomizedComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "current_choice")
    private int currentChoice;
    @Column(name = "number_of_choices")
    private int numberOfChoices;

    public MultipleChoice(int currentChoice, int numberOfChoices) {
        this.currentChoice = currentChoice;
        this.numberOfChoices = numberOfChoices;
    }

    public MultipleChoice() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(int currentChoice) {
        this.currentChoice = currentChoice;
    }

    public int getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "id=" + id +
                ", currentChoice=" + currentChoice +
                ", numberOfChoices=" + numberOfChoices +
                '}';
    }
}
