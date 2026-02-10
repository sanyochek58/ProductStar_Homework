import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        Docent docent = new Docent();

        student.setName("Jack");
        student.setAge(23);
        student.setHeight(177);
        student.describePerson();

        student.sayHi();

        student.doParty();

        docent.setName("Alex");
        docent.setAge(28);
        docent.setHeight(185);
        docent.describePerson();

        docent.sayHi();

        docent.goToDepartment();
    }
}