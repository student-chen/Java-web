function TClientCheck() {
            this.userAgent=navigator.userAgent;
            this.getBrowse=TClientCheck_Browse;
            this.getOS=TClientCheck_OS;
            this.browseKernel="unknown";
            this.isDOMSupport=false;//是否支持DOM
            if(document.getElementById) {
                this.isDOMSupport=true;
            }
        }
        /**
         * 浏览器信息检测
         *
         * @类型：公共方法
         * @参数：无
         * @返回：浏览器名称
         * @作者：[BI]CJJ http://www.imcjj.com
         * @时间：2006-11-7 Last update at 2006-11-8
         * @备注：
         */
        function TClientCheck_Browse() {
            var sUA=this.userAgent;
            //检测IE浏览器
            if ((navigator.appName == "Microsoft Internet Explorer")) {
                //检测模拟IE浏览的OPERA。edit at 2006-11-08(ver 0.1.2)
                if (sUA.indexOf('Opera')!=-1) {
                    this.browseKernel='Presto';
                    if(window.opera && document.childNodes ) {
                        return 'Opera 7+';
                    } else {
                        return 'Opera 6-';
                    }
                }
                this.browseKernel='Trident';
                if(sUA.indexOf('Maxthon')!=-1) {
                    return 'Maxthon';
                }
                if(sUA.indexOf('TencentTraveler')!=-1) { //ver 0.1.3
                    return '腾迅TT';
                }
                if(document.getElementById) {
                    return "IE5+";
                } else {
                    return "IE4-";
                }
            }
            //检测Gecko浏览器
            if(sUA.indexOf('Gecko')!=-1) {
                this.browseKernel='Gecko';
                if(navigator.vendor=="Mozilla") {return "Mozilla";}
                if(navigator.vendor=="Firebird") {return "Firebird"; }
                if (sUA.indexOf('Firefox')!=-1) {return 'Firefox';  }
                return "Gecko";
            }
            //Netscape浏览器
            if(sUA.indexOf('Netscape')!=-1) {
                this.browseKernel='Gecko';
                if(document.getElementById) {
                    return "Netscape 6+";
                } else {
                    return 'Netscape 5-';
                }
            }
            //检测Safari浏览器
            if(sUA.indexOf('Safari') != -1) {this.browseKernel='KHTML';return 'Safari';}
            if(sUA.indexOf('konqueror')!=-1) {this.browseKernel='KHTML';return 'Konqueror';}
            //目前世界公认浏览网页速度最快的浏览器，但它占用的系统资源也很大。
            if(sUA.indexOf('Opera') != -1) {
                this.browseKernel='Presto';
                if(window.opera && document.childNodes ) {
                    return 'Opera 7+';
                } else {
                    return 'Opera 6-';
                }
                return 'Opera';
            }
            if((sUA.indexOf( 'hotjava' )!=-1) && typeof( navigator.accentColorName ) == 'undefined' ) {return 'HotJava';}
            if( document.all && document.getElementById && navigator.savePreferences && (sUA.indexOf( 'netfront' ) < 0 ) && navigator.appName != 'Blazer' ) {return 'Escape 5'; }
            //Konqueror / Safari / OmniWeb 4.5+
            if( navigator.vendor == 'KDE' || ( document.childNodes && ( !document.all || navigator.accentColorName ) && !navigator.taintEnabled ) ) {this.browseKernel='KHTML';return 'KDE';}
            if( navigator.__ice_version ) { return 'ICEbrowser';}
            if( window.ScriptEngine && ScriptEngine().indexOf( 'InScript' ) + 1 ) {
                if( document.createElement ) {
                    return 'iCab 3+';
                } else {
                    return 'iCab 2-';
                }
            }
            if(document.layers && !document.classes ) {return 'Omniweb 4.2-';}
            if(document.layers && !navigator.mimeTypes['*'] ) {return 'Escape 4';}
            if(navigator.appName.indexOf( 'WebTV' ) + 1 ) {return 'WebTV';}
            if(sUA.indexOf( 'netgem' )!=-1 ) {return 'Netgem NetBox';}
            if(sUA.indexOf( 'opentv' )!=-1 ) {return 'OpenTV';}
            if(sUA.indexOf( 'ipanel' )!=-1) {return 'iPanel MicroBrowser';}
            if(document.getElementById && !document.childNodes) {return 'Clue browser';}
            if(document.getElementById && ( (sUA.indexOf( 'netfront' ) !=-1) || navigator.appName == 'Blazer' ) ) {return 'NetFront 3+';}
            if((sUA.indexOf( 'msie' ) + 1 ) && window.ActiveXObject ) {return 'Pocket Internet Explorer'; }
            return "Unknown";
        }
        /**
         * 操作系统信息检测
         *
         * @类型：公共方法
         * @参数：无
         * @返回：操作系统名称
         * @作者：[BI]CJJ http://www.imcjj.com
         * @时间：2006-11-7
         * @备注：
         */
        function TClientCheck_OS() {
            var sUA=this.userAgent.toLowerCase();
            if(sUA.indexOf( 'win' ) !=-1){
                if(sUA.indexOf("nt 5.2")!=-1) {return "Windows 2003";}
                if((sUA.indexOf("nt 5.1")!=-1)||(sUA.indexOf("XP")!=-1)) {return "Windows XP"; }
                if((sUA.indexOf('nt 5.0')!=-1) || (sUA.indexOf('2000')!=-1)) {return 'Windows 2000';}
                if((sUA.indexOf("winnt")!=-1) || (sUA.indexOf("windows nt")!=-1)) {return "Windows NT";}
                if((sUA.indexOf("win98")!=-1) || (sUA.indexOf("windows 98")!=-1)) {return "Windows 98";}
                return "Windows";
            }
            if(sUA.indexOf('linux')!=-1) {return 'Linux';}
            if(sUA.indexOf("freebsd")!=-1) {return 'FreeBSD';}
            if(sUA.indexOf( 'x11' )!=-1) {return 'Unix';}
            if(sUA.indexOf('mac') != -1) {return "Mac"; }
            if(sUA.indexOf("sunos")!=-1) {return 'Sun OS';}
            if((sUA.indexOf("os/2")!=-1) || (navigator.appVersion.indexOf("OS/2")!=-1) || (sUA.indexOf("ibm-webexplorer")!=-1)) {return "OS 2"}
            if(navigator.platform == 'PalmOS' ) {return 'Palm OS'; }
            if((navigator.platform == 'WinCE' ) || ( navigator.platform == 'Windows CE' ) || ( navigator.platform == 'Pocket PC' ) ) {return 'Windows CE';}
            if(sUA.indexOf( 'webtv')!=-1) {return 'WebTV Platform'; }
            if(sUA.indexOf( 'netgem')!=-1) {return 'Netgem';}
            if(sUA.indexOf( 'opentv')!=-1) {return 'OpenTV Platform';}
            if(sUA.indexOf( 'symbian')!=-1) {return 'Symbian';}
            return "Unknown";
        }

        function gettime() {
            var date = new Date();
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            var h = date.getHours();
            var min = date.getMinutes();
            var s = date.getSeconds();
            var nowtime = y+'-'+m+'-'+d+' '+h+':'+min+':'+s;
            document.getElementById("time").innerHTML="当前时间："+nowtime;
        }
        setInterval("gettime()",1000);