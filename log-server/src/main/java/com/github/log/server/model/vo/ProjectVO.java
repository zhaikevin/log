package com.github.log.server.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/2/11 12:19
 */
@Data
public class ProjectVO implements Serializable {

    private static final long serialVersionUID = -3595915324254360772L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 项目名字
     */
    private String name;

    /**
     * 项目编码
     */
    private String code;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 备注
     */
    private String remark;
}
