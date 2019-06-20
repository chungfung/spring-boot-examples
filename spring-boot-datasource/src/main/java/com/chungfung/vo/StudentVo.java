package com.chungfung.vo;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/20 14:16
 * @Version 1.0
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("学生vo")
public class StudentVo {

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("学生年龄")
    private Integer age;

    @ApiModelProperty("学生班级")
    private String classname;
}