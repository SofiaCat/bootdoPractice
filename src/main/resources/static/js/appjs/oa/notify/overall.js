
var prefix = "/oa/notify"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/lists", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},

                        columns: [
                            [
                                {
                                    title: "",
                                    halign: "center",
                                    align: "center",
                                    valign: "middle",
                                    rowspan: 1,
                                    colspan: 2
                                },
                                {
                                    title: "资源",
                                    halign: "center",
                                    align: "center",
                                    rowspan: 1,
                                    colspan: 3
                                },
                                {
                                    title: "讲师上线率",
                                    halign: "center",
                                    align: "center",
                                    rowspan: 1,
                                    colspan: 3
                                },
                                {
                                    title: "讲师人均教学时长",
                                    halign: "center",
                                    align: "center",
                                    rowspan: 1,
                                    colspan: 3
                                },
                                {
                                    title: "学生上线率",
                                    halign: "center",
                                    align: "center",
                                    rowspan: 1,
                                    colspan: 3
                                },
                                {
                                    title: "学生人均在线学习时长",
                                    halign: "center",
                                    align: "center",
                                    rowspan: 1,
                                    colspan: 3
                                }
                            ],
                            [
                                {
                                    field: 'depName',
                                    title: '项目部'
                                },
                                {
                                    field: 'term',
                                    title: '学期'
                                },
                                {
                                    field: 'onlineCourseNumber',
                                    title: '平台开课数量'
                                },
                                {
                                    field: 'offlineCourseNumber',
                                    title: '实际开课数量'
                                },
                                {
                                    field: 'rate',
                                    title: '平台建课率'
                                },
                                {
                                    field: 'stuTeacherNumber',
                                    title: '平台有使用时长的讲师人数'
                                },
                                {
                                    field: 'yugTeacherNumber',
                                    title: '线下讲师人数'
                                },
                                {
                                    field: 'teacherRate',
                                    title: '讲师上线率'
                                },
                                {
                                    field: 'teacherLearnTime',
                                    title: '讲师使用优学平台时长'
                                },
                                {
                                    field: 'teacherLoginNumber',
                                    title: '登陆平台讲师人数'
                                },
                                {
                                    field: 'perCapitaLength',
                                    title: '人均教学时长'
                                },
                                {
                                    field: 'stuStudentLearnNumber',
                                    title: '平台有在线学习时长的学生人数'
                                },
                                {
                                    field: 'yugStudentNumber',
                                    title: '线下学生人数'
                                },
                                {
                                    field: 'studentRate',
                                    title: '学生上线率'
                                },
                                {
                                    field: 'stuStudentUseNumber',
                                    title: '学生使用优学平台时长'
                                },
                                {
                                    field: 'stuHaveLearnNumber',
                                    title: '平台有在线学习时长的学生人数'
                                },
                                {
                                    field: 'stuStudentRate',
                                    title: '人均在线学习时长'


                                }]
                        ]
                    });
}
