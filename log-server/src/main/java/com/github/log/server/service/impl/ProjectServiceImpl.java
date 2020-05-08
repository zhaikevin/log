package com.github.log.server.service.impl;

import com.github.foundation.common.exception.BusinessException;
import com.github.foundation.common.model.ResultInfo;
import com.github.foundation.common.utils.HttpUtils;
import com.github.foundation.common.utils.JsonUtils;
import com.github.log.server.model.ProjectInfo;
import com.github.log.server.model.vo.ProjectVO;
import com.github.log.server.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/5/8 09:56
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Value("${foundation.admin.url}")
    private String adminUrl;

    @Override
    public List<ProjectInfo> list() {
        Map<String, String> params = new HashMap<>();
        String url = adminUrl + "/project/all";
        String responseString = HttpUtils.doGetClient(url, params);
        log.info("get project response:{}", responseString);
        ResultInfo resultInfo = JsonUtils.fromJson(responseString, ResultInfo.class);
        if (resultInfo.getStatus() != 0) {
            log.error("get project failed:{}", resultInfo.getStatusInfo());
            throw new BusinessException("get project failed");
        }
        List<ProjectVO> projectVOS = JsonUtils.listFromJson(resultInfo.getData().toString(),ProjectVO.class);
        List<ProjectInfo> projectInfos = new ArrayList<>();
        for (ProjectVO projectVO : projectVOS) {
            ProjectInfo projectInfo = new ProjectInfo();
            projectInfo.setCode(projectVO.getCode());
            projectInfo.setIpList(Arrays.asList(projectVO.getIp().split(",")));
            projectInfos.add(projectInfo);
        }
        return projectInfos;
    }
}
