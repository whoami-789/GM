<!Doctype html>
<html>
<head>
    <title>Gull Med</title>
</head>
<body>
    <h1>Записаться</h1>
    <hr>
        <#--<#if user.email??>
            <h3> Имя пользователя: <i>${user.name}</i></h3>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Выйти"/>
            </form>
            <#if user.isAdmin()>
                <a href="/admin">Панель администратора</a>
            </#if>
        <#else>
            <a href="/login">Войти</a></h1>
        </#if>-->
    <hr>
<h4>Записаться на прием</h4>
    <form action="/" method="get">
        Поиск варианта обследования: <input type="text" name="title">
                                     <input type="submit" value="Поиск">
    </form>
    <#list catname as category>
        <div>
            <p><b>${category.title}</b> ${category.price} сум. | <a href="/zapis/zapform">Записаться</a></p>
        </div>
    </#list>
</form>
</body>
</html>