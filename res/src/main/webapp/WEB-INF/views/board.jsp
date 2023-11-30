<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body class="bg-gray-100 p-4 text-center">

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover table-striped" style="border:1px solid;">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="boardEntity" items="${board}">
                        <tr onclick="location.href='/board/detail/${boardEntity.boardNo}'" style="cursor: pointer;">
                            <td>${boardEntity.boardNo}</td>
                            <td>${boardEntity.title}</td>
                            <td>${boardEntity.writer}</td>
                            <td>
                                <form method="post" action="/board/delete/${boardEntity.boardNo}">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit" class="btn btn-danger" onclick="return confirm('게시물을 삭제하시겠습니까?')">삭제</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<button type="button" class="btn btn-outline-secondary" id="b-write">글쓰기</button>

<!-- Include the Bootstrap JavaScript libraries -->
</body>
<script>
    // 클릭 시 /write로 이동
    document.getElementById("b-write").onclick = function() {
        window.location.href = "/write";
    };
</script>
</html>
