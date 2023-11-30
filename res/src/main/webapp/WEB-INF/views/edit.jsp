<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body class="bg-gray-100 p-4">   
    <!-- Form for posting -->
<form method="post" action="/board/edit/${boardEntity.boardNo}">
        <input type="hidden" name="_method" value="put">
       
        
        <div class="mb-3">
            <label for="postTitle" class="form-label">제목</label>
            <input type="text" class="form-control" id="newTitle" name="newTitle"  required>
        </div>
        <div class="mb-3">
            <label for="postContent" class="form-label">내용</label>
            <textarea class="form-control" id="newContent" name="newContent" rows="3" required></textarea>
        </div>
        
       <button type="submit" class="btn btn-danger" onclick="return confirm('게시물을 수정하시겠습니까?')">수정</button>
        </form>
</body>
</html>
