<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 상세 정보</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            margin-top: 20px;
        }
        .post-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .post-content {
            font-size: 18px;
            white-space: pre-line;
        }
        .info-row {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<%@ page import="Sun.crud.res.entity.BoardEntity" %>

<div class="container">
    <h2 class="post-title">${boardEntity.title}</h2>

    <c:choose>
        <c:when test="${not empty boardEntity}">
            <div class="info-row">
                <strong>글 내용:</strong>
                <p class="post-content">${boardEntity.content}</p>
            </div>
            <div class="info-row">
                <strong>작성자:</strong>
                <span>${boardEntity.writer}</span>
            </div>
            <div class="info-row">
                <strong>작성일:</strong>
                <span>${boardEntity.createdDate}</span>
            </div>
            
  			  <a href="/edit?boardNo=${boardEntity.boardNo}" class="btn btn-primary">수정</a>
        </c:when>
        <c:otherwise>
            <p>${error}</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
