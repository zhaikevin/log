package com.github.log.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/5/8 09:48
 */
@Data
public class ProjectInfo implements Serializable {

    private static final long serialVersionUID = -1581913346656198277L;

    /**
     * 项目编码
     */
    private String code;

    /**
     * ip列表
     */
    private List<String> ipList;
}
