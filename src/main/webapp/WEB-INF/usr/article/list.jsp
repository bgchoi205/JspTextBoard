<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- 모바일에서도 디자인 축소 방지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 데이지 UI 불러오기 -->
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://cdn.jsdelivr.net/npm/daisyui@1.3.6/dist/full.css"
	rel="stylesheet" type="text/css" />

<!-- font.css 연결 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/font.css" />

<!-- common.css 연결 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/common.css" />

<title>JspTextBoard</title>

</head>
<body>
	<section class="section section-article-write px-4">
		<div class="container mx-auto">
		
			<div class="card bordered shadow-lg">
		      	<div class="card-title">
			        <a href="javascript:history.back();" class="cursor-pointer">
			          <i class="fas fa-chevron-left"></i>
			        </a>
			        <span>게시물 리스트</span>
		      	</div>
		      	<div class="px-4 py-4">
		      		<c:forEach items="${articles}" var="article">
		      			<div>
		      				번호 : ${article.id}<br>
		      				등록 : ${article.regDate}<br>
		      				수정 : ${article.updateDate}<br>
		      				제목 : ${article.title}<br>
		      				내용 : ${article.body}<br>
		      			</div>
		      			<hr />
		      		</c:forEach>
		      	</div>
	      	</div>
		
			
		</div>
	</section>
</body>
</html>