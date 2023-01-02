package cn.exrick.xboot.modules.your.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.exrick.xboot.modules.your.entity.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 论文数据数据处理层
 * @author xqp
 */
@Repository
public interface PaperMapper extends BaseMapper<Paper> {

    List<Paper>  getById(int id);
}