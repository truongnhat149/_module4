<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <h2 style="color: red">${message}</h2>
    <form action="/calculator">
        <input type="number" name="numberOne" value="${numberOne}" required>
        <input type="number" name="numberTwo" value="${numberTwo}" required>
        <br>
        <div>
            <input type="submit" name="calculation" value="Addition(+)">
            <input type="submit" name="calculation" value="Subtraction(-)">
            <input type="submit" name="calculation" value="Multiplication(*)">
            <input type="submit" name="calculation" value="Division(/)">
        </div>
    </form>
    <h2><strong>Result ${calcul} : ${result}</strong> </h2>
</body>
</html>