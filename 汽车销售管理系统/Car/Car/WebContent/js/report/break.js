var path="";
$(function(){
	path=$("#path").val();
	init();
	
	fruit();
});

function init(){
	Highcharts.setOptions({
            lang: {
               　			  printChart:"打印图表",
                  downloadJPEG: "下载JPEG 图片" , 
                  downloadPDF: "下载PDF文档"  ,
                  downloadPNG: "下载PNG 图片"  ,
                  downloadSVG: "下载SVG 矢量图" , 
                  exportButtonTitle: "导出图片" 
            }
        });
};

//加载的方法

function fruit() {
	
	$("#mybtn").click(function() {

	 
	 		
	 		$.ajax( {
			url : path+"zxt_all.action",
			type : "post",
			data:'',
			dataType : "json",
			async : true,
			success : function(data) {
				botao(data, '<b style="font-size: 25px;">红安一中在校人数</b>');
			}
		});
	});
};

function botao(data,title){
	  
	    $('#container').highcharts({
        title: {
            text: title,
            x: -20 //center
        },
        subtitle: {
            x: -20
        },
        xAxis: {
             categories:data[0]
        },
        yAxis: {
            title: {
                text: '人数'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '￥'
        },
        credits: {
          enabled:false
		},
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
         series: data[1] 
    });
	  
};
