if (typeof com == "undefined") {
    var com = {};
}
com.util = {};

//获取url参数  decodeURI解决中文乱码  unescape 不支持中文 改为 decodeURI
com.util.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    return null;
};


com.util.timestampToTime = function (timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = date.getDate() + ' ';
    var h = date.getHours() + ':';
    var m = date.getMinutes() + ':';
    var s = date.getSeconds();
    return Y + M + D + h + m + s;
};

com.util.timestampToDate = function (timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = date.getDate();
    return Y + M + D;
};

com.util.timestampToDayTime = function (timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var D = date.getDate() + '日 ';
    var h = date.getHours() + ':';
    var m = date.getMinutes() + ':';
    var s = date.getSeconds();
    return D + h + m + s;
};


com.util.isEmpty = function (str) {

    var rtnStr = com.util.dataToHtmlString(str);
    if (rtnStr == "") {
        return true;
    }
    return false;
};

//去掉NULL
com.util.dataToHtmlString = function (dbString) {
    if (dbString == "&nbsp;") {
        return "";
    }
    if (dbString == "null") {
        return "";
    }
    if (dbString == undefined) {
        return "";
    }

    return dbString;
};

//去掉NULL(TABLE)
com.util.dataToHtmlStringNbsp = function (dbString) {
    if (dbString == "null") {
        return "&nbsp;";
    }
    if (dbString == undefined) {
        return "&nbsp;";
    }

    return dbString;
};

//去掉空格
com.util.stringtrim = function (str) {
    var resStr;
    resStr = str.replace(/\s/gi, "");
    resStr = resStr.replace("&nbsp;", "");
    return resStr;
};

com.util.formatStr = function (str, len) {
    var tmp = "";
    for (var i = 0; i < len - str.length; i++) {
        tmp += '0';
    }
    return tmp + str;
};


//检查数据格式
com.util.checkDataFormat = function (datafmt) {
    //去掉前后空格
    var str = datafmt.replace(/(^\s*)|(\s*$)/g, "");

    if ((datafmt == "null") || (datafmt == null) || (datafmt == "undefined") || (datafmt == "")) {
        return 0;
    }

    if (str.indexOf(".") == -1) {
        return 0;
    }

    //查找小数点
    return (str.length - str.indexOf(".") - 1);

};

/**
 *
 * @param srcStr
 * @param nAfterDot
 * @returns {*}
 * @constructor
 *
 */
com.util.FormatNumberDotLen = function (srcStr, nAfterDot) {

    var resultStr, nTen;
    srcStr = '' + srcStr;

    if (srcStr == null || srcStr == "null" || srcStr == "") {
        return "";
    }

    resultStr = srcStr;
    srcStr = com.util.dataToHtmlString(srcStr);

    srcStr = "" + srcStr + "";
    strLen = srcStr.length;
    dotPos = srcStr.indexOf(".", 0);

    if (dotPos == 0) {
        resultStr = "0.";
        for (var i = 0; i < nAfterDot; i++) {
            resultStr = resultStr + "0";
        }
        return resultStr;
    } else if (dotPos == -1) {
        resultStr = srcStr + ".";
        for (i = 0; i < nAfterDot; i++) {
            resultStr = resultStr + "0";
        }
        return resultStr;
    } else {
        if ((strLen - dotPos - 1) > nAfterDot) {
            nAfter = dotPos + nAfterDot + 1;
            nTen = 1;
            for (j = 0; j < nAfterDot; j++) {
                nTen = nTen * 10;
            }
            resultStr = Math.round(parseFloat(srcStr) * nTen) / nTen;

            resultStr = com.util.FormatNumberDotLen(resultStr, nAfterDot);
            return resultStr;
        } else if ((strLen - dotPos - 1) == nAfterDot) {
            return resultStr;
        } else {
            resultStr = srcStr;
            for (i = 0; i < (nAfterDot - strLen + dotPos + 1); i++) {
                resultStr = resultStr + "0";
            }
            return resultStr;
        }
    }
};


//反序
com.util.reorderByByte = function (str, bytelen) {
    var param = str;
    var pre = "";
    for (var i = 0; i < bytelen * 2 - str.length; i++) {
        pre += "0";
    }
    param = pre + param;
    param = param.substr(0, bytelen * 2);

    var reorder = "";
    for (var j = 0; j < bytelen; j++) {
        reorder += param.substr(bytelen * 2 - 2 * (j + 1), 2);
    }
    return reorder;

};


