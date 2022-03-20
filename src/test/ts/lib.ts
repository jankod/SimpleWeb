export function dump(v: any) {
    console.log(JSON.stringify(v, null, 4));
}


export interface Call {
    _onPreviewObj?: boolean;
    method: string
    params: Param[]
}

export interface Param {
    _previewResult?: boolean,
    value?: string
}

// export enum ParamType {
//     NORMAL,
//     PREVIEW_RESULT
// }

export function executeCalls(calls: Call[], funcMap: { [K: string]: (...params: any) => void }) {
    let result: any;
    for (const call of calls) {
        const realParams: string[] = [];

        call.params.map(p => {
            if (p.value != null) {
                realParams.push(p.value)
            } else if (p._previewResult) {
                realParams.push(result);
            }
        })
        console.log(`pozivam metodu: ${call.method} sa parametrima '${realParams}'`)
        if (call._onPreviewObj) {
            if(result == null && window != null) {
                result = window;
            }
            result = result[call.method].apply(result, ...realParams);
            // result = result[call.method](...realParams);
        } else {
            result = funcMap[call.method](...realParams);
        }
        // context[func].apply(context, args);
        console.log(`metoda vraca `, result)
    }
}
