/**
 * Created by masterzht on 2018/4/11.
 */
myChart=echarts.init(document.getElementById('main'));//获取容器
option = {
    title : {
        text: '斗鱼房间分析',
        subtext: '斗鱼房间分析'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['在线热度值', '预购队列']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    dataZoom : {
        show : false,
        start : 0,
        end : 100
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : true,
            data : (function (){
                var now = new Date();
                var res = [];
                var len = 10;
                while (len--) {
                    res.unshift(now.toLocaleTimeString().replace(/^\D*/,''));
                    now = new Date(now - 2000);
                }
                return res;
            })()
        },
        {
            type : 'category',
            boundaryGap : true,
            data : (function (){
                var res = [];
                var len = 10;
                while (len--) {
                    res.push(len + 1);
                }
                return res;
            })()
        }
    ],
    yAxis : [
        {
            type : 'value',
            scale: true,
            name : '热度',
            boundaryGap: [0.2, 0.2]
        },
        {
            type : 'value',
            scale: true,
            name : '预购量',
            boundaryGap: [0.2, 0.2]
        }
    ],
    series : [
        {
            name:'预购队列',
            type:'bar',
            xAxisIndex: 1,
            yAxisIndex: 1,
            data:(function (){
                var res = [];
                var len = 10;
                while (len--) {
                    res.push(Math.round(Math.random() * 1000));
                }
                return res;
            })()
        },
        {
            name:'最新成交价',
            type:'line',
            data:(function (){
                var res = [];
                var len = 10;
                while (len--) {
                    res.push((Math.random()*10 + 5).toFixed(1) - 0);
                }
                return res;
            })()
        }
    ]
};
var lastData = 11;
var axisData;
clearInterval(timeTicket);
timeTicket = setInterval(function (){
    lastData += Math.random() * ((Math.round(Math.random() * 10) % 2) == 0 ? 1 : -1);
    lastData = lastData.toFixed(1) - 0;
    axisData = (new Date()).toLocaleTimeString().replace(/^\D*/,'');

    // 动态数据接口 addData
    myChart.addData([
        [
            0,        // 系列索引
            /*Math.round(Math.random() * 1000), // 新增数据*/
            hn,
            true,     // 新增数据是否从队列头部插入
            false     // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
        ],
        [
            1,        // 系列索引
            /*lastData, // 新增数据*/
            fans_num,
            false,    // 新增数据是否从队列头部插入
            false,    // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
            axisData  // 坐标轴标签
        ]
    ]);
}, 2100);

myChart.setOption(option);

