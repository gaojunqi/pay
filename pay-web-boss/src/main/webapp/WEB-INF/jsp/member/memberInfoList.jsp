<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/page/inc/taglib.jsp"%>
<html>
<head>

	<title>短信查询</title>
	<%@ include file="/WEB-INF/jsp/inc/easyui.jsp"%>
	<link href="${ctx}/statics/button.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript">
		/*
		 *短信查询
		 */
		function searchSmslog(){
			var url = "/member/list.json";

			$('#dg').datagrid({
				url:url,
				queryParams:{
					startDate:$("#beginTime").datebox('getValue'),
					endDate:$("#endTime").datebox('getValue')
				}
			});
		}

		function setStatus(val,row) {
			var status = "";
			if(val == "0") {
				status = "发送中";
			}

			if(val == "1") {
				status = "发送暂缓";
			}

			if(val == "2") {
				status = "发送失败";
			}

			if(val == "3") {
				status = "接收成功";
			}
			return status;
		}

		Date.prototype.Format = function (fmt) { //author: meizz
			var o = {
				"M+": this.getMonth() + 1, //月份
				"d+": this.getDate(), //日
				"h+": this.getHours(), //小时
				"m+": this.getMinutes(), //分
				"s+": this.getSeconds(), //秒
				"q+": Math.floor((this.getMonth() + 3) / 3), //季度
				"S": this.getMilliseconds() //毫秒
			};
			if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			for (var k in o)
				if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			return fmt;
		}

		$(function(){
			var today=new Date(); // 获取今天时间
			today.setDate(today.getDate() + 1); // 系统会自动转换

			$("#beginTime").datebox('setValue',new Date().Format("yyyy-MM-dd"));
			$("#endTime").datebox('setValue',today.Format("yyyy-MM-dd"));
		});
	</script>

</head>

<body>
<table id="dg"  class="easyui-datagrid" style="width:100%;height:100%"
	   fitColumns="true" rownumbers="true" fit="true" pagination="true" toolbar="#tb" >
	<thead>
	<tr>
		<th data-options="field:'id'">序号</th>
		<th data-options="field:'memberNo'">会员编号</th>
		<th data-options="field:'realName'">真实姓名</th>
		<th data-options="field:'cardNo'">身份证号</th>
		<th data-options="field:'createTime'">注册时间</th>
		<th data-options="field:'status'">状态</th>
		<th data-options="field:'siteName'">操作</th>
	</tr>
	</thead>
</table>

<div style="padding:5px;" id="tb" >
	<form id="search" method="post" >
		手机号码:<input type="text" id="phoneNum">起始时间:<input type="text" class="easyui-datebox" name="startDate" id="beginTime" size="22" editable="false" />
		&nbsp;截止时间:<input type="text" class="easyui-datebox" name="endDate" id="endTime" size="22" editable="false" />
		&nbsp;<a href="javascript:searchSmslog()" class="button" >查询 </a>
	</form>
</div>

</body>
</html>


<script>
function selectDateMemberList(str, obj) {
    var now = new Date(); //获取当前时间
    var year = now.getFullYear(); //获取当前日期的年份部分
    var month = now.getMonth() + 1 +""; //获取当前日期的月份部分
    var day = now.getDate() +""; //获取当前日期的天数部分
    if(day.length==1){
    	day="0"+day;
    }
    //获取当前月份包含的天数
    var nowdays = new Date(year, month, 0).getDate();
    var lastMonth = month - 1+"";
    var lastMonthdays = new Date(year, lastMonth, 0).getDate() +"";
    if(month.length==1){
    	month="0"+month;
    }
    if(lastMonth.length==1){
    	lastMonth="0"+lastMonth;
    }
    if(lastMonthdays.length==1){
    	lastMonthdays="0"+lastMonthdays;
    }
    var startTime = "";
    var endTime = "";
    switch (str) {
        case "toDay":
        	startTime = year + "-" + month + "-" + day;
        	endTime = year + "-" + month + "-" + day;
            break;
        case "lastMonth":
            if (lastMonth == 0) { lastMonth = 12; year = year - 1; }
            startTime = year + "-" + lastMonth + "-01";
            endTime = year + "-" + lastMonth + "-" + lastMonthdays;
            break;
        case "currentMonth":
            startTime = year + "-" + month + "-01";
            //endTime = year + "-" + month + "-" + day;
            endTime = year + "-" + month + "-" + nowdays;
            break;
        case "lastYear":
            startTime = (year - 1) + "-01-01";
            endTime = (year - 1) + "-12-31";
            break;
        case "currentYear":
            startTime = year + "-01-01";
            endTime = year + "-12-31";
            break;
    }
    $("#beginDateMemberList").val(startTime);
    $("#endDateMemberList").val(endTime);

}

// 清空表单
function clearFormMemberList(){
	$(':input',"form[action='memberInfo_listMemberInfo.action']")
	 .not(':button, :submit, :reset, :hidden')  
	 .val('')  
	 .removeAttr('checked')  
	 .removeAttr('selected');  
}

</script>