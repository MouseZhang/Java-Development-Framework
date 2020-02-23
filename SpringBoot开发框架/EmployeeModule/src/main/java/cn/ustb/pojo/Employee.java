package cn.ustb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer empno;
    private String ename;
    private String email;
    private Integer gender; // 0：女，1：男
    private Date birth;
    private Department dept;

    public Employee(Integer empno, String ename, String email, Integer gender, Department dept) {
        this.empno = empno;
        this.ename = ename;
        this.email = email;
        this.gender = gender;
        this.birth = new Date();
        this.dept = dept;
    }
}
