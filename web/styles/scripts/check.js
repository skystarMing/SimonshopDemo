/**
 * 检验登录表单
 *
 * @returns {Boolean}
 */
function checkLoginForm() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    if (username.value == "") {
        alert("用户名不能为空！");
        username.focus();
        return false;
    }
    if (password.value == "") {
        alert("密码不能为空！");
        password.focus();
        return false;
    }
    return true;
}

/**
 * 检验注册表单
 *
 * @returns {Boolean}
 */
function checkRegisterForm() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var telephone = document.getElementById("telephone");

    if (username.value == "") {
        alert("用户名不能为空！");
        username.focus();
        return false;
    }
    if (password.value == "") {
        alert("密码不能为空！");
        password.focus();
        return false;
    }

    var pattern = "/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/";
    if (!pattern.exec(telephone)) {
        alert("非法手机号！");
        telephone.focus();
        return false;
    }

    return true;
}
