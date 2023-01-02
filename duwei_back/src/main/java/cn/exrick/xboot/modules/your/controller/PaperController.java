package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.your.entity.Paper;
import cn.exrick.xboot.modules.your.service.IPaperService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xqp
 */
@Slf4j
@RestController
@Api(tags = "论文数据管理接口")
@RequestMapping("/xboot/paper")
@Transactional
public class PaperController {

    @Autowired
    private IPaperService iPaperService;

    /**
     * 通过id获取文献所有信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "id", value = "文献id", required = true),
    })
    public Result<List<Paper>> get(@PathVariable int id) {

        List<Paper> paper = iPaperService.getById(id);
        return new ResultUtil<List<Paper>>().setData(paper);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<Paper>> getAll() {

        List<Paper> list = iPaperService.list();
        return new ResultUtil<List<Paper>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<Paper>> getByPage(PageVo page) {

        IPage<Paper> data = iPaperService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<Paper>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<Paper> saveOrUpdate(Paper paper) {

        if (iPaperService.saveOrUpdate(paper)) {
            return new ResultUtil<Paper>().setData(paper);
        }
        return new ResultUtil<Paper>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量通过id删除")
    public Result delAllByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            iPaperService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
