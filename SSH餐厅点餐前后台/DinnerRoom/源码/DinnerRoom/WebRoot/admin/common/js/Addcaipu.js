function check() {
	var mname = $("#mname").val();
	var mPrice = $("#mprice").val();
	var typeid = $("#typeid").val();
	var image_path = $("#image_path").val();
	var regprice = /^[0-9]*$/;
	if (!mname) {
		layer.msg('请输入菜名');
		return false;
	} else if (!mPrice) {
		layer.msg('请输入价格');
		return false;
	} else if (!regprice.test(mPrice)) {
		layer.msg('价格为数字');
		return false;
	} else if (typeid == -1) {
		layer.msg('请选择菜肴种类');
		return false;
	} else if (!image_path) {
		layer.msg('请选择图片');
		return false;
	} else {
		return true;
	}
}
$(function() {
	$("#btn").click(function() {
		var menuid = $("#menuid").val();
		if (menuid == "") {
			if (!check()) {
				return;
			}
			$("#frm").attr("action", "addMenu");
			$("#frm").submit();
		} else {
			if (!check()) {
				return;
			}
			$("#frm").attr("action", "updateMenuInfo");
			$("#frm").submit();
		}
	});
});
layui.use('form', function() {
	var form = layui.form;
});
// 照片预览
function handleFiles(obj) {
	var str = "common/icon/image.png";
	var files = obj.files;
	var path = window.URL.createObjectURL(files[0]);
	var fileName = files[0].name;
	var exstart = fileName.lastIndexOf(".");
	var ext = fileName.substring(exstart, fileName.length).toUpperCase();// 后缀名
	if (ext == ".PNG" || ext == ".JPG" || ext == ".JPEG" || ext == ".GIF") {
		$("#images").attr("src", path);
	} else {
		$("#images").attr("src", str);
		var file = $("#image_path");
		file.after(file.clone().val(""));
		file.remove();
		layer.msg("请上传图片");
	}

}