package dev.service;

import dev.models.Student;
import dev.repository.CrudRepository;
import dev.repository.StudentRepository;
import dev.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {
        em.clear();
    }

    public void deleteStudentFromDatabase(int id) {
        em.getTransaction().begin();
        Student student = em.createQuery("FROM Student WHERE Student =:id", Student.class).setParameter("id", id).getSingleResult();
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Student object) {

    }
}
