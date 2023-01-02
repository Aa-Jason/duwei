package cn.exrick.xboot.modules.your.serviceimpl;

import cn.exrick.xboot.modules.your.mapper.PaperMapper;
import cn.exrick.xboot.modules.your.entity.Paper;
import cn.exrick.xboot.modules.your.service.IPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 论文数据接口实现
 * @author xqp
 */
@Slf4j
@Service
@Transactional
public class IPaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements IPaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<Paper> getById(int id) {
        List<Paper> list = paperMapper.getById(id);
        return list;
    }
}