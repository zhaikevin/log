package com.github.log.server.controller;

import com.github.foundation.common.model.ResultInfo;
import com.github.log.server.model.vo.SearchParams;
import com.github.log.server.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/4/20 10:16
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 获取日志列表
     * @param pageNum
     * @param pageSize
     * @param project
     * @param date
     * @param ip
     * @param message
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultInfo list(@RequestParam(value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize") Integer pageSize,
                           @RequestParam(value = "project") String project,
                           @RequestParam(value = "date") String date,
                           @RequestParam(value = "ip", required = false) String ip,
                           @RequestParam(value = "message", required = false) String message) {
        SearchParams searchParams = new SearchParams.Builder().page(pageNum).size(pageSize).project(project)
                .ip(ip).message(message).build();
        return ResultInfo.success(logService.searchByPage(searchParams));
    }
}
