<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="게시물 작성" />
<%@ include file="../part/head.jspf" %>

	<section class="section section-article-write px-4">
		<div class="container mx-auto">
		
			<div class="card bordered shadow-lg">
		      	<div class="card-title">
			        <a href="javascript:history.back();" class="cursor-pointer">
			          <i class="fas fa-chevron-left"></i>
			        </a>
			        <span>게시물 작성</span>
		      	</div>
		      	<div class="px-4 py-4">
		      		<script>
						let ArticleWrite__submitDone == false;
						
						function ArticleWrite__submit(form){
				
							if(ArticleWrite__submitDone){
								return;
							}
							
							if(form.title.value.length == 0){
								alert('제목을 입력해주세요.');
								form.title.focus();
								
								return;
							}
							
							if(form.body.value.length == 0){
								alert('내용을 입력해주세요.');
								form.body.focus();
								
								return;
							}
							
							form.submit();
							ArticleWrite__submitDone = true;
						}
					</script>

					<form action="../article/doWrite" method="POST"
						onsubmit="ArticleWrite__submit(this); return false;">
						<input type="hidden" name="redirectUri" value="../article/detail?id=[NEW_ID]"/>
						<div class="form-control">
							<label class="label"> <span class="label-text">제목</span>
							</label>
							<div>
								<input class="input input-bordered w-full" type="text"
									name="title" maxlength="100" placeholder="제목을 입력해주세요" />
							</div>
						</div>
		
						<div class="form-control">
							<label class="label"> <span class="label-text">내용</span>
							</label>
							<textarea class="textarea h-60 textarea-bordered" name="body"
								maxlength="2000" placeholder="내용을 입력해주세요."></textarea>
						</div>
		
						<div class="btns">
							<button type="submit" class="btn btn-ghost">작성</button>
							<button type="button" class="btn btn-ghost">작성취소</button>
						</div>
		
					</form>
		      	</div>
	      	</div>
		
			
		</div>
	</section>
<%@ include file="../part/foot.jspf" %>