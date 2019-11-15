if (typeof com == "undefined") {
    var com = {};
}
com.ident = {};

com.ident.apiGetLogin = function(loginName, loginPwd, callback, errback) {

    var loginURL = com.domain.apiBaseUrl + "/shop/api/auth/login/" + loginName + "/" + loginPwd;
    jQuery.support.cors = true; //浏览器有关，有些需要，有些不需要
    $.showLoading("正在加载...");
    $.ajax({
        type: 'get',
        url: loginURL,
        dataType: "json",
        crossDomain: true,//有些需要，有些不需要
        xhrFields: {
            withCredentials: true//cookie参数
        },
        data: {},
        success: function (result) {
            $.hideLoading();
            if (result != null && result.errCode == 200) {
                if (typeof callback == 'function') {

                    callback(result.data);
                }
            } else {
                if (typeof errback == 'function') {

                    errback(result);
                }
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $.hideLoading();
            alert("登录失败，请重新登录");
        }
    });


};


com.ident.apiPostLogin = function(loginName, loginPwd, callback, errback) {

    var loginURL = com.domain.apiBaseUrl + "/shop/api/auth/login";
    jQuery.support.cors = true; //浏览器有关，有些需要，有些不需要
    $.showLoading("正在加载...");
    $.ajax({
        type: 'POST',
        url: loginURL,
        dataType: "json",
        crossDomain: true,//有些需要，有些不需要
        xhrFields: {
            withCredentials: true//cookie参数
        },
        data: {"username":　loginName, "password": loginPwd},
        success: function (result) {
            $.hideLoading();
            if (result != null && result.errCode == 200) {
                if (typeof callback == 'function') {
                    callback(result.data);
                }
            } else {
                if (typeof errback == 'function') {
                    errback(result);
                }
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $.hideLoading();
            alert("登录失败，请重新登录");
        }
    });


};