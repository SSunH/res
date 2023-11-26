<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.tailwindcss.com?plugins=forms,typography"></script>
</head>
<body>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100 p-4">
    <div class="container mx-auto">
        <h1 class="text-3xl font-bold mb-4">게시판</h1>
        <ul class="list-disc pl-4">
            <li><a href="post.jsp?id=1" class="text-blue-500">게시글 1</a></li>
            <li><a href="post.jsp?id=2" class="text-blue-500">게시글 2</a></li>
            <!-- 게시글 목록을 동적으로 생성하는 로직은 실제 프로젝트에서 추가되어야 합니다. -->
        </ul>
    </div>
</body>
</html>




</body>

</html>