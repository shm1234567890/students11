package cn.accp.domain;

import java.io.Serializable;
import java.util.Set;

public class Classes implements Serializable {
    private Integer id;
    private String name;
    private Set<Student> student;

    public Set<Student> getStudent() {
        return student;
    }

    public Classes(String name, Set<Student> student) {
        this.name = name;
        this.student = student;
    }

    public Classes(Integer id, String name, Set<Student> student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public Classes() {
    }

    public Classes(String name) {
        this.name = name;
    }

    public Classes(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
