$("body").keydown(function() {
    if (event.keyCode == "13") {//keyCode=13是回车键
        $('#login').click();
    }
});

$('#login').click(function() {
    const userName = $('#userName').val();
    const passWord = $('#passWord').val();
    if (userName == null || userName === '' || passWord == null || passWord === '') {
        alert("用户名和密码不能为空！");
        return;
    }

    $.ajax({
        url: "/login",
        type: "post",
        data: {
            "userName": userName,
            "password": passWord
        },
        success: function (data) {
            data=JSON.parse(data);
            if(data.code === 200)
                window.location.href='/';
            else if(data.code === 400) {
                alert(data.mes);
                $('#userName').val("");
                $('#passWord').val("");
            }
        }
    });
});