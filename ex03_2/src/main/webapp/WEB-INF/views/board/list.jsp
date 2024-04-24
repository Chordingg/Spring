<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board List</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board List Page
                <button id="regBtn" type="button" class="btn btn-xs pull-right btn-info">Register New Board</button>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover" >
                    <thead>
                        <tr>
                            <th>#번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    	<c:forEach var="board" items="${list}">
	                        <tr class="odd gradeX">
	                            <td>${board.bno}</td>
	                            <td><a href='/board/get?bno=${board.bno}'>${board.title}</a></td>
	                            <td>${board.writer }</td>
	                            <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
	                            <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
	                        </tr>
                        </c:forEach>
                </table>
                
                <!-- 페이징 처리 -->
				<div class="container">
				  <ul class="pagination">
					
					<c:if test="${pageMaker.prev}">  
				    	<li class="page-item"><a class="page-link" href="${pageMaker.startPage - 1}">이전</a></li>
				  	</c:if>
				  	
				  	<!-- actionForm.find("input[name='pageNum']").val($(this).attr("href")); -->
				  	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				    	<li class="page-item ${pageMaker.cri.pageNum == num ? 'active' : ''} ">
				    		<a class="page-link" href="${num}">${num}</a>
				    	</li>
				    </c:forEach>
				  
				  	<c:if test="${pageMaker.next}"> 
				    	<li class="page-item"><a class="page-link" href="${pageMaker.endPage + 1}">다음</a></li>
				    </c:if>
				    
				  </ul>
				</div> <!-- End 페이징 처리 -->
				
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}'>
					<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
				</form>
				
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- 모달창 추가 -->
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Modal Title</h4>
			</div>
			<!-- Modal body -->
			<div class="modal-body">처리가 완료되었습니다.</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- /모달창 추가 -->

<script type="text/javascript">
	$(document).ready(
			function() {

				var result = '<c:out value="${result}"/>';

				// 파라미터에 따라서 모달창을 보여주거나 내용을 수정한 뒤 보이도록 작성한다.
				// 새로운 게시글이 작성되는 경우 RedirectAttributes로 게시물의 번호가 전송되므로 모달창의 내용을 수정한다.
				checkModal(result);

				history.replaceState({}, null, null);

				function checkModal(result) {

					if (result === '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$(".modal-body").html(
								"게시글 " + parseInt(result) + "번 등록 성공 했습니다.")
					}

					$("#myModal").modal("show");
				};
				
				 //register 호출
			      $("#regBtn").on("click", function(){
			         self.location = "/board/register";
			      });
				 
				 // 페이징 처리
				 
			      let actionForm = $("#actionForm");
			 		$(".page-item a").on("click", function(e){
			 			e.preventDefault();
			 			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			 			actionForm.submit();
			 		}); 
				 
			});
</script>
 
 
 
 
      
<%@include file="../includes/footer.jsp" %>      