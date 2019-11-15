/**
 * cookies util
 */

if (typeof com == "undefined") {
    var com = {};
}
com.apicookie = {};


/**
 * 设置自定义过期时间cookie
 * time:20s 表示20秒
 * 2h 表示2小时
 *
 */

com.apicookie.setCookie = function (name, value, time) {
    var msec = com.apicookie.getMsec(time); //获取毫秒
    var exp = new Date();
    exp.setTime(exp.getTime() + msec * 1);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
};

//将字符串时间转换为毫秒,1秒=1000毫秒
com.apicookie.getMsec = function (str) {
    var timeNum = str.substring(0, str.length - 1) * 1; //时间数量
    var timeStr = str.substring(str.length - 1, str.length); //时间单位前缀，如h表示小时

    if (timeStr == "s") //20s表示20秒
    {
        return timeNum * 1000;
    } else if (timeStr == "h") //12h表示12小时
    {
        return timeNum * 60 * 60 * 1000;
    } else if (timeStr == "d") {
        return timeNum * 24 * 60 * 60 * 1000; //30d表示30天
    }
};


com.apicookie.getCookie = function (name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)"); //正则匹配
    if (arr = document.cookie.match(reg)) {
        return unescape(arr[2]);
    } else {
        return null;
    }

};

com.apicookie.delCookie = function (name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = com.apicookie.getCookie(name);
    if (cval != null) {
        document.cookie = name + "=" + encodeURIComponent(cval) + ";expires=" + exp.toGMTString();
    }
};
