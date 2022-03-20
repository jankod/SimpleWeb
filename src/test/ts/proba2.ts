class OneTrust {
    initializeCookiePolicyHtml() {
        console.log("called initializeCookiePolicyHtml()");
    }
}

let oneTrust = new OneTrust();
const methodName = "initializeCookiePolicyHtml";
oneTrust[methodName].apply(oneTrust);
