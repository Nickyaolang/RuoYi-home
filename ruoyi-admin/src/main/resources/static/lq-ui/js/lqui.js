/**
 * 通用js方法封装处理 - 扩展Jquery
 */
(function ($) {
    $.extend({
        lqui: {
            // 异步请求封装处理
            ajax: {
                submit: function (url, type, dataType, data, callback) {
                    var config = {
                        url: url,
                        type: type,
                        dataType: dataType,
                        data: data,
                        success: function (result) {
                            if (typeof callback == "function") {
                                callback(result);
                            }
                        },
                        error: function (xhr) {
                            layer.msg("网络异常");
                            console.error("请求[" + url + "]异常");
                            console.error(xhr);
                        }
                    };
                    $.ajax(config)
                },
                get: function (url, callback) {
                    $.lqui.ajax.submit(url, "get", "json", "", callback);
                },
                post: function (url, data, callback) {
                    $.lqui.ajax.submit(url, "post", "json", data, callback);
                }
            },
            form: {
                // 加载select数据
                loadSelect: function (dest, data) {
                    $(data).each(function (index, element) {
                        $("#" + dest).append('<option value="' + element.key + '">' + element.val + '</option>');
                    });
                },
                // 加载checkbox数据
                loadCheckbox: function (dest, data) {
                    $(data).each(function (index, element) {
                        $("#" + dest).append('<input type="checkbox" value="' + element.key + '" title="' + element.val + '" lay-filter="' + dest + '" lay-skin="primary">');
                    });
                },
                // 添加ZTree下拉板事件
                addZTreeDownPanelEvent: function() {
                    var tree = ".ztree", panel = ".downPanel", title = ".layui-select-title",
                        select = ".layui-form-select", selected = "layui-form-selected";

                    $(panel).on("click", title, function (e) {
                        $(select).not($(this).parents(select)).removeClass(selected);
                        $(this).parents(panel).toggleClass(selected);
                        layui.stope(e);
                    }).on("click", tree, function (e) {
                        layui.stope(e);
                    });
                },
                // 初始化ZTree下拉板
                initZTreeDownPanel: function(dest, data, callback) {
                    var setting = {
                        id: dest + "Tree",
                        data: {
                            simpleData: {enable: true}
                        },
                        callback: {onClick: zOnClick}
                    };

                    function zOnClick(event, treeId, treeNode) {
                        $("#" + dest + "Code").val(treeNode.id);
                        $("#" + dest + "Name").val(treeNode.name);
                        $("#" + dest + "Panel").toggleClass("layui-form-selected");
                        if (typeof callback == "function") {
                            callback(event, treeId, treeNode);
                        }
                    }

                    $.fn.zTree.init($("#" + setting.id), setting, data);
                },
                // 初始化ZTree下拉板(查询用code, 保存用id)
                initZTreeDownPanel2: function(dest, data, treeType, callback) {
                    var setting = {
                        id: dest + "Tree",
                        data: {
                            simpleData: {enable: true}
                        },
                        callback: {onClick: zOnClick}
                    };

                    function zOnClick(event, treeId, treeNode) {
                        if (treeType === tree_type.DATA) {
                            $("#" + dest + "Code").val(treeNode.id);
                        } else {
                            $("#" + dest + "Code").val(treeNode.oData.codeValue);
                        }
                        $("#" + dest + "Name").val(treeNode.name);
                        $("#" + dest + "Panel").toggleClass("layui-form-selected");
                        if (typeof callback == "function") {
                            callback(event, treeId, treeNode);
                        }
                    }

                    $.fn.zTree.init($("#" + setting.id), setting, data);
                },
                // 回显ZTree下拉板值
                setZTreeDownPanelVal: function(dest) {
                    var treeObj = $.fn.zTree.getZTreeObj(dest + "Tree");
                    var val = $("#" + dest + "Code").val();
                    if ($.common.isNotEmpty(val)) {
                        var treeNode = treeObj.getNodeByParam("id", val, null);
                        $("#" + dest + "Name").val(treeNode.name);
                    }
                }
            }
        }
    });
})(jQuery);

/** 弹窗状态码 */
tree_type = {
    SEARCH: 1,
    DATA: 2
};