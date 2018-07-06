var progress = $(".progress");
function pshow(){progress.removeClass("hide");}
function phide(){progress.addClass("hide");}
function comm(url,data,success,fail){
    $.ajax({
        url:url,
        type:"post",
        data:data,
        dataType:"json"
    }).done(success).fail(fail);
}

function createOption(dataOption,select){
    var op = document.createElement("option");
    op.value = dataOption.value;
    op.innerHTML=dataOption.innerText;
    if(dataOption.selected)op.selected=true;
    select.appendChild(op);
}

function getEscola(elm){
    pshow();
    comm("sendParameters",{
        tipo:"escolas"

    },function (response) {
        elm.innerHTML="<option value=\"\"  disabled selected>Selecione...</option>";
        for(var i =0;i<response.length;i++){
            createOption({innerText:response[i][0],value:response[i][0],selected:false},elm);
        }
        elm.disabled=false;
        $(elm).formSelect();
        $(elm).on('change',function(){getAno($("[data-filter=ano]")[0],$(this).val());});
        phide();
    },function (response) {
        console.log(response);
    });
}
function getAno(elm,escola){
    pshow();
    comm("sendParameters",{
        tipo:"anos",
        escola:escola
    },function (response) {
        elm.innerHTML="<option value=\"\"  disabled selected>Selecione...</option>";
        for(var i =0;i<response.length;i++){
            createOption({innerText:response[i][0],value:response[i][0],selected:false},elm);
        }
        elm.disabled=false;
        $(elm).formSelect();
        $(elm).on('change',function(){getTurmas($("[data-filter=turma]")[0],escola,$(this).val());});
        phide();
    },function (response) {
        console.log(response);
    });
}
function getTurmas(elm,escola,ano){
    pshow();
    comm("sendParameters",{
        tipo:"turmas",
        escola:escola,
        ano:ano
    },function (response) {
        elm.innerHTML="<option value=\"\"  disabled selected>Selecione...</option>";
        for(var i =0;i<response.length;i++){
            createOption({innerText:response[i][0],value:response[i][0],selected:false},elm);
        }
        elm.disabled=false;
        $(elm).formSelect();
        phide();
    },function (response) {
        console.log(response);
    });
}

getEscola($("[data-filter=escola]")[0]);