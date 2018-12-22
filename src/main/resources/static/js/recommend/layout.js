//这两行貌似有作用
//务必牢记,以后就是再不济也要用个bootstrap呀,这个纯js烦到炸!!!!!!
document.writeln('<div id="bottom_spon"></div>');
document.writeln('<div id="float_spon"></div>');
document.writeln('<div id="guide" class="wrap" style="display:none;">');
document.writeln('	<div class="guide">');
document.writeln('		<span class="pc"><a href="javascript:void(0)" onclick="gotop();" class="home" title="主页"><span>主页</span></a><a href="/s" class="top" title="搜索"><span>搜索</span></a></span>');
document.writeln('		<span class="mt"><a href="#" title="回首页" ontouchstart=""><i class="icon-home2"></i></a><a href="javascript:window.location.reload();" title="刷新" ontouchstart=""><i class="icon-refresh"></i></a><a href="javascript:void(0)" id="btnGotop" onclick="gotop();" title="回顶部"><i class="icon-top"></i></a></span>');
document.writeln('<div id="maskDiv" class="maskDiv" style="display:none;"></div>');






function getId(idName) {
	return document.getElementById(idName);
}

function getElementsByClassName(className, root, tagName){
	if (root) {
		root = typeof root == 'string' ? document.getElementById(root) : root;
	} else {
		root = document.body;
	}
		tagName = tagName || '*';
		if (document.getElementsByClassName) {
			return root.getElementsByClassName(className);
		} else {
			var tag = root.getElementsByTagName(tagName);
			var tagAll = [];
			for (var i = 0; i < tag.length; i++) {
				for (var j = 0, n = tag[i].className.split(' ') ; j < n.length; j++) {
				if (n[j] == className) {
					tagAll.push(tag[i]);
					break;
				}
			}
		}
	return tagAll;
	}
}


if(getId('movie_list')!=null){
	var posterImages = getId('movie_list').getElementsByTagName('img');
	loadImg(posterImages);
	addEvent(window,'scroll',function(){
		loadImg(posterImages);
	});
	function loadImg(arr){
		for (var i = 0, len = arr.length; i < len; i++) {
			if(arr[i].getBoundingClientRect().top > -280 && arr[i].getBoundingClientRect().top < document.documentElement.clientHeight && !arr[i].isLoad){
				arr[i].isLoad = true;
				arr[i].style.cssText = 'transition: 0; opacity: 0;';
				if(arr[i].dataset){
				aftLoadImg(arr[i],arr[i].dataset.original);  
			}else{
				aftLoadImg(arr[i],arr[i].getAttribute('data-original'));
			}
			(function(i){
				setTimeout(function(){
					arr[i].style.cssText = 'transition: 1s; opacity: 1;';
				},16)
			})(i);
			}
		}
	}
	function aftLoadImg(obj, url) {
		var oImg = new Image();
		oImg.onload = function(){
			obj.src = oImg.src;
		}
		oImg.src = url;
	}
	var sUserAgent = navigator.userAgent.toLowerCase();
	var Windows = sUserAgent.match(/windows nt/i) == "windows nt";
	if (Windows) {
		var el = document.createElement('div');
		el.className = 'play';
		var obj_lis = getId('movie_list').getElementsByTagName('a');
		for (i = 0; i < obj_lis.length; i++) {
			obj_lis[i].onmouseover = function (ev) {
				var oEvent = ev || event;
				var oFrom = oEvent.fromElement || oEvent.relatedTarget;
				if (this.contains(oFrom)) return;
				this.appendChild(el);
			};
			obj_lis[i].onmouseout = function (ev) {
				var oEvent = ev || event;
				var oTo = oEvent.toElement || oEvent.relatedTarget;
				if (this.contains(oTo)) return;
				this.removeChild(el);
			};
		}
	}
}

var sideBar = document.getElementById("guide");
addEvent(window,'scroll',function(){
	getScrollTop() > 0 ? sideBar.style.display = "": sideBar.style.display = "none";
});

function gotop(){
	var goTop = setInterval(scrollMove, 10);
	function scrollMove(){
		setScrollTop(getScrollTop() / 2);
		if (getScrollTop() < 1) clearInterval(goTop);
	}
}

function getScrollTop(){
	return document.documentElement.scrollTop + document.body.scrollTop;
}

function setScrollTop(value){
	if (document.documentElement.scrollTop){
		document.documentElement.scrollTop = value;
	}else{
		document.body.scrollTop = value;
	}
}

function addEvent(obj,type,fn){
    if(obj.attachEvent){
        obj.attachEvent('on'+type,function(){
            fn.call(obj);
        })
    }else{
        obj.addEventListener(type,fn,false);
    }
}

document.onreadystatechange = function () {
	if (document.readyState == 'complete') {
		function getImage(idName,num) {
			return document.getElementById(idName).getElementsByTagName('img')[num].clientHeight;
		}
		setTimeout(function() {
			var secs = 5;
			for(var i=secs;i>=0;i--){
				window.setTimeout('doUpdate('+i+')', (secs-i) * 1000);
			}
			//if(getId('top_spon').offsetHeight<40 || getId('bottom_spon').offsetHeight<40 || getId('floatLT').offsetHeight<40 || getId('floatRT').offsetHeight<40 || getId('floatLB').offsetHeight<40 || getId('floatRB').offsetHeight<40 || getId('slide').offsetHeight<40){
			if(getImage('floatLT',0)<10 || getImage('floatRT',0)<10 || getImage('floatLB',0)<10 || getImage('floatRB',0)<10 || getImage('slide',0)<10){
				getId('popDiv').style.display='block';
				getId('maskDiv').style.display='block';
				getId('popDiv').style.zIndex = '9999';
				getId('maskDiv').style.zIndex = '9998';
			}
		}, 500);
	}
}

function doUpdate(num){
	if(num == 0){
		getId('showDiv').innerHTML = '<a href="javascript:void(0)" onclick="closeDiv();">关闭提示</a>';
	}else{
		getId('countDown').innerHTML = num;
	}
}

function closeDiv(){
	if (getId('popDiv').style.display=='block'){
		getId('maskDiv').style.display='none';
		getId('popDiv').style.display='none';
	}else{
		getId('maskDiv').style.display='block';
		getId('popDiv').style.display='block';
	}
}

function closeFloat(){
	getId('floatLT').style.display='none';
	getId('floatRT').style.display='none';
	getId('floatLB').style.display='none';
	getId('floatRB').style.display='none';
}

function closeTips(){
	getId('checkBlock').style.display='none';
}
