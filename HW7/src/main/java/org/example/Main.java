package org.example;

import org.example.job.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sf = new Configuration().configure().buildSessionFactory()) {

            Long[] ids = new Long[2];

            sf.inTransaction(session -> {
                Course javaCourse = new Course("Java", "Java Course");
                Course qaCourse = new Course("QA", "Quality Assurance Course");

                Student student1 = new Student("Mykola", 20);
                Student student2 = new Student("Olena", 22);

                student1.addCourse(javaCourse);
                student1.addCourse(qaCourse);
                student2.addCourse(javaCourse);

                session.persist(student1);
                session.persist(student2);

                Department itDept = new Department("IT Department");
                Department hrDept = new Department("HR Department");
                session.persist(itDept);
                session.persist(hrDept);

                session.persist(new Employee("Stepan", 3500.0, itDept));
                session.persist(new Employee("Andriy", 4200.0, itDept));
                session.persist(new Employee("Anna", 2800.0, itDept));
                session.persist(new Employee("Tamara", 2100.0, hrDept));

                ids[0] = student1.getId();
                ids[1] = student2.getId();
            });

            sf.inSession(session -> {

                var s1 = session.get(Student.class, ids[0]);
                var s2 = session.get(Student.class, ids[1]);
                System.out.println("Student by ID: " + s1.getName() + ", " + s2.getName());

                List<Student> studentsInJava = session.createQuery(
                                "select s from Student s join s.courses c where c.name = :name",
                                Student.class)
                        .setParameter("name", "Java")
                        .list();
                System.out.println("Students in Java course:");
                studentsInJava.forEach(s -> System.out.println("  " + s.getName()));

                List<Employee> itEmployees = session.createQuery(
                                "from Employee e where e.department.name = :dept", Employee.class)
                        .setParameter("dept", "IT Department")
                        .list();
                System.out.println("IT Employees:");
                itEmployees.forEach(e -> System.out.println("  " + e.getName()));

                List<Employee> highPaid = session.createQuery(
                                "from Employee e where e.salary > :min order by e.name desc",
                                Employee.class)
                        .setParameter("min", 2500.0)
                        .list();
                System.out.println("Employees with salary > 2500:");
                highPaid.forEach(e -> System.out.println(" " + e.getName() + " - " + e.getSalary()));
            });
        }
    }
}