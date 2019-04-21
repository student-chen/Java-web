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
		var s1=$("#sort1 option:selected").text();
		var s2=$("#sort2 option:selected").text();
		var sid1=$("#sort1").val();
		var sid2=$("#sort2").val();
		var year=$("#year").val();
		if(sid1==0){
			layer.tips('请选择！', $("#sort1"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if(sid2==0){
			layer.tips('请选择！', $("#sort2"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if(year.length==0){
			layer.tips('请输入年份！', $("#year"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax( {
			url : path+"outcar.do?method=biao",
			type : "post",
			data:{s1:s1,s2:s2,sid1:sid1,sid2:sid2,year:year},
			dataType : "json",
			async : true,
			success : function(data) {
				botao(data, '<b style="font-size: 25px;">汽车月度销量比例图</b>');
			}
		});
			
		
	});
};



function botao(data,title){
	
	  $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: title
        },
        subtitle: {
            text: ''
        },
        xAxis: {
        	//类别
            categories:data[0],
        	crosshair : true
        },
        yAxis: {
            min: 0,
            title: {
                text: '数量'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table style="width: 130px;">',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 辆</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        credits: {
          enabled:false
		},
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: data[1] 
    });
};
