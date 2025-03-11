<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.servletContext.contextPath }/">
    <meta charset="utf-8"/>
    <title>Send email</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    ${message }
    <form action="mailer/send.htm" method="post">
        <p><input name="from" placeholder="From"></p>
        <p><input name="to" placeholder="To"></p>
        <p><input name="subject" placeholder="Subject"></p>
        <p><textarea name="body" placeholder="Body" rows="3" cols="30"></textarea></p>
        <button>Send</button>
    </form>
</div>
</body>
</html>
