<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="UTF-8">
		<title>试卷成绩</title>
		<script src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" />
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/teacher/public.css" />
		<script src="${pageContext.request.contextPath }/static/js/teacher/do.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/static/echarts/echarts.js" type="text/javascript" charset="utf-8"></script>
		<style>
	        table {
	            border-collapse: collapse;
	        }
	    </style>
	</head>
	<body>
	<div id="teach_main_panle">

		<!--
            	作者：offline
            	时间：2019-10-12
            	描述：顶部栏
            -->
		<div class="row" id="teach_top_main_panle">
			<div class="col-md-6" id="teach_top_logo">
				<a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/static/img/index/logo_min.png" /></a>
			</div>
			<div class="col-md-6" id="teach_top_bar">
				<div class="dropdown">
					<h4 class="dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    						欢迎你:${sessionScope.teacher.gettName() }
    						<span class="caret"></span>
  						</h4>
					<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu">
						<!-- <li>
							<a href="#">个人中心</a>
						</li> -->
						<li role="separator" class="divider"></li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/logOut">退出</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--
            	作者：offline
            	时间：2019-11-14
            	描述：导航栏
            	
            -->
		<div id="tool">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" >
						<a href="${pageContext.request.contextPath }/teacher/manage/teaching_class">管理班级</a>
				</li>
				<li role="presentation">
						<a href="${pageContext.request.contextPath }/teacher/manage/teaching_itembank" >题库管理</a>
				</li>
				<li role="presentation">
						<a href="${pageContext.request.contextPath }/teacher/manage/teaching_paple">创建试卷</a>
				</li>
			
			</ul>
			<div class="tab-content">
			
			
				<table border="1" style="width: 300px">
				<caption>学生成绩表</caption>
				<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>成绩</td>
				<td>查看得分详情</td>
				</tr>
				<c:forEach items="${finAllStuPaper.getContent() }" var="fasp">
				<tr>
				<td>${fasp.getStudent().getsNum() }</td>
				<td>${fasp.getStudent().getsName() }</td>
				<td>${fasp.getSpscore() }分</td>
				<td><a href="${pageContext.request.contextPath }/teacher/manage/checkoutex?spid=${fasp.getSpid()}&snum=${fasp.getStudent().getsNum() }&sname=${fasp.getStudent().getsName() }">详情</a></td>
				</tr>
				</c:forEach>
				</table>
				<a id="excel111">导出表格</a>
			</div>
		</div>

	</div>
	<div id="mydiv" style="width: 1000px; height: 800px; margin: 0 auto;">
	
 	<script>
        var html = "<html><head><meta charset='utf-8' /></head><body>" + document.getElementsByTagName("table")[0].outerHTML + "</body></html>";
        var blob = new Blob([html], { type: "application/vnd.ms-excel" });
        var a = document.getElementsByTagName("a")[document.getElementsByTagName("a").length-1];
        a.href = URL.createObjectURL(blob);
        a.download = "学生成绩表.xls";
        
        
        //获取div对象
			var mydiv=document.getElementById("mydiv");
			//第一步 初始化echarts，并指定放入div块中
		    var mycharts=echarts.init(mydiv);
			 // 第二步，指定图表的配置项和数据		
		var	option = {
    title: {
        text: '成绩分布',
        subtext: '',
        left: 'center'
    },
    tooltip : {
        trigger: 'item'
      
    },
     toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    legend: {
        // orient: 'vertical',
        // top: 'middle',
        bottom: 10,
        left: 'center',
        data: ['优秀', '良','及格','不及格']
    },
    series : [
        {
            type: 'pie',
            radius : '65%',
            center: ['50%', '50%'],
            selectedMode: 'single',   //一次只能选中一个
            data:[
                {value:${perfectNum}, name: '优秀'},
                {value:${goodNum}, name: '良好'},
                {value:${passNum}, name: '一般'},
                {value:${failNum}, name: '较差'},
            
            ]
        }
    ]
};

   // 使用刚指定的配置项和数据显示图表。
        mycharts.setOption(option);
        
    </script>
	</body>
</html>