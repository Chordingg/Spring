<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../includes/header.jsp" %>    

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">상세페이지</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Get Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
            
            		<div class="form-group">
            			<label>Bno</label>
            			<input class="form-control" name="bno" value="${board.bno}" readonly="readonly"> 
            		</div>
            		
            		<div class="form-group">
            			<label>Title</label>
            			<input class="form-control" name="title" value="${board.title}" readonly="readonly"> 
            		</div>
            		
            		<div class="form-group">
            			<label>Content</label>
            			<textarea rows="3" class="form-control" name="content" readonly="readonly">${board.content}</textarea>
            		</div>
            		
            		<div class="form-group">
            			<label>Writer</label>
            			<input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
            		</div>
            		
            		<!-- modify 버튼을 눌렀을 때, bno 값을 받도록 한다. -->
            		<button data-oper='modify' class="btn btn-primary" onclick="location.href='/board/modify?bno=${board.bno}'">Modify</button>&nbsp;&nbsp;
            		
            		<!-- list 화면으로 복귀 -->
            		<button data-oper='list' class="btn btn-warning" onclick="location.href='/board/list'">List</button>
            		
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@ include file="../includes/footer.jsp" %>            