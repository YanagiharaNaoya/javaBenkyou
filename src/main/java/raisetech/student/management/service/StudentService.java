package raisetech.student.management.service;

import raisetech.student.management.data.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<StudentsCourses> searchStudentsCourseList() {
    return repository.searchStudentsCourses();
  }

  @Transactional
  public void registerStudent(StudentDetail studentDetail) {

    Student student = studentDetail.getStudent();

    repository.insertStudent(student);

    List<StudentsCourses> courses = studentDetail.getStudentsCourses();

    if (courses != null && !courses.isEmpty()) {
      StudentsCourses course = courses.get(0);
      course.setStudentId(student.getId());

      repository.registerStudentCourse(course);
    }
  }
}
