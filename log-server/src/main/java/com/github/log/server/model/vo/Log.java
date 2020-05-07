package com.github.log.server.model.vo;

import com.github.foundation.es.annotations.Id;
import lombok.Data;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2019/11/12 11:28
 */
@Data
public class Log {

    @Id
    private String id;

    private Fields fields;

    private String message;
}
