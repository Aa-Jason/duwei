package cn.exrick.xboot.modules.your.entity;

import cn.exrick.xboot.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author xqp
 */
@Data
@Accessors(chain = true)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "p_paper")
@TableName("p_paper")
@ApiModel(value = "论文数据")
public class Paper extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("摘要")
    @TableField("abstract")
    private String Abstract;

    @ApiModelProperty("关键字")
    @TableField("keyWords")
    private String keyWords;

    @ApiModelProperty("发表年份")
    @TableField("year")
    private String year;

    @ApiModelProperty("期刊")
    @TableField("journal")
    private String journal;

    @ApiModelProperty("下载链接")
    @TableField("downloadLink")
    private String downloadLink;

}