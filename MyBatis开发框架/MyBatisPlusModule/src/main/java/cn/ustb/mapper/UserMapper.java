package cn.ustb.mapper;

import cn.ustb.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

// 在对应的Mapper上面继承基本接口BaseMapper
@Repository // 表示Dao层
public interface UserMapper extends BaseMapper<User> {
    // 所有的CRUD已经编写完成
    // 不需要像之前一样配置一大堆文件了

}
