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


function fruit() {
	$("#mybtn").click(function() {
		
		$.ajax( {
			url : path+"bzt_all.action",
			type : "post",
			dataType : "json",
			data:'',
			async : false,
			success : function(data) {
				bread(data, '<b style="font-size: 25px;">武汉市2017年水果销售比例图</b>');
			}
		});
	});
};




function bread(Data, title) {
	
	 $('#container').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: title
        },
        tooltip: {
            pointFormat: '武汉市2017年水果销售比例图: <b>{point.percentage:.1f}%'
           
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format:  '<b style="font-size: 14px;">{point.name}</b>:<b style="font-size: 16px;">{point.percentage:.1f} %</b>'
                }
            }
        },
        credits: {
          enabled:false
		},
        series: [{
            type: 'pie',
            data: Data
        }]
    });
};