function initIframeHeight(height) {
		var userAgent = navigator.userAgent;
		var iframe = parent.document.getElementById("main");
		var subdoc = iframe.contentDocument || iframe.contentWindow.document;
		var subbody = subdoc.body;
		var realHeight;
		//谷歌浏览器特殊处理
		if (userAgent.indexOf("Chrome") > -1) {
			realHeight = subdoc.documentElement.scrollHeight;
		} else {
			realHeight = subbody.scrollHeight;
		}
		if (realHeight < height) {
			$(iframe).height(height);
		} else {
			$(iframe).height(realHeight);
		}
	}
	function ShowMain(url) {
		$("#main").removeAttr("src");
		$("#main").attr("src", url);
	}
	$(function() {
		$("#navbar-menu li").click(function() {
			$("#navbar-menu li").removeClass("active");
			$(this).removeClass("active");
			$(this).addClass("active");
		});

	});