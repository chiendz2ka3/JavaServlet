package Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Employee", schema = "dbo", catalog = "thuchanh")
public class EmployeeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "FullName")
    private String fullName;
    @Basic
    @Column(name = "Birthday")
    private Date birthday;
    @Basic
    @Column(name = "Addres")
    private String addres;
    @Basic
    @Column(name = "Positon")
    private String positon;

    public EmployeeEntity(String fullName, Date birthday, String addres, String positon) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.addres = addres;
        this.positon = positon;
    }

    public EmployeeEntity() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (addres != null ? !addres.equals(that.addres) : that.addres != null) return false;
        if (positon != null ? !positon.equals(that.positon) : that.positon != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", addres='" + addres + '\'' +
                ", positon='" + positon + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (addres != null ? addres.hashCode() : 0);
        result = 31 * result + (positon != null ? positon.hashCode() : 0);
        return result;
    }
}
