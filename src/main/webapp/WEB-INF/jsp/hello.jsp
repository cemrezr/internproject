<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Hello world:</title>
</head>

<h2>${message}</h2>
<body>
<script>

</script>

    <table border=1>
        <tr>
        <th>id</th>
    <th>name</th>
            <th>description</th>
            <th>slogan</th>
    </tr>
    <tr>
    <td></td>
    <td>${companies[0].name}</td>
        <td>Satır 2, Hücre 3</td>
        <td>Satır 2, Hücre 4</td>
    </tr>
    <tr>
    <td></td>
    <td>${companies[1].name}</td>
        <td>Satır 3, Hücre 3</td>
        <td>Satır 3, Hücre 4</td>
    </tr>
    <tr>
    <td></td>
    <td>${companies[2].name}</td>
        <td>Satır 4, Hücre 3</td>
        <td>Satır 4, Hücre 4</td>
    </tr>
        <tr>
            <td></td>
            <td>${companies[3].name}</td>
            <td>Satır 5, Hücre 3</td>
            <td>Satır 5, Hücre 4</td>
        </tr>
    </table>





</body>
</html>