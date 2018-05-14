//Helpers
function comm(url,data,success,fail){
    $.ajax({
        url:url,
        type:"post",
        data:data
    }).done(success).fail(fail);
}

function getSessionData(){
    comm("parametersTest",{},function (response) {
        console.log(response)
    },function (response) {
        console.log(response);
    });
}