package homework5;

public class Employee {
    String fullName;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee (String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName=fullName;
        this.position=position;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void getEmployeeInfo(){
        System.out.printf("ФИО: %s\nВозраст: %d\nДолжность: %s\nE-mail: %s\nТелефон: %s\nЗарплата: %,d рублей\n\n\n",fullName,age,position,email,phone,salary);
    }
}
