//document.writeln('<script type="text/javascript" src="/js/slide.js" charset="gb2312"></script>');

var playerWidth = document.body.clientWidth;
if(playerWidth>980){
	var xWidth = 980;
	var xHeight = 500;
}else{
	var xWidth = playerWidth-16;
	var xHeight = playerWidth/1.5;
}

var getUserAgent = navigator.userAgent;
if (getUserAgent.indexOf('Mobile') > -1 && getUserAgent.indexOf('UCBrowser') > -1) {
	alert('检测到您使用UC手机浏览器，请使用其他手机浏览器访问。推荐使用谷歌Chrome浏览器。');
	window.location.href="/set/index.html";
}

function killErrors(){return true;}window.onerror=killErrors;

var webname = "xx";
var domain = document.domain;
var arydomain = new Array(".com.cn",".com",".cn",".net",".cc",".org",".info",".biz",".tv"); 
var tmpdomain = "";
for(var i=0;i<arydomain.length; i++){
	tmpdomain = arydomain[i];
	if(domain.indexOf(tmpdomain) != -1){
		domain = domain.replace(tmpdomain,"");
		domain = domain.substring(domain.lastIndexOf(".")+1,domain.length);
		domain = domain + tmpdomain;
		domain = domain.toUpperCase();
		break;
	}
}

/* 漂浮 */
var floatLT_set = false; //左上角广告开关(true开 false关)
var floatRT_set = false; //右上角广告开关(true开 false关)
var floatLB_set = false; //左下角广告开关(true开 false关)
var floatRB_set = false; //右下角广告开关(true开 false关)
var floatLT_url = "https://www.010bjldc.com/?Agent=pagzgg1029"; //左上角网址
var floatLT_img = "http://wx4.sinaimg.cn/mw1024/006uTMssgy1fj79jhy59dg302s06yn7d.gif"; //左上角图片
var floatRT_url = "https://www.pjwdy.com/21428633.htm"; //右上角网址
var floatRT_img = "http://wx2.sinaimg.cn/large/006JJRWygy1flpjp12z9hg303c08cdke.gif"; //右上角图片
var floatLB_url = "http://www.hgw1558.com/"; //左下角广告网址
var floatLB_img = "http://www.adm-cnzz.net/material/36/12388/b/2016/hg200x200.gif"; //左下角广告图片
var floatRB_url = "http://www.tyc6658.com/"; //右下角广告网址
var floatRB_img = "http://www.adm-cnzz.net/material/36/12388/b/2016/tyc230x210.gif"; //右下角广告图片
//以下播放器广告暂时别动
var player_set = false; //播放器广告开关(true开 false关)
var player_img = "/img/buffer1.jpg"; //播放器广告图片
var player_url = "http://www.baidu.com"; //播放器广告链接

/* 头部横幅广告  格式：【链接|图片】 */
var top_spon=[
];

/* 底部横幅广告  格式：【链接|图片】 */
var bottom_spon=[

];

/* 文字列表广告  格式：【链接|文字|颜色】 颜色表：【红色：FF0000  蓝色：0000FF  紫色：FF00FF  绿色：009900】 */
var text_spon=[
//"http://www.domain.com|文字消息|#DD3E7F",
];

var date = new Date();
var y = date.getFullYear();
var m = date.getMonth()+1;
var d = date.getDate();
if(m<10) m = "0"+m;
if(d<10) d = "0"+d;
ymd = y+"-"+m+"-"+d;
md = m+"-"+d;

function getId(idName) {
	return document.getElementById(idName);
}