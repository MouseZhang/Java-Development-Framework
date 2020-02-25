package cn.ustb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库的所有信息
    @GetMapping("/userList")
    public List<Map<String, Object>> getUserList() {
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/userInsert")
    public String insertUser() {
        String sql = "INSERT INTO user(name,password) VALUES('JACK','123321')";
        jdbcTemplate.update(sql);
        return "Insert OK!";
    }

    @GetMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "UPDATE user SET name=?,password=? WHERE id=" + id;
        // 封装数据
        Object[] objects = new Object[2];
        objects[0] = "TOM";
        objects[1] = "11111";
        jdbcTemplate.update(sql, objects);
        return "Update OK!";
    }

    @GetMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, id);
        return "DELETE OK!";
    }

}
