package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
      INSERT INTO students
      (name, kana_name, nickname, email, area, age, gender, remark, is_deleted)
      VALUES
      (#{name}, #{kanaName}, #{nickName}, 
      #{email}, #{area}, #{age}, #{gender}, #{remark}, #{isDeleted})
      """)
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertStudent(Student student);

  @Insert("""
      INSERT INTO students_courses
      (student_id, course_name, start_date, end_date)
      VALUES
      (#{studentId}, #{courseName}, #{startDate}, #{endDate})
      """)
  void registerStudentCourse(StudentsCourses studentsCourse);
}

