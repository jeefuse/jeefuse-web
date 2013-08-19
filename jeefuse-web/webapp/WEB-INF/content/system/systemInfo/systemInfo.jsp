<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>系统信息</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|blockUI|common|ui', ctx);
	//importFile('/dev/modules/table/styles.css', ctx);
</script>
<style type="text/css">
html{overflow: auto;}
</style>
</head>
<body id="container">
	<!-- header start -->
 	<div id="header" region="north" split="false" border="false"  class="v-header" >
		<div id="title" class="v-title">
		
		</div>

		<div id="toolbar" class="v-toolbar"><!-- v-toolbar start -->
			<div class="v-menu">
				<a href="javascript:refresh()" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-reload">刷新</span></span>
				</a>
			</div>
			<div class="clear"></div>
		</div><!-- v-toolbar end -->
		
	</div><!-- header end -->
	
    <!-- content start -->
    <div id="content" region="center"  border="true">
		
    		<div id="monitorInfo" class="v-section-wrap">
				<div class='v-title'>系统运行信息:</div>
				<div class="v-content">
					<table class='v-table' cellpadding="0" cellspacing="0">
						  <tr>
						  		<td class="label" width="30%">
				      				<label>系统物理内存总计:</label>
				      			</td>
				      			<td class="field" width="20%">
				      				${monitorInfo.totalPhysicalMemorySizeFormat}
				      			</td>
								<td class="label" width="30%">
									<label>JVM最大可使用内存:</label>
								</td>
								<td class="field" width="20%">${monitorInfo.maxMemoryFormat}</td>						
							</tr>
				      		<tr>
				      			<td class="label">
				      				<label>系统可用物理内存总计:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.freePhysicalMemorySizeFormat}
				      			</td>
				      			<td class="label">
									<label>JVM所占用内存:</label>
								</td>
								<td class="field">${monitorInfo.totalMemoryFormat}</td>		
				      		</tr>
				      		<tr>
				      			<td class="label">
				      				<label>系统已使用物理内存总计:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.usedPhysicalMemorySizeFormat}
				      			</td>

				      			<td class="label">
				      				<label>JVM剩余内存:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.freeMemoryFormat}
				      			</td>
	
				      		</tr>
				      		<tr>
				      			<td class="label">
				      				<label>系统交换空间大小:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.freeSwapSpaceSizeFormat}
				      			</td>
				      			<td class="label">
				      				<label>提交的虚拟内存大小:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.committedVirtualMemorySizeFormat}
				      			</td>
				      		</tr>
				      		<tr>
				      			<td class="label">
				      				<label>系统平均负载:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.systemLoadAverage}
				      			</td>
				      			<td class="label">
				      				<label>线程总数:</label>
				      			</td>
				      			<td class="field" >
				      				${monitorInfo.totalThread}
				      			</td>
				      		</tr>
						</table>
				</div>
			</div>
    		<div id="systenProps" class="v-section-wrap">
				<div class='v-title'>系统环境参数:</div>
				<div class="v-content" >
					<s:if test="systemPropsSet">
		              <table cellpadding="0"  cellspacing="0"  class="v-table">
		              	<thead>
		                 <tr class="first">
		                   <th width="35%">参数名</th>
		                   <th width="65%" class="last">参数值</th>
		                 </tr>
		              	</thead>
		                 <c:forEach items="${systemPropsSet}" var="item" varStatus="status">
		                   <tr ${status.index%2!=0?"class='odd'":""}>
		                       <td >${item.key}</td>
		                       <td class="last">${item.value==null?"&nbsb;":item.value}</td>
		                   </tr>
		               </c:forEach>
		              </table>
		           </s:if>
				</div>
			</div>

	</div><!-- content end -->
<script type="text/javascript">
function refresh(){
	window.location.href=window.location.href;
}
</script>
</body>
</html>