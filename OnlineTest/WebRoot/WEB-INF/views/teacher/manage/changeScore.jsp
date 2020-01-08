<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>学生成绩详情</title>
		<script src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" />
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$("#changeF").click(function(){
					var dataSpdidajax="";
					var dataScoreajax="";
					$('input[id="spdidF"]').each(function(){
						dataSpdidajax+=($(this).val())+",";
					});
						dataSpdidajax=dataSpdidajax.substr(0, dataSpdidajax.length-1);
					$('input[id="scoreF"]').each(function(){
						dataScoreajax+=($(this).val())+",";
					});
						dataScoreajax=dataScoreajax.substr(0, dataScoreajax.length-1);
					
					var data={
						dataspdid:dataSpdidajax,
						datascore:dataScoreajax
					};
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath }/teacher/manage/changeScoreSave",
						data:data,
						dataType:"JSON",
						success:function (data)
						{
							alert("保存成功！！！");
						},
						error:function()
						{
							alert("保存失败(请刷新页面)！！！");
						}
					});
				});
			});
		</script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/exam/public.css" />

	</head>

	<body>
		<input type="hidden" id="spid" name="spid" value="${Spid}"/>
		<div id="exam_main_panle">
			<!--
            	作者：offline
            	时间：2019-10-12
            	描述：顶部栏
            -->
			<div class="row" id="exam_top_main_panle">
				<div class="col-md-6" id="exam_top_logo">
					<a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/static/img/index/logo_min.png" /></a>
				</div>
				<div class="col-md-6" id="exam_top_bar">
					<!--
                    	作者：offline
                    	时间：2019-10-11
                    	描述：<h4 id="name"><a href="">欢迎你:XXX</a></h4>
                    -->
					<div class="dropdown">
						<h4 class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    						欢迎你${teacher.gettNum() }
    						<span class="caret"></span>
  						</h4>
						<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
							<%-- <li>
								<a href="${pageContext.request.contextPath }/student/manage/account_info">个人中心</a>
							</li> --%>
							<li role="separator" class="divider"></li>
							<li>
								<a href="${pageContext.request.contextPath }/admin/logOut">退出</a>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div id="tools">
				<a href="${pageContext.request.contextPath }/teacher/manage/teaching_class">返回上一页</a>
				<hr /> 
				<br /> 
				<br /> 
				<hr /> 
				<br /> 
				<br /> 
				<br />
				<hr />
				<div id="ttl">
					<span style="font-size: 21px" id="hour_show"></span><br/>
					<span style="font-size: 21px" id="end"></span><br/>
					<span id="second_show">${endtime }</span>
				</div>

			</div>
			<div id="exam_panle">

					<div id="shortanswer">
						<div class="items">
							四、简答题
						</div>
						
						<c:if test="${totaList!=null }">
							<form action="">
							<c:forEach items="${totaList.split('_,') }" var="qi"><br/>
								<input id="spdidF" name="spdidF" type="hidden" value="${qi.split(',')[5].substring(1,qi.split(',')[5].toString().length()) }"/><br/>
								<c:forEach items="${qi.split(',') }" var="iq" end="4">
									<c:if test="${isNumeric.isNumeric(iq.substring(1,iq.toString().length()))!=true }">
										<textarea disabled="disabled" class="form-control"  id="score111" rows="3" cols="10" style="width: 500px;">${iq.substring(0,iq.toString().length()) }</textarea>
									</c:if>
									
									<c:if test="${isNumeric.isNumeric(iq.substring(1,iq.toString().length()))==true }">
										<span>得分：</span>
										<input onkeyup="this.value=this.value.replace(/[^0-9]+/,'');" id="scoreF" name="scoreF" type="text" value="${iq.substring(1,iq.toString().length()) }"/>
									</c:if><br/>
								</c:forEach>
								
							</c:forEach><br/>
							<input type="button" id="changeF" value="修改分数"/>
							</form>
						</c:if>
					</div>
					<!-- <button type="button" class="btn btn-default" id="exam_post">提交</button> -->
					<c:if test="${totaList!=null }">
						<c:if test="${page!=0 }">
							<a href="${pageContext.request.contextPath }/teacher/manage/changeScore?eid=${eid }&page=${page-1 }&totalPages=${totalPages }">上一个</a>
						</c:if>
					</c:if>
					${page+1 }/${totalPages }
					<c:if test="${totaList!=null }">
						<c:if test="${totalPages!=page+1 }">
							<a href="${pageContext.request.contextPath }/teacher/manage/changeScore?eid=${eid }&page=${page+1 }&totalPages=${totalPages }">下一个</a>
						</c:if>
					</c:if>
			</div>

		</div>
	</body>
	<%-- <script src="${pageContext.request.contextPath }/static/js/exam/do.js" type="text/javascript" charset="utf-8"></script>
 --%>
</html>