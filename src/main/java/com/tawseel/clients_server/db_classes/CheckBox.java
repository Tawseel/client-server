package com.tawseel.clients_server.db_classes;

import javax.persistence.*;

@Entity
@Table(name = "check_box")
public class CheckBox implements CustomizedComponent{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_checked")
    private boolean isChecked;

    public CheckBox(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public CheckBox() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "CheckBox{" +
                "id=" + id +
                ", isChecked=" + isChecked +
                '}';
    }
}
