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
/*// 4毫秒后继续调用本函数，这样大致可以保证实时数据*/
function get(){
    $.ajax({
        type: "post",
        url: "/add",
        data: {},
        dataType: "json",
        success: function (userData){
            if(userData != null ){
                userName = userData.name;
                userText = userData.text;
                time = (new Date()).toLocaleTimeString();
                total++;
                $("#contentBody").append("<tr align='center'><td>"+total+"</td><td>"+time+"</td><td>"+userName+"</td><td>"+userText+"</td></tr>");
                number++;
            }
        }
    });
    setTimeout("get()",4)
}

Highcharts.setOptions({
    global: {
        useUTC: false
    }
});
function activeLastPointToolip(chart) {
    var points = chart.series[0].points;
    chart.tooltip.refresh(points[points.length -1]);
}
$('#container').highcharts({
    chart: {
        type: 'spline',
        animation: Highcharts.svg,
        /*因为左边有标题，所以右边显示区域最好空一点*/
        marginRight: 10,
        /*边框宽度*/
        borderWidth: 4,
        style: {
            /*字体设置微软雅黑*/
            fontFamily: "Microsoft Yahei",
            fontSize: '20px',
            fontWeight: 'bold',
            color: '#006cee'
        },
        /*设置关于这个图标的操作，load是图表加载完成后执行*/
        events: {
            load: function () {
                var series = this.series[0],
                    chart = this;
                /*图表每1毫秒就更新一次*/
                setInterval(function () {
                    var x = (new Date()).getTime(),
                        /*在这里已经把y和number绑定了*/
                        y = number;
                    series.addPoint([x, y], true, true);
                    activeLastPointToolip(chart);
                    number = 0;
                }, 1);
            }
        }
    },
    title: {
        /*图表标题*/
        text: '五秒弹幕量'
    },
    /*副标题*/
    subtitle: {
        text: '关于斗鱼主播xxx'
    },
    xAxis: {
        type: 'datetime',
        tickPixelInterval: 100
    },
    yAxis: {
        title: {
            text: '弹幕数'
        }},
    tooltip: {
        /*数据提示框*/
        formatter: function () {
            return '<b>' + this.series.name + '</b><br/>' +
                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                /*小数点后保留0位*/
                Highcharts.numberFormat(this.y, 0)+ "条";
        }
    },
    /*图例，显示数据列的地方，比如有小明小红两个*/
    legend: {
        enabled: false
    },
    /*图表导出功能*/
    exporting: {
        enabled: false,
    },
    credits: {
        enabled: false
    },
    series: [{
        name: '弹幕数量',
        data: (function () {
            var data = [],
                time = (new Date()).getTime(),
                i;
            for (i = -19; i <= 0; i += 1) {
               data.push({
                   /*控制x轴每次跑这么长的长度*/
                    x: time + i * 5000,
                    y: 0
                });
            }
            return data;
        }())
    }]
}, function(c) {
    activeLastPointToolip(c)
});
