package cn.ustb;

import cn.ustb.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class EmployeeApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection().getClass());
        System.out.println(employeeService.list());
    }

}
