package com.qingge.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 青哥哥
 * @since 2022-05-23
 */
@Getter
@Setter
  @ApiModel(value = "Building对象", description = "")
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("楼栋")
      private String label;

      @ApiModelProperty("单元")
      private String value;

      @ApiModelProperty("父级id")
      private Integer pid;

      @TableField(exist = false)
      private List<Building> children;


}
