function dump(v: any) {
    console.log(JSON.stringify(v, null, 4));
}


interface Call {
    _onPreviewObj?: boolean;
    method: string
    params: Param[]
}

interface Param {
    _previewResult?: boolean, // take the previous result
    value?: string
}

// export enum ParamType {
//     NORMAL,
//     PREVIEW_RESULT
// }

// tslint:disable-next-line:no-shadowed-variable
function executeCalls(calls: Call[], funcMap: { [K: string]: (...params: any) => void }) {
    let result: any = null;
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

        if (result == null && window != null) {
            result = window;
        }

        if (call._onPreviewObj) {
            result = result[call.method].apply(result, ...realParams);
        } else {
            result = funcMap[call.method](...realParams);
        }
        // context[func].apply(context, args);
        console.log(`metoda vraca `, result)
    }
}

function demo() {
   const s = "funcName";
}


const callsData: Call[] = [
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


class JQuery {
    private readonly _id: string;

    constructor(id: string) {
        this._id = id;
    }

    public hide() {
        console.log(`jquery hide ${this._id}`)
    }
}

function $(id: string) {
    return new JQuery(id);
}


function printMe(what: any) {
    const res = JSON.stringify(what, null, 4)
    console.log("printMe", res)
}


function callMe(param1: string): string {
    console.log(`I'm called with param :'${param1}'`)
    return "pero";
}

const funcMap: { [K: string]: (...params: any) => void } = {
    callMe,
    printMe,
    $,
}


const callsJquery: Call[] = [
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


executeCalls(callsJquery, funcMap)
