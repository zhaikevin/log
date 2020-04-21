package com.github.log.server.service;

import com.github.foundation.es.domain.Page;
import com.github.log.server.model.vo.Log;
import com.github.log.server.model.vo.SearchParams;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/4/20 10:17
 */
public interface LogService {

    /**
     * 分页查询
     * @param searchParams
     * @return
     */
    Page<Log> searchByPage(SearchParams searchParams);
}
