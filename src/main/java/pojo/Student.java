package pojo;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String number;
    private String major;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "学生信息{" +
                "ID=" + id +
                ", 姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 学号='" + number + '\'' +
                ", 专业='" + major + '\'' +
                '}';
    }
}
