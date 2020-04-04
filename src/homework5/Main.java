package homework5;

public class Main {
    public static void main(String[] args) {
        Employee employee= new Employee("Иванов Иван Иванович","Региональный менеджер по маркетингу","ivanov@jti.com","89030160000",185000,39);

        Employee[] employees=new Employee[5];
        employees[0]=new Employee("Петров Петр Иванович","Региональный менеджер по продажам","petrov@jti.com","89030160019",155000,46);
        employees[1]=new Employee("Иванов Иван Петрович","Дивизионный менеджер по продажам","ivanov2@jti.com","89030169000",207000,42);
        employees[2]=new Employee("Сидоров Александр Васильевич","Региональный менеджер по оптовым продажам","sidorov@jti.com","89030160870",190000,37);
        employees[3]=new Employee("Ульянов Иван Сергеевич","Руководитель группы специласитов по развитию территории","ulyanov@jti.com","89030160999",110000,30);
        employees[4]=new Employee("Седов Василий Васильевич","Специалист по развитию территории","sedov@jti.com","89030167700",85000,34);

        for (Employee e: employees) {
            if (e.getAge()>40) {
                e.getEmployeeInfo();
            }
        }
    }
}
