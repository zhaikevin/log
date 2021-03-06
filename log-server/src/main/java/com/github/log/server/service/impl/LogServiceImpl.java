package com.github.log.server.service.impl;

import com.github.foundation.es.domain.Page;
import com.github.foundation.es.domain.PageRequest;
import com.github.foundation.es.domain.Pageable;
import com.github.log.server.consts.Consts;
import com.github.log.server.model.vo.Log;
import com.github.log.server.model.vo.SearchParams;
import com.github.log.server.repository.LogRepository;
import com.github.log.server.service.LogService;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/4/20 10:19
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Page<Log> searchByPage(SearchParams searchParams) {
        String timestamp = "@timestamp";
        List<SortBuilder<?>> sortList = new ArrayList<>();
        sortList.add(new FieldSortBuilder(timestamp).order(SortOrder.DESC));
        Pageable pageable = PageRequest.of(searchParams.getPage(), searchParams.getSize(),sortList);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery(Consts.PROJECT_FIELD, searchParams.getProject()));
        if (StringUtils.isNotEmpty(searchParams.getIp())) {
            queryBuilder.must(QueryBuilders.matchQuery(Consts.IP_FIELD, searchParams.getIp()));
        }
        if (StringUtils.isNotEmpty(searchParams.getMessage())) {
            queryBuilder.must(QueryBuilders.matchQuery(Consts.MESSAGE_FIELD, searchParams.getMessage()));
        }
        StringBuilder indexName = new StringBuilder(Consts.INDEX_PRE).append(searchParams.getDate()).append("-").append(searchParams.getProject());
        logRepository.setIndexName(indexName.toString());
        Page<Log> page = logRepository.search(queryBuilder, pageable);
        return page;
    }
}
