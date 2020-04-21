package com.github.log.server.repository;

import com.github.foundation.es.AbstractElasticsearchRepository;
import com.github.foundation.es.core.ElasticsearchOperations;
import com.github.log.server.model.vo.Log;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2019/11/12 14:05
 */
@Repository
public class LogRepository extends AbstractElasticsearchRepository<Log, String> {
    public LogRepository(ElasticsearchOperations elasticsearchOperations) {
        super(elasticsearchOperations);
    }
}
