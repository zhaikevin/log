package com.github.log.server.controller;

import com.github.foundation.common.model.ResultInfo;
import com.github.log.server.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/5/8 09:51
 */
@RequestMapping("/project")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultInfo list(){
        return ResultInfo.success(projectService.list());
    }
}
