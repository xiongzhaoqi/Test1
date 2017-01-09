<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="./css/login.css">
		<script type="text/javascript" src="./js/login.js">
</script>
	</head>

	<body>
		<div>
			<div class="font1">
				公司文件管理系统
			</div>
			<div class="font5">
				本公司成立于2011年2月23日，员工有7名！爱上了开发建设了开发建设路附近拉萨附近开了世界法律考试及法律考试
				阿萨德仿肌肤立刻就爱上了疯狂的世界了附近按时到了房间萨达浪费空间撒到了fks大家
				阿斯顿离开房间萨达离开房间数量的访客记录的师傅介绍来的快放假了速度快放假上的fks地方离开房间数量
				萨达离开福建爱师傅了看见俺收到了福建爱上了的飞机离开房间里卡上的飞机离开的是法律考试的经历
				是打发了空间撒地方啦空间十分的历史的法兰克拉萨的会计法律上的积分了师傅kdj离开房间萨达离开房间萨拉丁
			</div>
			<form action="LoginServlet?flag=login" method="post" id="input" name="input">
				<div>
					<div class="font2">
						用户登录
					</div>
					<div class="font3">
						<div>
							编号:
							<input type="text" id="id" name="id" style="width: 150px;" />
						</div>
						<div class="font4">
							密码:
							<input type="password" id="password" name="password"
								style="width: 150px;" />
						</div>
					</div>
					<div class="button">
						<input type="submit" value="登录 " onclick="return check()" />
					</div>
				</div>
			</form>
			<div class="biao">
				<img src="./img/biao.jpg" />
				<div class="biao2"><a href="" style="text-decoration: none" onclick="return check2()">部门信息</a></div>
			</div>
			<div class="ren">
				<img src="./img/ren.jpg" />
				<div class="ren2"><a href="" style="text-decoration: none" onclick="return check2()">员工信息</a></div>
			</div>
			<div class="diannao">
				<img src="./img/diannao.jpg" />
				<div class="diannao2"><a href="" style="text-decoration: none" onclick="return check2()">即时交流</a></div>
			</div>
			<div class="xin">
				<img src="./img/xin.jpg" />
				<div class="xin2"><a href="" style="text-decoration: none" onclick="return check2()">资源管理</a></div>
			</div>
		</div>
	</body>
</html>
