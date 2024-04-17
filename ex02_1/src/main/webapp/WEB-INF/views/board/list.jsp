<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../includes/header.jsp" %>    

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
                <table width="100%" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>#번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="board" items="${list}">
                        <tr class="odd gradeX">
                            <td>${board.bno}</td>
                            <td><a href='/board/get?bno=${board.bno}'>${board.title} </a></td>
                            <td>${board.writer}</td>
                            <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>
                            <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          처리되었습니다.	
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>	<!-- End The Modal -->
  
  
  
  
<script>
	$(document).ready(function(){
		// let result = '<c:out value="${result}"/>';		
		let result = '${result}';	
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		
		function checkModal(result){
			
			// result 값에 아무것도 없으면 아무 일도 없게끔..
			if(result === "" || history.state){
				return;
			}
			
			// result 값이 있을 때, modal창에 띄우는 내용
			if(parseInt(result) > 0){
				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.")
			}
			
			$("#myModal").modal("show");
		};
		
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
			
	});
	
</script>







<%@ include file="../includes/footer.jsp" %>            