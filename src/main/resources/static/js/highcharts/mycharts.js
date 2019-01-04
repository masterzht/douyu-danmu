Highcharts.setOptions({
    global: {
        useUTC: false
    }
});
var userName;
var userText;
var time;
var total = 0;
var number = 0;


function get() {
    $.ajax({
        type: "post",
        url: "/addbarrage",
        data: {},
        dataType: "json",
        success: function (userData) {
            if (userData != null) {
                userName = userData.name;
                userText = userData.text;
                time = (new Date()).toLocaleTimeString();
                total++;
                $("#contentBody").prepend("<tr align='center'><td>" + total + "</td><td>" + time + "</td><td>" + userName + "</td><td>" + userText + "</td></tr>");
                number++;
            }
        }
    });
    /*不要对服务器形成太大压力，改成200ms请求一场*/
    setTimeout("get()", 200)
}




Highcharts.setOptions({
    global: {
        useUTC: false
    }
});

function activeLastPointToolip(chart) {
    var points = chart.series[0].points;
    chart.tooltip.refresh(points[points.length - 1]);
}

$('#container').highcharts({
    chart: {
        type: 'spline',
        animation: Highcharts.svg,
        marginRight: 10,
        events: {
            load: function () {
                var series = this.series[0],
                    chart = this;
                setInterval(function () {
                    var x = (new Date()).getTime(),
                        y = number;
                    series.addPoint([x, y], true, true);
                    activeLastPointToolip(chart);
                    number = 0;
                }, 2000);
            }
        }
    },
    title: {
        text: '实时弹幕量'
    },
    xAxis: {
        type: 'datetime',
        tickPixelInterval: 100
    },
    yAxis: {
        title: {
            text: '值'
        }
    },
    tooltip: {
        formatter: function () {
            return '<b>' + this.series.name + '</b><br/>' +
                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                Highcharts.numberFormat(this.y, 2);
        }
    },
    legend: {
        enabled: false
    },
    exporting: {
        enabled: false
    },
    credits: {
        enabled: false
    },
    series: [{
        name: '弹幕数',
        data: (function () {
            var data = [],
                time = (new Date()).getTime(),
                i;
            for (i = -19; i <= 0; i += 1) {
                data.push({
                    x: time + i * 5000,
                    y: 0
                });
            }
            return data;
        }())
    }]
}, function (c) {
    activeLastPointToolip(c)
});

var flag = 0;
var t1;
var text;
function refreshCount() {

    /*自己想的很垃圾，以后还是学算法吧*/
    /*弹幕长度控制一下*/
    if (text !== userText) {
        var item1 = {
            img: '/images/haha .gif', //图片
            info: text, //文字
            href: '/', //链接
            close: true, //显示关闭按钮
            speed: 12, //延迟,单位秒,默认6
            color: '#ffffff', //颜色,默认白色
            old_ie_color: '#ffffff', //ie低版兼容色,不能与网页背景相同,默认黑色
        };
        var item2 = {
            img: '/images/hh2.gif', //图片
            info: text, //文字
            href: '/', //链接
            close: true, //显示关闭按钮
            speed: 12, //延迟,单位秒,默认6
            color:'#ff6600', //颜色,默认白色
            old_ie_color:'#ff6600', //ie低版兼容色,不能与网页背景相同,默认黑色
        };
        var item3 = {
            img: '/images/hh3.gif', //图片
            info: text, //文字
            href: '/', //链接
            close: true, //显示关闭按钮
            speed: 12, //延迟,单位秒,默认6
            color:'#800080', //颜色,默认白色
            old_ie_color:'#800080', //ie低版兼容色,不能与网页背景相同,默认黑色
        };
        /*垃圾*/
        var random=Math.floor(Math.random()*3)
        if (random===0) {
            $('body').barrager(item1);
        }else if (random===1){
            $('body').barrager(item2);
        } else{
            $('body').barrager(item3);
        }


        text = userText;
    }
}
$("#but1").click(function () {
    flag++;

    /*判断点击次数的奇数偶数，偶数次不运行*/
    /*flag=1的时候，开始放弹幕小逼崽子，flag=2的时候去除定时器，flag=3的时候又开始放弹幕，正确*/
    if (flag % 2 !== 0) {
        text= "开始放弹幕喽，小逼崽子！！！";
        //循环执行，每隔200毫秒执行一次 200
        t1 = setInterval(refreshCount, 200);
        $("#but1").text('关闭弹幕');
    } else {
        //去掉定时器的方法
        clearInterval(t1);
        $("#but1").text('弹幕飞起');
    }

});