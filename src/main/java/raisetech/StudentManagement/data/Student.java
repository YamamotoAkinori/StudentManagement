package raisetech.StudentManagement.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "受講生")
@Getter
@Setter
public class Student {

  @Pattern(regexp = "^\\d+$", message = "数字のみ入力するようにしてください。")
  private String id;

  @NotBlank
  private String name;

  @NotBlank
  private String kanaName;

  @NotBlank
  private String nickname;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String area;

  private int age;

  @NotBlank
  private String sex;

  private String remark;
  private boolean isDeleted;


  public Student(String name, String kanaName, String nickname,
                 String email, String area, int age, String sex,
                 String remark, boolean isDeleted) {
    this.name = name;
    this.kanaName = kanaName;
    this.nickname = nickname;
    this.email = email;
    this.area = area;
    this.age = age;
    this.sex = sex;
    this.remark = remark;
    this.isDeleted = isDeleted;
  }
  public Student() {
  }
}
