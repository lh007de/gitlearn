
<html>  
<head>  
    <title>Insert title here</title>  
</head>  
<body>  
    <TABLE border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>地址</td>
        </tr>
        <#list userData as data>
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.address}</td>
            </tr>
        </#list>
    </TABLE>
</body>  
</html>  
