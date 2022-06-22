<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/blog">홈</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/user/login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="/user/join">SingUp</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="cotainer">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">제목을 입력하세요</h4>
				<p class="card-text">내용을 입력하세요</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">제목을 입력하세요</h4>
				<p class="card-text">내용을 입력하세요</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">제목을 입력하세요</h4>
				<p class="card-text">내용을 입력하세요</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>🚖Created by alivejuicy</p>
		<p>010-7791-6473</p>
		<p>Republic of Korea</p>
	</div>

</body>
</html>