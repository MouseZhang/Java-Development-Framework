package cn.ustb.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /*
        配置自增ID：
        1、实体类字段上@TableId(type = IdType.AUTO)
        2、数据库表字段设置为自增
        AUTO(0), // 数据库ID自增
        NONE(1), // 未设置主键
        INPUT(2), // 手动输入
        ID_WORKER(3), // 全局唯一ID(默认)
        UUID(4), // 全局唯一ID
        ID_WORKER_STR(5); // ID_WORKER的字符串表示法
     */
    @TableId(type = IdType.AUTO) // 默认使用ID_WORKER全局唯一ID
    private Long id; // 主键策略（UUID、自增ID、雪花算法、redis、zookeeper）
    private String name;
    private Integer age;
    private String email;
    @Version // 乐观锁
    private Integer version;
    // 使用代码级别（时间），需要用注解配合
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;
    @TableLogic // 逻辑删除
    private Integer deleted;
}
