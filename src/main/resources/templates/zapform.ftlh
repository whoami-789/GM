<!DOCTYPE html>
<html>
<head>
    <title>Запись на обследование</title>
</head>
<body>
<h1>Заполните данные о себе</h1>

<form action="/zapis/zapform/save" method="post" enctype="multipart/form-data">
    Имя: <input type="text" name="name"/><br><br>
    Фамилия: <input type="text" name="surname"/><br><br>
    Дата рождения: <input type="date" name="bdate"/><br><br>
    Номер телефона: <input type="text" name="phoneNumber"/><br><br>
    Email: <input type="email" name="email"/><br><br>
    Дата прохождения обследования: <input type="date" name="date"/><br><br>
    Время прохождения обследования: <input type="time" name="time"/><br><br>
<#--
    <input type="hidden" name="_csrf" value="${_csrf.token}">
-->
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>