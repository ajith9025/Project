<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exam Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            margin: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        select {
            width: 25%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 5px 10px;
            background-color: #838398;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Online Exam</h2>
    <form action="QuestionServlet" method="get">
        <label for="language">Exam Name:</label>
        <select id="language" name="language">
            <option>All Question</option>
            <option>Java</option>
            <option>HTML</option>
            <option>CSS</option>
            <option>Python</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
