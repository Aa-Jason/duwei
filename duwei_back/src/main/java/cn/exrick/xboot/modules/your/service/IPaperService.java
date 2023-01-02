package cn.exrick.xboot.modules.your.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.exrick.xboot.modules.your.entity.Paper;

import java.util.List;

/**
 * 论文数据接口
 * @author xqp
 */
public interface IPaperService extends IService<Paper> {
    List<Paper> getById(int id);
}