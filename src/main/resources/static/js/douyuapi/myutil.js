$(function () {
    /*这些都是混淆代码,实在是没办法*/
    var param=$("#titleya").text();
    if (param!="all"){
        var url="http://localhost/api/RoomApi/live/"+param;
    }else{
        var url="http://localhost/api/RoomApi/live/1";
    }
    $.ajax({
        type: "get",
        url: url,
        data: {},
        dataType: "json",
        success: function (result) {

            addBox(result);
        }
    });
});

function addBox(result) {

    host = "http://localhost:8080/search?roomid=";

    //是一个数组,所以需要先遍历
    $.each(result.data, function (index, obj) {
        $("#box1").append(
            "<li><a target='_blank' href=" + host + obj.room_id + ">" +
            "<img src=" +
            obj.room_src + " " +
            "data-original=" +
            obj.room_src + " " +
            "alt=" +
            obj.room_name + " " +
            "style='transition: all 1s ease 0s; opacity: 1;'>" +
            "<h2>" + obj.room_name +
            "</h2><i>在线热度值:" +
            obj.hn + "</i></a>" +
            "</li>");


        if (index < 10) {
            $("#box2").append(
                "<dd>" +
                "<a target='_blank' href=" + host + obj.room_id + ">" +
                "<em>" + ++index + "</em>" +
                "<span>" +"在线"+ obj.online + "</span>" +
                "<h2>" + obj.nickname + "</h2>"+"</a>"+
                "</dd>"
            );

            $("#box3").append(
                "<dd>" +
                "<a target='_blank' href=" + host + obj.room_id + ">" +
                "<em>" + index + "</em>" +
                "<span>" +"在线"+ obj.online + "</span>" +
                "<h2>" + obj.nickname + "</h2>"+"</a>"+
                "</dd>"
            );
        }


       /* var url=window.location.href;
       alert(str.split("http://localhost:8080/category/")[1]);*/
    });
}

