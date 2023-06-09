<%@page import="com.edu.shopprac.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<%@ include file="../inc/header_link.jsp"%>
<style type="text/css">
.box-style{
	width:90px;
	height:95px;
	border:1px solid #ccc;
	display:inline-block;
	margin:5px;
}
.box-style img{
	width:75px;
	height:70px;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<%@ include file="../inc/preloader.jsp" %>
		
		<!-- Navbar -->
		<%@ include file="../inc/navbar.jsp" %>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../inc/sidebar_left.jsp" %>
		
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">카테고리 관리</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품관리> 상품등록</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content" id="app1">
				<div class="container-fluid">
				
					<!-- Main row -->
					<div class="row">
					
						<div class="col-7">
						    <div class="card">
						        <!-- /.card-header -->
					        	
					        	
						        <div class="card-body table-responsive p-0">
						            <table class="table table-hover text-nowrap">
						                <tbody>
											<tr>
												<td colspan="2">
									        		<div class="form-group row">
									        			<div class="col-sm-9">
										                    <input type="text" name="category_name" class="form-control" placeholder="카테고리 입력">
									        			</div>
									        			<div class="col-sm-3">
										                    <button type="button" class="btn btn-danger" id="bt_regist">등록</button>
									        			</div>
									        		</div>
												</td>
											</tr>	
											
											<template v-for="category in categoryList">					                
												<row :key="category.category_idx" :obj="category"/>
						                    </template>
						                    
						                </tbody>
						            </table>
						        </div>
						        
						        
						        <!-- /.card-body -->
						    </div>
						    <!-- /.card -->
						</div>					
					
					
						<div class="col-5">
						    <div class="card">
						    
						        <div class="card-body">
						        	<form id="form2">
						        	<input type="hidden" name="_method">
						        	<input type="hidden" name="category_idx">
					        		<div class="form-group row">
					        			<div class="col-6">
						                    <input type="text" name="category_name" class="form-control" >
					        			</div>
					        			<div class="col-3">
						                    <button type="button" class="btn btn-danger" id="bt_edit">수정</button>
					        			</div>
					        			<div class="col-3">
						                    <button type="button" class="btn btn-danger" id="bt_del">삭제</button>
					        			</div>
					        		</div>
					        		</form>
						        </div>
						        
						    </div>
						</div>					
					</div>
					<!-- /.row (main row) -->
				</div>
				
				<!-- /.container-fluid -->
			
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		
		<%@ include file="../inc/footer.jsp" %>		

		<!-- Control Sidebar -->
		<%@ include file="../inc/sidebar_right.jsp" %>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp" %>
	
	<script type="text/javascript">
	
	let app1;
	let selectedRow;
	
	const row={
			template:
				`
				<tr>
					<td>{{category.category_idx}}</td>
					<td @click="getDetail(category)"><a href="#">{{category.category_name}}</a></td>
				</tr>
				`,
				props:["obj"],
				data(){
					return{
						category: this.obj
					};
				},
				methods:{
					getDetail:function(category){
						$("#form2 input[name='category_idx']").val(category.category_idx);
						$("#form2 input[name='category_name']").val(category.category_name);
						selectedRow=this;
					}
				}
	}
	
	app1= new Vue({
		el:"#app1",
		components:{
			row
		},
		data:{
			categoryList:[]
		}
		
	});
	
	function getCategoryList(){
		$.ajax({
			url:"/admin/rest/category",
			type:"get",
			success:function(result, status, xhr){
				app1.categoryList= result;
			}
		});
	}
	
	function regist(){
		$.ajax({
			url:"/admin/rest/category",
			type:"post",
			data:{
				category_name:$("input[name='category_name']").val()
			},
			success:function(result, status, xhr){
				alert(result.msg);
				getCategoryList();
			}
		});
	}
	
	function edit(){
		if(!confirm("수정하시겠어요?")){
			return;
		}
		
		let json={};
		
		json['category_idx']=$("#form2 input[name='category_idx']").val();
		json['category_name']=$("#form2 input[name='category_name']").val();
		
		$.ajax({
			url:"/admin/rest/category",
			type:"put",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(json),
			processData:false,
			success:function(result, status, xhr){
				console.log(result);
			}
		});
	}
	
	function del(){
		if(!confirm("삭제하시겠어요?")){
			return;
		}
		
		$.ajax({
			url:"/admin/rest/category/"+$("form2 input[name='cateogry_idx']").val(),
			type:"delete",
			success:function(result, status, xhr){
				console.log(result);
				getCategoryList();
			}
		});

	}
	
	$(function(){
		
		getCategoryList();
		
		$("#bt_regist").click(function(){
			regist();
		});
		
		$("#bt_edit").click(function(){
			edit();
		});

		$("#bt_del").click(function(){
			del();
		});

	});
		

	</script>
</body>
</html>








