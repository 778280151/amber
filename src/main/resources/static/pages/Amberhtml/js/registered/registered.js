// function registered_jiaoyan() {
//     var kk = emailjiaoyan(obj);
//     return kk;
// }


function emailjiaoyan(obj) { //邮箱正则校验
    var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
    if (obj == "") { //输入不能为空
        alert("输入不能为空!");
        return false;
    } else if (!reg.test(obj)) { //正则验证不通过，格式不对
        alert("验证不通过!");
        return false;
    } else {
        // alert("通过！");
        return true;
    }
}

function jiaoyanall(pwd,rpwd,code) {
    alert(pwd+rpwd+code);
    if (pwd.length>0 && rpwd.length>0 && code.length>0) {
        if (pwd == rpwd) {
            if(pwd.length>=6&&pwd.length<=15){
                alert("验证成功");
                return true;
            }else {
                alert("请设置6-15位长度密码");
                return false;
            }
        } else {
            alert("密码不一致，请重新填写");
            return false;
        }
    } else {
        alert("请填写完整信息");
        return false;
    }

}