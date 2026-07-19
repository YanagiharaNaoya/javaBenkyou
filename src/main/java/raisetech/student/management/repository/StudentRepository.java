package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();

  @Insert("""
      InSERT INTO students
      (id,　name,　kana_name, nickuname, email, area, age, gender)
      VALUES
      (#{id}, #{name}, #{kanaName}, #{nickuName}, 
      #{email}, #{area}, #{age}, #{gender})
      """)
  void insertStudent(Student student);
}

