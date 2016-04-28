<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>${COMPANY_FOR}</title>
	<%@ include file="/WEB-INF/jsp/inc/easyui.jsp"%>
	<script type="text/javascript" src="${ctx }/statics/plugins/artTemplate/dist/template.js"></script>

	<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
	<script src="${ctx}/statics/plugins/easyui/common/index.js" type="text/javascript"></script>
	<link href="${ctx}/statics/plugins/easyui/common/index.css" rel="stylesheet" />
	<script src="${ctx}/statics/plugins/easyui/common/index-startup.js"></script>

	<link href="${ctx}/statics/plugins/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
	<script src="${ctx}/statics/plugins/ztree/js/jquery.ztree.core-3.5.min.js"></script>
</head>
<body>
<!-- 容器遮罩 -->
<div id="maskContainer">
	<div class="datagrid-mask" style="display: block;"></div>
	<div class="datagrid-mask-msg" style="display: block; left: 50%; margin-left: -52.5px;">
		正在加载...
	</div>
</div>
<div id="mainLayout" class="easyui-layout hidden" data-options="fit: true">
	<div id="northPanel" data-options="region: 'north', border: false" style="height: 80px; overflow: hidden;">
		<div id="topbar" class="top-bar">
			<div class="top-bar-left">
				<h1 style="margin-left: 10px; margin-top: 10px;color: #fff">龙猫<span style="color: #3F4752">--支付运营平台</span></h1>
			</div>
			<div class="top-bar-right">
				<div id="timerSpan"></div>
				<div id="themeSpan">
					<a id="btnHideNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-up'"></a>
				</div>
			</div>
		</div>
		<div id="toolbar" class="panel-header panel-header-noborder top-toolbar">
			<div id="infobar">
                    <span class="icon-hamburg-user" style="padding-left: 25px; background-position: left center;">
                       ${realName },您好 &nbsp;<fmt:formatDate value="${lastLoginTime}" pattern="YYYY-MM-dd HH:mm:ss"/>
                    </span>
			</div>

			<div id="buttonbar">
				<span>更换皮肤：</span>
				<select id="themeSelector"></select>
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_set'" iconCls="icon-standard-cog">系统</a>
				<div id="layout_north_set">
					<div id="btnFullScreen" data-options="iconCls:'key'">全屏切换</div>
					<div id="btnExit" data-options="iconCls:'logout'">退出系统</div>
				</div>
				<a id="btnShowNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-down'" style="display: none;"></a>
			</div>
		</div>
	</div>

	<div data-options="region: 'west', title: '', iconCls: 'icon-standard-map', split: true, minWidth: 200, maxWidth: 400" style="width: 220px; padding: 1px;">
		<div id="myMenu" class="easyui-accordion" data-options="fit:true,border:false" height="100%">
<%--			<script id="menu" type="text/html">
				{{each data as p_permission}}
				{{if (p_permission.pid==null)}}
				<div title="{{p_permission.name }}" style="padding: 5px;" data-options="border:false,iconCls:'{{p_permission.icon }}'">
					<div>
						{{each data as c_permission}}
						{{if (c_permission.pid==p_permission.id)}}
						<a id="btn" class="easyui-linkbutton" data-options="plain:true,iconCls:'{{c_permission.icon }}'" style="width:98%;margin-bottom:5px;" onclick="window.mainpage.mainTabs.addModule('{{c_permission.name}}','{{c_permission.url }}','{{c_permission.icon }}')">{{c_permission.name}}</a>
						{{/if}}
						{{/each}}
					</div>
				</div>
				{{/if}}
				{{/each}}
			</script>--%>
	<%--<a id="btn" class="easyui-linkbutton l-btn l-btn-small l-btn-plain" data-options="plain:true,iconCls:'icon-hamburg-product'" style="width:98%;margin-bottom:5px;" onclick="window.mainpage.mainTabs.addModule('商品管理','http://www.baidu.com','icon-hamburg-product')" group=""><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">商品管理</span><span class="l-btn-icon icon-hamburg-product">&nbsp;</span></span></a>
	<a id="btn" class="easyui-linkbutton l-btn l-btn-small l-btn-plain" data-options="plain:true,iconCls:'icon-hamburg-product1'" style="width:98%;margin-bottom:5px;" onclick="window.mainpage.mainTabs.addModule('商品管理1111','http://www.baidu.com','icon-hamburg-product1')" group=""><span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">商品管理</span><span class="l-btn-icon icon-hamburg-product">&nbsp;</span></span></a>
--%>		<div id="tree" class="ztree"></div>
		</div>
	</div>

	<div data-options="region: 'center'">
		<div id="mainTabs_tools" class="tabs-tool">
			<table>
				<tr>
					<td><a id="mainTabs_jumpHome" class="easyui-linkbutton easyui-tooltip" title="跳转至主页选项卡" data-options="plain: true, iconCls: 'icon-hamburg-home'"></a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a id="mainTabs_toggleAll" class="easyui-linkbutton easyui-tooltip" title="展开/折叠面板使选项卡最大化" data-options="plain: true, iconCls: 'icon-standard-arrow-out'"></a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a id="mainTabs_refTab" class="easyui-linkbutton easyui-tooltip" title="刷新当前选中的选项卡" data-options="plain: true, iconCls: 'icon-standard-arrow-refresh'"></a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a id="mainTabs_closeTab" class="easyui-linkbutton easyui-tooltip" title="关闭当前选中的选项卡" data-options="plain: true, iconCls: 'icon-standard-application-form-delete'"></a></td>
				</tr>
			</table>
		</div>
		<div id="mainTabs" class="easyui-tabs" data-options="fit: true, border: false, showOption: true, enableNewTabMenu: true, tools: '#mainTabs_tools', enableJumpTabMenu: true">
			<div id="homePanel" data-options="title: '主页', iconCls: 'icon-hamburg-home'">
				<div class="easyui-layout" data-options="fit: true">
					<div data-options="region: 'north', split: false, border: false" style="height: 33px;">
						首页内容
					</div>
					<div data-options="region: 'center', border: false" style="overflow: hidden;">
						<p><a href="posMerchant_agentMerchantOneAuditList.action" title="商户初审" style="color:blue;" id="created" target="navTab">待初审商户(0)</a></p>
						<p><a href="posMerchant_agentMerchantTwoAuditList.action" title="商户终审" style="color:blue;" id="auditing" target="navTab">待终审商户(0)</a></p>
						<p><a href="posMerchant_agentMerchantList.action?status=103" title="pos商户管理" style="color:blue;" id="nopass" target="navTab">审核拒绝商户(0)</a></p>
						<p><a href="posMerchant_agentMerchantList.action?status=100" title="pos商户管理" style="color:blue;" id="active" target="navTab">已开通商户(0)</a></p>

						<div class="unit">
							<hr>
						</div>
						<br/>
						<div class="unit">
							<h1>代理商&nbsp;&nbsp;&nbsp;&nbsp;(<a href="javascript:loadAgentStatus();" style="color:blue;">刷新</a>)</h1>
							<br/>
						</div>
						<p><a href="agent_auditAgentList.action" title="代理商审核" style="color:blue;" id="Acreated" target="navTab">待审核代理商(0)</a></p>
						<p><a href="agent_agentList.action?agentStatus=103" title="代理商信息管理" style="color:blue;" id="Anopass" target="navTab">审核拒绝代理商(0)</a></p>
						<p><a href="agent_agentList.action?agentStatus=100" title="代理商信息管理" style="color:blue;" id="Aactive" target="navTab">已开通代理商(0)</a></p>

						<div class="unit">
							<hr>
						</div>
						<br/>

						<div class="unit">
							<h1>变更申请&nbsp;&nbsp;&nbsp;&nbsp;(<a href="javascript:loadChangeInfoStatus();" style="color:blue;">刷新</a>)</h1>
							<br/>
						</div>
						<p><a href="merchantRequest_merchantBaseList.action?requestType=1&verifyStatus=101" title="商户信息变更" style="color:blue;" id="merchBaseInfoDiv" target="navTab">商户信息变更(0)</a></p>
						<p><a href="merchantRequest_merchantBaseList.action?requestType=2&verifyStatus=101" title="商户费率变更" style="color:blue;" id="merchRateInfoDiv" target="navTab">商户费率变更(0)</a></p>
						<p><a href="merchantRequest_merchantBaseList.action?requestType=3&verifyStatus=101" title="商户结算变更" style="color:blue;" id="merchSettInfoDiv" target="navTab">商户结算变更(0)</a></p>
						<p><a href="merchantRequest_merchantBaseList.action?requestType=4&verifyStatus=101" title="商户机具变更" style="color:blue;" id="merchTermInfoDiv" target="navTab">商户机具变更(0)</a></p>
						<p><a href="merchantRequest_merchantBaseList.action?requestType=5&verifyStatus=101" title="代理商信息变更" style="color:blue;" id="agentBaseInfoDiv" target="navTab">代理商信息变更(0)</a></p>
						<p><a href="merchantRequest_merchantBaseList.action?requestType=6&verifyStatus=101" title="代理商结算变更" style="color:blue;" id="agentSettInfoDiv" target="navTab">代理商结算变更(0)</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div data-options="region: 'east', title: '日历', iconCls: 'icon-standard-date', split: true,collapsed: true, minWidth: 160, maxWidth: 500" style="width: 220px;">
		<div id="eastLayout" class="easyui-layout" data-options="fit: true">
			<div data-options="region: 'north', split: false, border: false" style="height: 220px;">
				<div class="easyui-calendar" data-options="fit: true, border: false"></div>
			</div>
			<div id="linkPanel" data-options="region: 'center', border: false, title: '通知', iconCls: 'icon-hamburg-link', tools: [{ iconCls: 'icon-hamburg-refresh', handler: function () { window.link.reload(); } }]">

			</div>
		</div>
	</div>

	<div data-options="region: 'south', title: '关于...', iconCls: 'icon-standard-information', collapsed: true, border: false" style="height: 70px;">
		<div style="color: #4e5766; padding: 6px 0px 0px 0px; margin: 0px auto; text-align: center; font-size:12px; font-family:微软雅黑;">

		</div>
	</div>

</div>

<script>
var treeObj;
var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: 0
		}
	},
	view: {
		dblClickExpand: false
	},
	async: {
		enable: true,
		type: "get",
		url: "${pageContext.request.contextPath}/menu-tree-json"
	},
	callback: {
		onClick: testClick
	}
};

treeObj = $.fn.zTree.init($("#tree"), setting);

function testClick(event, treeId, treeNode) {
	var index = treeNode.url.indexOf("#");
	if (treeNode.url != '' && index < 0) {
		window.mainpage.mainTabs.addModule(treeNode.name, treeNode.url);
	}
	event.preventDefault();
}

$('.easyui-linkbutton').on('click', function(){
	$('.easyui-linkbutton').linkbutton({selected:false});
	$(this).linkbutton({selected:true});
});
</script>

</body>
</html>
