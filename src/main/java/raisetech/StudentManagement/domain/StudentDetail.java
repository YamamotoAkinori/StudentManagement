package raisetech.StudentManagement.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.javassist.bytecode.ClassFile;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import java.util.List;

@Getter
@Setter
public class StudentDetail {

  public static ClassFile model;
  private Student student;
  private List<StudentsCourses> studentsCourses;

}
