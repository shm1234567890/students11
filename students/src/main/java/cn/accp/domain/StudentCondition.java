package cn.accp.domain;

public class StudentCondition {
    private String name;
    private Integer minAge;
    private Integer maxAge;
    private String gender;

    public StudentCondition(String name, Integer minAge, Integer maxAge, String gender) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
