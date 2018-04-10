function isSelectAll(obj,name) {
	var filebox = $("input[name="+name+"]");
	for ( var i = 0; i < filebox.length; i++) {
		filebox[i].checked = obj.checked;
	}
}