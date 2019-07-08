package cn.accp.domain;
import java.io.Serializable;
public class  Student implements Serializable {
    //类中的属性写包装器，
    //类中加三个构造器：无参数，带所有属性的，去掉主键的
    //getter/setter
    //实现序列化接口
    //加toString()
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Role role;
    private String telephone;
    private String email;
    //外建要写成对应的实体
    private Classes classes;


    public Student() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Student(String name, Integer age, String gender, String telephone, String email, Classes classes) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.classes = classes;
    }


    public Student(Integer id, String name, Integer age, String gender, String telephone, String email, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.classes = classes;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", classes=" + classes +
                '}';
    }
}
