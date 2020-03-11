package java2_hw3;

public class Person {
    private String name;
    private String phone;
    private String eMail;

    public Person(String name, String phone, String eMail) {
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String getEmail() {
        return eMail;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
