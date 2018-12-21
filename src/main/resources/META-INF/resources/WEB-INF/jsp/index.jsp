<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<head>
<title>Upload MultipartFile</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width , initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<body>
	`
	<div class="container h-100">
		<div class="h-100">
			<div class="row h-100 justify-content-center align-items-center">
				<div class="col-sm-5">
					<h3>Upload MultipartFile to FileSystem</h3>
					<form method="POST" enctype="multipart/form-data"
						id="fileUploadForm">
						<div class="form-group">
							<label class="control-label" for="uploadfile">Upload File</label>
							<input type="file" class="form-control" id="uploadfile"
								placeholder="Upload File" name="uploadfile"></input>
						</div>
						<button type="submit" class="btn btn-default" id="btnSubmit">Upload</button>
						<a href="file" class="btn btn-default" role="button">Files</a>
					</form>
					<div class="container">
						<c:if test="${not empty message}">
						${message}
					</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container h-100">
		<div class="row h=100 justify-content-center align-items-center">
			<h2>Uploaded Exam</h2>
			<table id="examTable" class="table">
				<thead>
					<tr>
						<th>Question No.</th>
						<th>Question</th>
						<th>Answer 1</th>
						<th>Answer 2</th>
						<th>Answer 3</th>
						<th>Correct Answer </th>
					</tr>
				</thead>
				<tbody>



					<c:forEach var="rowInfo" items="${rowList}">
						<tr>
							<td>${rowInfo.questionNo}</td>
							<td>${rowInfo.question}</td>
							<td>${rowInfo.ansOpt1}</td>
							<td>${rowInfo.ansOpt2}</td>
							<td>${rowInfo.ansOpt3}</td>
							<td>${rowInfo.correctAns}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

