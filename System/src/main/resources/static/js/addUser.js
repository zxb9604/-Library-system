$('#tj').click(function () {

    var userName = $('#username').val();
    var passWord = $('#password').val();
    var college = $("#college").val();
    var major = $("#major").val();
    var rxsj = $("#rxsj").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    if (userName == "") {
        alert("姓名名不能为空,请重新输入！")
    } else if (passWord == "") {
        alert("密码不能为空,请重新输入！")
    } else if (college == "") {
        alert("请选择学院！")
    } else if (major == "") {
        alert("请选择专业")
    } else if (rxsj == "") {
        alert("入学时间不能为空")
    } else {
        $.ajax({
            url: "/addUser",
            type: "post",
            data: {
                "userName": userName,
                "passWord": passWord,
                "college": college,
                "major": major,
                "rxsj": rxsj,
                "phone": phone,
                "email": email
            },
            success: function (data) {
                data = JSON.parse(data);
                if (data.code == 200) {
                    alert("添加成功！")
                } else {
                    alert(data.mes)
                }
            }
        })
    }
});
$('#username').blur(function () {
    var username = $('#username').val();
    if (username == "") {
        $('#checkname').show();
        $('#checkname').text("请输入姓名！");
        $('#username').focus();
    } else {
        $.ajax({
            url: "/checkname",
            type: "post",
            data: {
                "username": username
            },
            success: function (data) {
                console.log(data)
                data = JSON.parse(data);
                if (data.code==200){
                    debugger
                    $('#checkname').text("姓名已存在!");
                    $('#checkname').show();
                    $('#username').focus();
                }else {
                    $('#checkname').hide();
                }
            }
        });
    }
});
$('#grtj').click(function () {
    $('#myForm').show();
    $('#username').focus();
});
$('#pldr').click(function () {
    //创建一个input元素
    var inputObj = document.createElement('input')

    inputObj.setAttribute('id', '_ef');

    inputObj.setAttribute('type', 'file');

    inputObj.setAttribute("style", 'visibility:hidden');

    document.body.appendChild(inputObj);

    inputObj.click(function () {
        $.ajax({
            url:"/xsImportExcel",
            type:"get",
            data:
        });
    });
})