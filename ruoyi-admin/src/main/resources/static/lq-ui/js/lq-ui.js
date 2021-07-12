/**
 * 通用js方法封装处理 - 扩展Jquery
 * { jquery 插件 }
 * { layer 插件 }
 * { bootstrap-table 插件 }
 */
(function ($) {
    $.extend({
        lq: {
            // 表格封装处理
            table: {
                _option: {},
                // 初始化表格参数
                init: function(options) {
                    var defaults = {
                        id: "bootstrap_table",
                        idField: "id",
                        toolbar: "toolbar",
                        searchForm: "search_form",
                        method: "post",
                        sidePagination: "server",
                        pageSize: 10,
                        pageNumber: 1,
                        pageList: [10, 25, 50],
                        pagination: true,
                        showToggle: true,
                        showRefresh: true,
                        showColumns: true,
                        minimumCountColumns: 2,
                        showPaginationSwitch: false,
                        rowStyle: $.lq.table.rowStyle,
                        queryParams: $.lq.table.queryParams,
                        onLoadSuccess: $.lq.table.onLoadSuccess
                    };
                    var options = $.extend(defaults, options);
                    $.lq.table._option = options;
                    $('#' + options.id).bootstrapTable({
                        url: options.url,                                   // 请求后台的URL（*）
                        contentType: "application/x-www-form-urlencoded",   // 编码类型
                        method: options.method,                             // 请求方式（*）
                        idField: options.idField,                           // 指定主键列
                        toolbar: '#' + options.toolbar,                     // 指定工作栏
                        pagination: options.pagination,                     // 是否显示分页（*）
                        pageNumber: options.pageNumber,                     // 初始化加载第一页，默认第一页
                        pageSize: options.pageSize,                         // 每页的记录行数（*）
                        pageList: options.pageList,                         // 可供选择的每页的行数（*）
                        sidePagination: options.sidePagination,             // server启用服务端分页client客户端分页
                        showRefresh: options.showRefresh,                   // 是否显示刷新按钮
                        showColumns: options.showColumns,                   // 是否显示隐藏某列下拉框
                        showToggle: options.showToggle,                     // 是否显示详细视图和列表视图的切换按钮
                        minimumCountColumns: options.minimumCountColumns,   // 至少显示列数（*）
                        showPaginationSwitch: options.showPaginationSwitch, // 是否显示分页开关
                        rowStyle: options.rowStyle,                         // 通过自定义函数设置行样式
                        queryParams: options.queryParams,                   // 传递参数（*）
                        responseHandler: $.lq.table.responseHandler,        // 在加载服务器发送来的数据之前处理函数
                        onLoadSuccess: options.onLoadSuccess                // 当所有数据被加载时触发处理函数
                    });
                },
                // 查询条件
                queryParams: function(params) {
                    // 传递参数查询参数
                    var _params = {
                        pageSize:       params.limit,
                        pageNum:        params.offset / params.limit + 1,
                        searchValue:    params.search,
                        orderByColumn:  params.sort,
                        isAsc:          params.order
                    };
                    var form = $("#" + $.lq.table._option.searchForm).serializeArray();
                    $.each(form, function (i, field) {
                        _params[field.name] = field.value;
                    });
                    return _params;
                },
                // 请求获取数据后处理回调函数
                responseHandler: function (res) {
                    if ($.lq.common.isEmpty(res.type)) {
                        return res;
                    }
                    if (res.type) {
                        return res.result;
                    }
                    return {rows: [], total: 0};
                },
                // 设置行样式
                rowStyle: function (row, index) {
                    var classes = ['active', 'success', 'active', 'info', 'active', 'warning', 'active', 'danger'];
                    return {classes: classes[index % 8]}
                },
                // 列表查询
                search: function() {
                    var params = $("#" + $.lq.table._option.id).bootstrapTable('getOptions');
                    params.queryParams = function(params) {
                        return $.lq.table.queryParams(params);
                    };
                    $("#" + $.lq.table._option.id).bootstrapTable('refresh', params);
                },
                // 列表刷新
                refresh: function() {
                    $("#" + $.lq.table._option.id).bootstrapTable('refresh', {
                        silent: true
                    });
                },
                // 当所有数据被加载时触发
                onLoadSuccess: function(data) {
                    // 无任何操作
                }
            },
            //
            zTree: {

            },
            // 弹出层封装处理
            modal: {
                // 显示图标
                icon: function(type) {
                    var icon = "";
                    if (type === modal_status.WARNING) {
                        icon = 0;
                    } else if (type === modal_status.SUCCESS) {
                        icon = 1;
                    } else if (type === modal_status.FAIL) {
                        icon = 2;
                    } else {
                        icon = 3;
                    }
                    return icon;
                },
                // 弹出提示
                alert: function(content, type) {
                    layer.alert(content, {
                        icon: $.lq.modal.icon(type),
                        title: "系统提示",
                        btn: ['确认'],
                        btnclass: ['btn btn-primary'],
                    });
                },
                // 错误提示
                alertError: function(content) {
                    $.lq.modal.alert(content, modal_status.FAIL);
                },
                // 成功提示
                alertSuccess: function(content) {
                    $.lq.modal.alert(content, modal_status.SUCCESS);
                },
                // 警告提示
                alertWarning: function(content) {
                    $.lq.modal.alert(content, modal_status.WARNING);
                },
                // 确认窗体
                confirm: function (content, callBack) {
                    layer.confirm(content, {
                        icon: 3,
                        title: "系统提示",
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        callBack(true);
                    });
                },
                // 弹出层指定参数选项
                openOptions: function(options) {
                    debugger
                    if ($.lq.common.isEmpty(options.content)) {
                        $.lq.modal.alertWarning("content不能为空");
                        return;
                    }
                    var defaults = {
                        type: 2,
                        maxmin: true,
                        shade: 0.3,
                        title: '系统窗口',
                        fix: false,
                        area: ['800px', ($(window).height() - 50) + 'px'],
                        content: '',
                        shadeClose: true
                    };
                    if (options.showBtn) {
                        defaults.btn = ['<i class="fa fa-check"></i> 确认', '<i class="fa fa-close"></i> 关闭'];
                        defaults.cancel = function () { return true; }
                    }
                    var _options = $.extend(defaults, options);
                    layer.open(_options);
                },
                // 关闭窗体
                close: function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            },
            // 操作封装处理
            operate: {
                // 提交数据
                submit: function(url, type, dataType, data, callback) {
                    var config = {
                        url: url,
                        type: type,
                        dataType: dataType,
                        data: data,
                        success: function(result) {
                            if (typeof callback == "function") {
                                callback(result);
                            }
                        },
                        error: function (xhr) {
                            var msg = "网络异常";
                            if (xhr.responseJSON !== undefined) {
                                msg += (":" + xhr.responseJSON.message);
                            }
                            layer.msg(msg);
                        }
                    };
                    $.ajax(config)
                },
                // POST请求传输
                post: function(url, data, callback) {
                    $.lq.operate.submit(url, "post", "json", data, callback);
                },
                // GET请求传输
                get: function(url, callback) {
                    $.lq.operate.submit(url, "get", "json", "", callback);
                }
            },
            // 通用方法封装处理
            common: {
                // 判断字符串是否为空
                isEmpty: function (value) {
                    if (value == null || this.trim(value) == "") {
                        return true;
                    }
                    return false;
                },
                // 空格截取
                trim: function (value) {
                    if (value == null) {
                        return "";
                    }
                    return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
                }
            },
            // 其它封装处理
            other: {
                loadSelect: function(dest, data) {
                    $(data).each(function (index, element) {
                        $("#" + dest).append('<option value="' + element.id + '">' + element.listValue + '</option>');
                    });
                },
                loadCheckbox: function (dest, data) {
                    $(data).each(function (index, element) {
                        $("#" + dest).append('<input type="checkbox" value="' + element.id + '" title="' + element.listValue + '" lay-filter="' + dest + '" lay-skin="primary">');
                    });
                },
                renderSelect: function(dest, data) {
                    $(data).each(function (index, element) {
                        $("#" + dest).append('<option value="' + element.key + '">' + element.val + '</option>');
                    });
                },
                renderCheckbox: function (dest, data) {
                    $(data).each(function (index, element) {
                        $("#" + dest).append('<input type="checkbox" value="' + element.key + '" title="' + element.val + '" lay-filter="' + dest + '" lay-skin="primary">');
                    });
                },
                simpleSelect: function(dest, data){
                    $(data).each(function(index,element){
                        $("#"+dest).append('<option value="' + element.key + '">' + element.key + '</option>')
                    })
                }
            }
        }
    });
})(jQuery);

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};