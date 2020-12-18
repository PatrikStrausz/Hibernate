package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mother")
public class Mother {

    @Id
    @Column(name = "mother_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "mother",
            cascade = CascadeType.ALL)
    private List<Children> childrenList;

    public Mother() {
    }

    public Mother(String fName, String lName) {
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

    public List<Children> getPhoneList() {
        return childrenList;
    }

    public void setPhoneList(List<Children> children) {
        this.childrenList = children;
    }

    public void add(Children children) {
        if (childrenList == null) {
            childrenList = new ArrayList<>();
        }

        childrenList.add(children);
        children.setMother(this);
    }

    @Override
    public String toString() {
        return "Mother{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
