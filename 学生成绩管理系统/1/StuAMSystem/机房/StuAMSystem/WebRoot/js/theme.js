$(".left_nav li .t i").click(function(){
	$(this).parent(".t").toggleClass("hover");
	$(this).parent(".t").next(".txt").slideToggle()
})


var sl=$(".left_nav li").length;
if(sl>6){
	$(".left_nav li").each(function(index){
		if(index>5){
			$(this).hide(0)
		}
	})
	$(".left_nav .more").show()
}else{
	$(".left_nav .more").hide()
}

function opene(){
	$(".left_nav li").each(function(index){
		if(index>5){
			$(this).slideToggle(300);
			$(this).find(".t").removeClass("hover");
			$(this).find(".txt").slideUp();
		}
	})
}

$(".left_nav .more").click(function() {
	opene();
	$(this).toggleClass("hover");
	var text=$(this).find("span").text();
	if(text=="展开"){
		$(this).find("span").text("收起");
	}else if(text=="收起"){
        $(this).find("span").text("展开");
	}
});

if($("div").hasClass("owl-carousel")){
	$('#scroll').owlCarousel({
		items:4,
		autoPlay:false,
		navigation:true,
		navigationText: ["",""],
		scrollPerPage:false
	});
}

$(".details_box ul li .more").hover(function(){
	$(this).next(".txt").fadeIn()
},function(){
	$(this).next(".txt").fadeOut()
});

