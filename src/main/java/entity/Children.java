package entity;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class Children {

    @Id
    @Column(name = "children_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @JoinColumn(name = "mother_id")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Mother mother;

    public Children() {
    }

    public Children(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Children{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
