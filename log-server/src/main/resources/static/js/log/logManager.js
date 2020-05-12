var app = new Vue({
    el: "#app",
    data: {
        form: {
            project: '',
            ip: '',
            date: '',
            message: '',
        },
        centerDialogVisible: false,
        currentPage: 1,
        pageSize: 100,
        showMore: false,
        listLoading: false,
        tableData: [],
        projects: [],
        ips: [],
    },
    created() {
        this.getProjects()
    },
    mounted() {
        //this.fetchData();
    },
    methods: {
        getProjects() {
            var self = this;
            Vue.http.get('../../project/list',
                {
                    params:
                        {}
                }
            ).then(function (res) {
                var data = res.body;
                if (data.status === 0) {
                    self.projects = data.data
                } else {
                    self.$message.error(data.statusInfo)
                }
            }, function () {
                self.$message.error('请求数据失败,请检查网络');
            });
        },
        getIps(val) {
            var self = this
            this.projects.forEach(function (value, index, array) {
                if (value.code === val) {
                    self.ips = value.ipList
                }
            })
        },
        fetchData(clickMore) {
            this.showMore = false
            this.listLoading = true
            if (clickMore) {
                this.currentPage += 1
            } else {
                this.currentPage = 1
            }
            var self = this;
            Vue.http.get('../../log/list',
                {
                    params:
                        {
                            pageNum: self.currentPage,
                            pageSize: self.pageSize,
                            project: self.form.project,
                            date: self.formatterDate(self.form.date),
                            ip: self.form.ip,
                            message: self.form.message,
                        }
                }
            ).then(function (res) {
                self.listLoading = false
                var data = res.body;
                if (data.status === 0) {
                    var tableData = data.data.content
                    if (tableData.length >= self.pageSize) {
                        self.showMore = true
                    } else {
                        self.showMore = false
                    }
                    if (clickMore) {
                        tableData.forEach(function (value, index, array) {
                            self.tableData.push(value)
                        });
                    } else {
                        self.tableData = tableData
                    }
                } else {
                    self.$message.error(data.statusInfo)
                }
            }, function () {
                self.listLoading = false
                self.$message.error('请求数据失败,请检查网络');
            });
        },
        onQuerySubmit: function () {
            if (!this.form.project) {
                this.$message.error('请选择项目');
                return
            }
            if (!this.form.date) {
                this.$message.error('请选择日期');
                return
            }
            this.fetchData(false)
        },
        handleMore() {
            this.fetchData(true)
        },
        formatterDate(value) {
            var format = '{y}.{m}.{d}'
            var date = value
            var formatObj = {
                y: date.getFullYear(),
                m: date.getMonth() + 1,
                d: date.getDate(),
                h: date.getHours(),
                i: date.getMinutes(),
                s: date.getSeconds(),
                a: date.getDay()
            }
            var time_str = format.replace(/{(y|m|d|h|i|s|a)+}/g, function (result, key) {
                var value = formatObj[key]
                // Note: getDay() returns 0 on Sunday
                if (key === 'a') {
                    return ['日', '一', '二', '三', '四', '五', '六'][value]
                }
                if (result.length > 0 && value < 10) {
                    value = '0' + value
                }
                return value || 0
            })
            return time_str
        },
    }
});