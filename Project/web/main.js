//Helpers
function comm(url,data,success,fail){
    $.ajax({
        url:url,
        type:"post",
        data:data,
        dataType:"json"
    }).done(success).fail(fail);
}

function getEscola(){
    comm("sendParameters",{
        tipo:"escola"
    },function (response) {
        console.log(response)
    },function (response) {
        console.log(response);
    });
}
function getAno(escola){
    comm("sendParameters",{
        tipo:"ano",
        escola:escola
    },function (response) {
        console.log(response)
    },function (response) {
        console.log(response);
    });
}
function getTurmas(escola,ano){
    comm("sendParameters",{
        tipo:"turmas",
        escola:escola,
        ano:ano
    },function (response) {
        console.log(response)
    },function (response) {
        console.log(response);
    });
}