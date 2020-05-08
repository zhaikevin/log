package com.github.log.server.service;

import com.github.log.server.model.ProjectInfo;

import java.util.List;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/5/8 09:55
 */
public interface ProjectService {

    /**
     * 获取列表
     * @return
     */
    List<ProjectInfo> list();
}
