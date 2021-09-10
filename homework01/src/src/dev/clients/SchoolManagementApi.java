package dev.clients;

import dev.controller.StudentController;
import dev.models.*;
import dev.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SchoolManagementApi {

    public static void main(String[] args) {
        if (checkTestData() == 0) {
            saveTestData();
        }

        StudentController controller = new StudentController();
        List<Student> returnedList = controller.findAllStudents();
        for (Student student : returnedList) {
            //To String cağırılır
            System.out.println(student);
        }

        System.out.println("Yeni Öğrenci Kaydı");
        Student std4 = new Student("Berkcan Güzel", LocalDate.of(1996, Month.MAY, 11), "Istanbul/Adana", "Male");
        controller.saveStudent(std4);

        for (Student std : returnedList) {
            //To String cağırılır
            System.out.println(std);
        }
        System.exit(0);
    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student ", Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student student1 = new Student("Leylanur Akdağ", LocalDate.of(1998, Month.AUGUST, 12), "Istanbul/Sile", "Female");
        Student student2 = new Student("Merve Anık", LocalDate.of(1999, Month.JANUARY, 2), "Istanbul/Bakirköy", "Female");
        Student student3 = new Student("Anıl Yavas", LocalDate.of(1997, Month.APRIL, 17), "Istanbul/Bahcesehir", "Male");

        Course course1 = new Course("Introduction to Java", 101, 4);
        Course course2 = new Course("Object Oriented Programming", 102, 3);
        Course course3 = new Course("Database Systems", 222, 4);

        Instructor permanentInstructor1 = new PermanentInstructor("Emine Ekin", "Istanbul", "5087891122", 10000);
        Instructor permanentInstructor2 = new PermanentInstructor("Olcay Taner", "Ankara", "5893454554", 12000);
        Instructor visitingResearcher = new VisitingResearcher("İlknur Karadeniz", "Izmir", "5678908890", 400);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course1.getStudentList().add(student3);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(permanentInstructor1);
            em.persist(permanentInstructor2);
            em.persist(visitingResearcher);

            em.getTransaction().commit();

            System.out.print("All data persisted...");
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
