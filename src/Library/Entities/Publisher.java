package Library.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String name;
    private Boolean active = true;

    public Publisher() {
    }

    public Publisher(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    public Publisher(Integer ID, String name, Boolean active) {
        this.ID = ID;
        this.name = name;
        this.active = active;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
