"use strict";
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
function dump(v) {
    console.log(JSON.stringify(v, null, 4));
}
// export enum ParamType {
//     NORMAL,
//     PREVIEW_RESULT
// }
// tslint:disable-next-line:no-shadowed-variable
function executeCalls(calls, funcMap) {
    var result = null;
    var _loop_1 = function (call) {
        var _a;
        var realParams = [];
        call.params.map(function (p) {
            if (p.value != null) {
                realParams.push(p.value);
            }
            else if (p._previewResult) {
                realParams.push(result);
            }
        });
        console.log("pozivam metodu: ".concat(call.method, " sa parametrima '").concat(realParams, "'"));
        if (result == null && window != null) {
            result = window;
        }
        if (call._onPreviewObj) {
            result = (_a = result[call.method]).apply.apply(_a, __spreadArray([result], realParams, false));
        }
        else {
            result = funcMap[call.method].apply(funcMap, realParams);
        }
        // context[func].apply(context, args);
        console.log("metoda vraca ", result);
    };
    for (var _i = 0, calls_1 = calls; _i < calls_1.length; _i++) {
        var call = calls_1[_i];
        _loop_1(call);
    }
}
function demo() {
    var s = "funcName";
}
var callsData = [
    {
        method: "callMe",
        params: [{
                value: "paramerar2"
            }]
    },
    {
        method: "printMe",
        params: [
            {
                _previewResult: true
            }
        ]
    }
];
var JQuery = /** @class */ (function () {
    function JQuery(id) {
        this._id = id;
    }
    JQuery.prototype.hide = function () {
        console.log("jquery hide ".concat(this._id));
    };
    return JQuery;
}());
function $(id) {
    return new JQuery(id);
}
function printMe(what) {
    var res = JSON.stringify(what, null, 4);
    console.log("printMe", res);
}
function callMe(param1) {
    console.log("I'm called with param :'".concat(param1, "'"));
    return "pero";
}
var funcMap = {
    callMe: callMe,
    printMe: printMe,
    $: $,
};
var callsJquery = [
    {
        method: "$",
        params: [{
                value: "#id2"
            }]
    },
    {
        _onPreviewObj: true,
        method: "hide",
        params: []
    }
];
executeCalls(callsJquery, funcMap);
//# sourceMappingURL=demo.js.map