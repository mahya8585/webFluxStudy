$(document).ready(function() {
    $("button#sendFile").click(function () {
        // フォームデータを取得
        let formData = new FormData($('#dataForm').get(0));
        let url = "http://" + location.hostname +"/sendVoice";
        console.log(url);

        // POSTでアップロード
        $.ajax({
            url  : url,
            type : "POST",
            data : formData,
            cache       : false,
            contentType : false,
            processData : false,
            dataType    : "html"
        })
        .done(function(data, textStatus, jqXHR){
            console.log("post message.");

            messages = JSON.parse(data);
            console.log(messages[0]);
            $("<tr>"
            + "<td>[ajax]" + messages[0].message + "</td>"
            + "</tr>").prependTo("#messages");
        })
        .fail(function(jqXHR, textStatus, errorThrown){
            console.log("fail")
        });
    });
});
