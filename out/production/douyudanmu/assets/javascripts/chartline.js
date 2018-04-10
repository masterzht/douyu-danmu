 var chartline=function(getdatas){
	var jsondata1=getdatas;
	jsondata1=eval(jsondata1);
	var titlename="";
	var dataset = [];
	var lines = []; //保存折线图对象
	var date = [];
	var lineNames = []; //保存系列名称
	var lineColor = [ "#F00", "#09F", "#0F0" ];
	var w = 1200;
	var h = 600;
	var padding = 40;
	var currentLineNum = 0;
	//用一个变量存储标题和副标题的高度，如果没有标题什么的，就为0
	var head_height = padding;
	var title = titlename;
	var subTitle = "岗位数量变化曲线图";
	//用一个变量计算底部的高度，如果不是多系列，就为0
	var foot_height = padding;
	//设置数据
	getData();
	//判断是否多维数组，如果不是，则转为多维数组，这些处理是为了处理外部传递的参数设置的，现在数据标准，没什么用
	if (!(dataset[0] instanceof Array)) {
		var tempArr = [];
		tempArr.push(dataset);
		dataset = tempArr;
	}
	//保存数组长度，也就是系列的个数
	currentLineNum = dataset.length;
	//图例的预留位置
	foot_height += 25;
	//定义画布
	var svg1 = d3.select("#chart2").append("svg").attr("width", w).attr(
			"height", h);
	//添加背景
	svg1.append("g").append("rect").attr("x", 0).attr("y", 0).attr("width", w)
			.attr("height", h).style("fill", "#FFF").style("stroke-width", 2)
			.style("stroke", "#E7E7E7");
	//添加标题
	if (title != "") {
		svg1.append("g").append("text").text(title).attr("class", "title")
				.attr("x", w / 2).attr("y", head_height);
		head_height += 30;
	}
	//添加副标题
	if (subTitle != "") {
		svg1.append("g").append("text").text(subTitle)
				.attr("class", "subTitle").attr("x", w / 2).attr("y",
						head_height);
		head_height += 20;
	}
	maxdata = getMaxdata(dataset);
	//横坐标轴比例尺
	var xScale = d3.scale.linear().domain([ 0, dataset[0].length - 1 ]).range(
			[ padding, w - padding ]);
	//纵坐标轴比例尺
	var yScale = d3.scale.linear().domain([ 0, maxdata ]).range(
			[ h - foot_height, head_height ]);
	//定义横轴网格线
	var xInner = d3.svg.axis().scale(xScale).tickSize(
			-(h - head_height - foot_height), 0, 0).tickFormat("").orient(
			"bottom").ticks(dataset[0].length);
	//添加横轴网格线
	var xInnerBar = svg1.append("g").attr("class", "inner_line").attr(
			"transform", "translate(0," + (h - padding) + ")").call(xInner);
	//定义纵轴网格线
	var yInner = d3.svg.axis().scale(yScale).tickSize(-(w - padding * 2), 0, 0)
			.tickFormat("").orient("left").ticks(10);
	//添加纵轴网格线
	var yInnerBar = svg1.append("g").attr("class", "inner_line").attr(
			"transform", "translate(" + padding + ",0)").call(yInner);
	//定义横轴
	var xAxis = d3.svg.axis().scale(xScale).orient("bottom").ticks(
			dataset[0].length);
	//添加横坐标轴
	var xBar = svg1.append("g").attr("class", "axis").attr("transform",
			"translate(0," + (h - foot_height) + ")").call(xAxis);
	//通过编号获取对应的横轴标签
	xBar.selectAll("text").text(function(d) {
		return date[d];
	});
	//定义纵轴
	var yAxis = d3.svg.axis().scale(yScale).orient("left").ticks(10);
	//添加纵轴
	var yBar = svg1.append("g").attr("class", "axis").attr("transform",
			"translate(" + padding + ",0)").call(yAxis);
	//添加图例
	var legend = svg1.append("g");
	addLegend();
	//添加折线
	lines = [];
	for (i = 0; i < currentLineNum; i++) {
		var newLine = new CrystalLineObject();
		newLine.init(i);
		lines.push(newLine);
	}

	//定义折线类
	function CrystalLineObject() {
		this.group = null;
		this.path = null;
		this.oldData = [];
		this.init = function(id) {
			var arr = dataset[id];
			this.group = svg1.append("g");
			var line = d3.svg.line().x(function(d, i) {
				return xScale(i);
			}).y(function(d) {
				return yScale(d);
			});
			//添加折线
			this.path = this.group.append("path").attr("d", line(arr)).style(
					"fill", "none").style("stroke-width", 1).style("stroke",
					lineColor[id]).style("stroke-opacity", 0.9);
			//添加系列的小圆点
			this.group.selectAll("circle").data(arr).enter().append("circle")
					.attr("cx", function(d, i) {
						return xScale(i);
					}).attr("cy", function(d) {
						return yScale(d);
					}).attr("r", 5).attr("fill", lineColor[id]);
			this.oldData = arr;
		};
	}
	//添加图例
	function addLegend() {
		var textGroup = legend.selectAll("text").data(lineNames);
		textGroup.exit().remove();
		legend.selectAll("text").data(lineNames).enter().append("text").text(
				function(d) {
					return d;
				}).attr("class", "legend").attr("x", function(d, i) {
			return i * 100;
		}).attr("y", 0).attr("fill", function(d, i) {
			return lineColor[i];
		});
		var rectGroup = legend.selectAll("rect").data(lineNames);
		rectGroup.exit().remove();
		legend.selectAll("rect").data(lineNames).enter().append("rect").attr(
				"x", function(d, i) {
					return i * 100 - 20;
				}).attr("y", -10).attr("width", 12).attr("height", 12).attr(
				"fill", function(d, i) {
					return lineColor[i];
				});
		legend.attr("transform", "translate("
				+ ((w - lineNames.length * 100) / 2) + "," + (h - 10) + ")");
	}
	//数据
	function getData() {
		
		var datasets=new Array();
		var dates=new Array();
		var jsondatas=jsondata1;
		for(i=0;i<jsondatas.length;i++){
			var date1=jsondatas[i].date;
			var dataset1=jsondatas[i].dataset;
			dates.push(date1);
			datasets.push(dataset1);
		}
		dataset=datasets;
		date=dates;
		console.log(dataset);
		console.log(date);
		lineNames = [ "岗位数量" ];	
	}

	//取得多维数组最大值
	function getMaxdata(arr) {
		maxdata = 0;
		for (i = 0; i < arr.length; i++) {
			maxdata = d3.max([ maxdata, d3.max(arr[i]) ]);
		}
		return maxdata;
	}
	
}//chartline