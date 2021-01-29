$('#register').click(function () {

    var userName = $('#name').val();
    var passWord = $('#password').val();
    var email = $('#email').val();
    var repassWord = $('#Repassword').val();

    if (userName == null) {
        alert("用户名不能为空,请重新输入！")
    } else if (passWord == null) {
        alert("密码不能为空,请重新输入！")
    } else if (repassWord == passWord) {
        $.ajax({
            url: "/register",
            type: "post",
            data: {
                "userName": userName,
                "passWord": passWord,
                "email": email
            },
            success: function (data) {
                data = JSON.parse(data);
                if (data.code == 200) {
                    alert("注册成功")
                } else {
                    alert(data.mes)
                }
            }
        })
    } else {
        alert("两次密码输入不一致，请再次确认密码！")
    }

});

$('#login').click(function () {
    var userName = $('#username').val();
    var passWord = $('#pw').val();
    var remember = $("#remember");
    if (remember.is(":checked")) {
        status = "1";
    }
    if (userName == null) {
        alert("用户名不能为空,请重新输入！")
    } else if (passWord == null) {
        alert("密码不能为空,请重新输入！")
    } else {
        $.ajax({
            url: "/login",
            type: "post",
            data: {
                "userName": userName,
                "passWord": passWord,
                "psStatus": status
            },
            success: function (data) {
                data = JSON.parse(data);
                if (data.code == 200) {
                    window.location.href = '/loginPage.html';
                } else {
                    alert(data.mes)
                }
            }
        })
    }
});