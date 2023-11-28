<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="bg-gray-100 p-4">
  <button type="button" class="btn btn-outline-secondary" id="b-write">글쓰기</button>
  <div class="container">
      <table class="table table-hover table-striped" style="border:1px solid;">
          <thead>
              <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>조회수</th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td>1</td>
                  <td>title</td>
                  <td>pororo</td>
                  <td>1</td>
              </tr>
              <tr>
                  <td>2</td>
                  <td>title</td>
                  <td>pororo</td>
                  <td>1</td>
              </tr>
              <tr>
                  <td>3</td>
                  <td>title</td>
                  <td>pororo</td>
                  <td>1</td>
              </tr>
          </tbody>
      </table>
  </div>
  <!-- Include the Bootstrap JavaScript libraries -->
  <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI/tfW5fBzl9Xl3+yCPT2sA5dz/TdSHuP2zWeqFU=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
