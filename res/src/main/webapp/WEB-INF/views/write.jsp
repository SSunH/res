<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery를 먼저 로드합니다. -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<script> // jQuery를 사용하는 코드
			$(document).ready(function() {
            $('#submitPost').click(function() {
                var postTitle = $('#postTitle').val();
                var postContent = $('#postContent').val();

                // JSON 데이터 생성
                var postData = {
                    postTitle: postTitle,
                    postContent: postContent
                };

                // AJAX로 JSON 데이터를 POST 요청으로 보내기
                $.ajax({
                    type: 'POST',
                    url: '/write',
                    contentType: 'application/json', // 데이터 형식 지정
                    data: JSON.stringify(postData), // JSON 문자열로 변환하여 전송
                    success: function(response) {
                        console.log('Post created successfully');
                        // 여기에서 필요한 추가 동작 수행
                    },
                    error: function(error) {
                        console.error('Error creating post:', error);
                    }
                });
            });
        });
    </script>
<body class="bg-gray-100 p-4">   

    <!-- Form for posting -->
    <form id="postForm">
        <div class="mb-3">
            <label for="postTitle" class="form-label">제목</label>
            <input type="text" class="form-control" id="postTitle" name="postTitle" required>
        </div>
        <div class="mb-3">
            <label for="postContent" class="form-label">내용</label>
            <textarea class="form-control" id="postContent" name="postContent" rows="3" required></textarea>
        </div>
        <button type="button" class="btn btn-primary" id="submitPost">게시물 작성</button>
    </form>
</body>
</html>