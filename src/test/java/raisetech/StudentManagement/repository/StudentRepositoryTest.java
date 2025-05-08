package raisetech.StudentManagement.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository sut;

  @Test
  void 受講生の全件検索が行えること() {
    List<Student> actual = sut.search();
    assertThat(actual.size()).isEqualTo(5);
  }

  @Test
  void 受講生IDでの検索が行えること() {
    Student actual = sut.searchStudent("1");

    assertThat(actual).isNotNull();
    assertThat(actual.getName()).isEqualTo("山田太郎"); // data.sqlで指定
  }

  @Test
  void 受講生コース情報の全件検索が行えること() {
    List<StudentCourse> actual = sut.searchStudentCourseList();
    assertThat(actual.size()).isEqualTo(5);
  }

  @Test
  void 受講生IDに紐づく受講生コース情報の検索が行えること() {
    List<StudentCourse> actual = sut.searchStudentCourse("5");

    assertThat(actual).hasSize(1);
    assertThat(actual.get(0).getCourseName()).isEqualTo("Javaコース");
  }

  @Test
  void 受講生の登録が行えること() {
    Student student = new Student();
    student.setName("江並公史");
    student.setKanaName("エナミコウジ");
    student.setNickname("エナミ");
    student.setEmail("test@example.com");
    student.setArea("奈良県");
    student.setAge(36);
    student.setSex("男性");
    student.setRemark("");
    student.setDeleted(false);

    sut.registerStudent(student);

    List<Student> actual = sut.search();

    assertThat(actual.size()).isEqualTo(6);

    assertThat(actual)
            .extracting(Student::getName)
            .contains("江並公史");
  }

  @Test
  void 受講生コース情報の登録が行えること() {
    StudentCourse studentCourse = new StudentCourse();
    studentCourse.setStudentId("1");
    studentCourse.setCourseName("Spring入門コース");

    sut.registerStudentCourse(studentCourse);

    List<StudentCourse> actual = sut.searchStudentCourse("1");
    assertThat(actual)
            .extracting(StudentCourse::getCourseName)
            .contains("Spring入門コース");
  }

  @Test
  void 受講生情報の更新が行えること() {
    Student student = sut.searchStudent("1");
    student.setName("田中一郎");

    sut.updateStudent(student);

    Student updated = sut.searchStudent("1");
    assertThat(updated.getName()).isEqualTo("田中一郎");
  }

  @Test
  void 受講生コース情報のコース名の更新が行えること() {
    List<StudentCourse> courses = sut.searchStudentCourse("1");
    StudentCourse course = courses.get(0);
    course.setCourseName("AWSコース");

    sut.updateStudentCourse(course);

    List<StudentCourse> updated = sut.searchStudentCourse("1");
    assertThat(updated.get(0).getCourseName()).isEqualTo("AWSコース");
  }
}