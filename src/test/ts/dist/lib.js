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
Object.defineProperty(exports, "__esModule", { value: true });
exports.executeCalls = exports.dump = void 0;
function dump(v) {
    console.log(JSON.stringify(v, null, 4));
}
exports.dump = dump;
// export enum ParamType {
//     NORMAL,
//     PREVIEW_RESULT
// }
function executeCalls(calls, funcMap) {
    var result;
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
        if (call._onPreviewObj) {
            if (result == null && window != null) {
                result = window;
            }
            result = (_a = result[call.method]).apply.apply(_a, __spreadArray([result], realParams, false));
            // result = result[call.method](...realParams);
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
exports.executeCalls = executeCalls;
//# sourceMappingURL=lib.js.map