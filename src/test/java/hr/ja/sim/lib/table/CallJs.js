
class Jquery {

}

let data = '{"className":"Jquery","params":["#id2"],"methods":[{"name":"hide","params":null},{"name":"show","params":["true"]}]}';
let call = JSON.parse(data);
console.table(call)
