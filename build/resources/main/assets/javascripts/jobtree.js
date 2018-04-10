var jobtree=function(getdatas){
	//岗位技能图谱
	var data= getdatas;
	data=eval(data);
    var jsondata={  
	"name":"岗位技能分析图",  
	"children":data
	};
	  
	var width = 1100 ;  
	var height = 1100 ;  
	  
	var tree = d3.layout.tree()  
	    .size([width, height-200])  
	    .separation(function(a, b) { return (a.parent == b.parent ? 1 : 2) });  
	  
	var diagonal = d3.svg.diagonal()  
	    .projection(function(d) { return [d.y, d.x]; });  
	  
	var 
svg = d3.select("#chart").append("svg").attr("width", width).attr(
		"height", height).append("g").attr("transform", "translate(100,0)");

d3.json("", function(error, root) {
	root = jsondata;
	var nodes = tree.nodes(root);
	var links = tree.links(nodes);

	var link = svg.selectAll(".link").data(links).enter().append("path")
			.attr("class", "link").attr("d", diagonal);

	var node = svg.selectAll(".node").data(nodes).enter().append("g").attr(
			"class", "node").attr("transform", function(d) {
		return "translate(" + d.y + "," + d.x + ")";
	})

	node.append("circle").attr("r", 1.5);

	node.append("text").attr("dx", function(d) {
		return d.children ? -8 : 8;
	}).attr("dy", 3).style("text-anchor", function(d) {
		return d.children ? "end" : "start";
	}).text(function(d) {
		return d.name;
	});
});
	
}