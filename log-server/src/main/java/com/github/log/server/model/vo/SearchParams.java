package com.github.log.server.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: kevin
 * @Date: 2020/4/20 14:30
 */
@Data
public class SearchParams implements Serializable {

    private static final long serialVersionUID = 9153385631404131860L;

    public SearchParams(Builder builder) {
        this.project = builder.project;
        this.ip = builder.ip;
        this.message = builder.message;
        this.page = builder.page;
        this.size = builder.size;
        this.date = builder.date;
    }

    /**
     * 项目
     */
    private String project;

    /**
     * ip 地址
     */
    private String ip;

    /**
     * 搜索字段
     */
    private String message;

    /**
     * 页数
     */
    private int page;

    /**
     * 大小
     */
    private int size;

    /**
     * 日期
     */
    private String date;

    @Data
    public static class Builder {

        /**
         * 项目
         */
        private String project;

        /**
         * ip 地址
         */
        private String ip;

        /**
         * 搜索字段
         */
        private String message;

        /**
         * 页数
         */
        private int page;

        /**
         * 大小
         */
        private int size;

        /**
         * 日期
         */
        private String date;

        public Builder project(String project) {
            this.project = project;
            return this;
        }

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder page(int page) {
            this.page = page;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public SearchParams build() {
            return new SearchParams(this);
        }
    }
}
