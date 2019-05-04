package io.renren.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author 作者  Administrator
 * ==============================================================
 * @version 1.0.0
 * @projectName renren-fast
 * @packageName io.renren.data
 * @createTime 2019年4月10日
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @copyright Copyright (c) 2018 中石油天然气股份有限公司规划总院
 * @company 中石油天然气股份有限公司规划总院
 * @module 模块: 模块名称
 * @reviewer 审核人 Administrator
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ImageDownloadInfoData {

	/**
	 * 链接，待解析数据：
	 * https://qdownloader.net/download?video=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DE7rdLT2xs9o
	 * 
	 */
	public static String testParseData = "<!DOCTYPE HTML>\r\n" + 
			"<html lang=\"en\" xmlns:og=\"http://ogp.me/ns#\" xmlns:fb=\"https://www.facebook.com/2008/fbml\">\r\n" + 
			"    <head>\r\n" + 
			"        <meta charset=\"utf-8\">\r\n" + 
			"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"        <title>Download video: Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus | QDownloader.net</title>\r\n" + 
			"        <meta name=\"description\" content=\"Download video: Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus in MP4, AVI, 3GP, and more.\" />\r\n" + 
			"        <link rel=\"canonical\" href=\"https://qdownloader.net\">\r\n" + 
			"        <meta name=\"robots\" content=\"noindex, nofollow\">\r\n" + 
			"        <!-- Open Graph data -->\r\n" + 
			"        <meta property=\"og:title\" content=\"Download video: Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus | QDownloader.net\"/>\r\n" + 
			"        <meta property=\"og:type\" content=\"website\"/>\r\n" + 
			"        <meta property=\"og:url\" content=\"https://qdownloader.net/download?video=https://www.youtube.com/watch?v=E7rdLT2xs9o\"/>\r\n" + 
			"        <meta property=\"og:image\" content=\"https://qdownloader.net/img/favicon/favicon-260.png\"/>\r\n" + 
			"        <meta property=\"og:image:width\" content=\"260\"/>\r\n" + 
			"        <meta property=\"og:image:height\" content=\"260\"/>\r\n" + 
			"        <meta property=\"og:site_name\" content=\"QDownloader\"/>\r\n" + 
			"        <meta property=\"og:description\" content=\"Download video: Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus in MP4, AVI, 3GP, and more.\"/>\r\n" + 
			"        <!-- Twitter Card data -->\r\n" + 
			"        <meta name=\"twitter:card\" content=\"summary\">\r\n" + 
			"        <meta name=\"twitter:title\" content=\"Download video: Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus | QDownloader.net\">\r\n" + 
			"        <meta name=\"twitter:description\" content=\"Download video: Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus in MP4, AVI, 3GP, and more.\">\r\n" + 
			"        <meta name=\"twitter:image\" content=\"https://qdownloader.net/img/favicon/favicon-260.png\">\r\n" + 
			"        <meta name=\"twitter:image:src\" content=\"https://qdownloader.net/img/favicon/favicon-260.png\">\r\n" + 
			"        <meta name=\"twitter:url\" content=\"https://qdownloader.net/download?video=https://www.youtube.com/watch?v=E7rdLT2xs9o\">\r\n" + 
			"        <link rel=\"stylesheet\" href=\"/css/common.css\">\r\n" + 
			"        <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/img/favicon/apple-touch-icon.png\">\r\n" + 
			"        <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"/img/favicon/favicon-32x32.png\">\r\n" + 
			"        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"/img/favicon/favicon-16x16.png\">\r\n" + 
			"        <link rel=\"manifest\" href=\"/img/favicon/site.webmanifest\">\r\n" + 
			"        <link rel=\"mask-icon\" href=\"/img/favicon/safari-pinned-tab.svg\" color=\"#5bbad5\">\r\n" + 
			"        <link rel=\"shortcut icon\" href=\"/img/favicon/favicon.ico\">\r\n" + 
			"        <meta name=\"msapplication-TileColor\" content=\"#2c1542\">\r\n" + 
			"        <meta name=\"msapplication-config\" content=\"/img/favicon/browserconfig.xml\">\r\n" + 
			"        <meta name=\"theme-color\" content=\"#ffffff\">\r\n" + 
			"        <link rel=\"stylesheet\" href=\"https://qdownloader.net/css/bootstrap-q3f29daz.min.css\">\r\n" + 
			"        <link rel=\"stylesheet\" href=\"/css/layout.css\">\r\n" + 
			"        <!-- Global site tag (gtag.js) - Google Analytics -->\r\n" + 
			"        <script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-120929066-1\"></script>\r\n" + 
			"        <script>\r\n" + 
			"    window.dataLayer = window.dataLayer || [];\r\n" + 
			"    function gtag(){dataLayer.push(arguments);}\r\n" + 
			"    gtag('js', new Date());\r\n" + 
			"\r\n" + 
			"    gtag('config', 'UA-120929066-1');\r\n" + 
			"  </script>\r\n" + 
			"    </head>\r\n" + 
			"    <body>\r\n" + 
			"        <script>\r\n" + 
			"\r\n" + 
			"    /* Set the width of the side navigation to 250px */\r\n" + 
			"    function openNav() {\r\n" + 
			"      document.getElementById(\"mySidenav\").style.width = \"250px\";\r\n" + 
			"      document.getElementById(\"black-cover\").style.display = \"block\";\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"    /* Set the width of the side navigation to 0 */\r\n" + 
			"    function closeNav() {\r\n" + 
			"    document.getElementById(\"black-cover\").style.display = \"none\";\r\n" + 
			"    document.getElementById(\"mySidenav\").style.width = \"0\";\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"  </script>\r\n" + 
			"        <div class=\"upper-display\">\r\n" + 
			"            <div class=\"row purple-bg\">\r\n" + 
			"                <div id=\"navMenu\">\r\n" + 
			"                    <div class=\"desktop row\">\r\n" + 
			"                        <div class=\"col-md-3 col-sm-3 col-xs-12 logo\">\r\n" + 
			"                            <a href=\"https://qdownloader.net\">\r\n" + 
			"                                <span>QDownloader.net</span>\r\n" + 
			"                            </a>\r\n" + 
			"                        </div>\r\n" + 
			"                        <div class=\"col-md-9 col-sm-9 col-xs-12 menu\">\r\n" + 
			"                            <ul class=\"links\">\r\n" + 
			"                                <li>\r\n" + 
			"                                    <a href=\"https://qdownloader.net/bookmarklet\">Bookmarklet</a>\r\n" + 
			"                                </li>\r\n" + 
			"                                <li>\r\n" + 
			"                                    <a target=\"_blank\" href=\"https://maxconverter.net/online-video-converter\">Video Converter</a>\r\n" + 
			"                                </li>\r\n" + 
			"                                <li>\r\n" + 
			"                                    <a target=\"_blank\" href=\"https://alldownloader.net/\">YouTube Downloader</a>\r\n" + 
			"                                </li>\r\n" + 
			"                                <li>\r\n" + 
			"                                    <a target=\"_blank\" href=\"https://fbdownload.io\">Facebook Downloader</a>\r\n" + 
			"                                </li>\r\n" + 
			"                                <div class=\"dropdown\">\r\n" + 
			"                                    <li onclick=\"myFunction()\" class=\"dropbtn\">\r\n" + 
			"                                        <div class=\"country-flag\">\r\n" + 
			"                                            <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                      	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                <g>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M52.92,100.142c-20.109,26.163-35.272,56.318-44.101,89.077h133.178L52.92,100.142z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M503.181,189.219c-8.829-32.758-23.993-62.913-44.101-89.076l-89.075,89.076H503.181z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M8.819,322.784c8.83,32.758,23.993,62.913,44.101,89.075l89.074-89.075L8.819,322.784L8.819,322.784\r\n" + 
			"                      		z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M411.858,52.921c-26.163-20.109-56.317-35.272-89.076-44.102v133.177L411.858,52.921z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M100.142,459.079c26.163,20.109,56.318,35.272,89.076,44.102V370.005L100.142,459.079z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M189.217,8.819c-32.758,8.83-62.913,23.993-89.075,44.101l89.075,89.075V8.819z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M322.783,503.181c32.758-8.83,62.913-23.993,89.075-44.101l-89.075-89.075V503.181z\"/>\r\n" + 
			"                                                    <path style=\"fill:#0052B4;\" d=\"M370.005,322.784l89.075,89.076c20.108-26.162,35.272-56.318,44.101-89.076H370.005z\"/>\r\n" + 
			"                                                </g>\r\n" + 
			"                                                <g>\r\n" + 
			"                                                    <path style=\"fill:#D80027;\" d=\"M509.833,222.609h-220.44h-0.001V2.167C278.461,0.744,267.317,0,256,0\r\n" + 
			"                      		c-11.319,0-22.461,0.744-33.391,2.167v220.44v0.001H2.167C0.744,233.539,0,244.683,0,256c0,11.319,0.744,22.461,2.167,33.391\r\n" + 
			"                      		h220.44h0.001v220.442C233.539,511.256,244.681,512,256,512c11.317,0,22.461-0.743,33.391-2.167v-220.44v-0.001h220.442\r\n" + 
			"                      		C511.256,278.461,512,267.319,512,256C512,244.683,511.256,233.539,509.833,222.609z\"/>\r\n" + 
			"                                                    <path style=\"fill:#D80027;\" d=\"M322.783,322.784L322.783,322.784L437.019,437.02c5.254-5.252,10.266-10.743,15.048-16.435\r\n" + 
			"                      		l-97.802-97.802h-31.482V322.784z\"/>\r\n" + 
			"                                                    <path style=\"fill:#D80027;\" d=\"M189.217,322.784h-0.002L74.98,437.019c5.252,5.254,10.743,10.266,16.435,15.048l97.802-97.804\r\n" + 
			"                      		V322.784z\"/>\r\n" + 
			"                                                    <path style=\"fill:#D80027;\" d=\"M189.217,189.219v-0.002L74.981,74.98c-5.254,5.252-10.266,10.743-15.048,16.435l97.803,97.803\r\n" + 
			"                      		H189.217z\"/>\r\n" + 
			"                                                    <path style=\"fill:#D80027;\" d=\"M322.783,189.219L322.783,189.219L437.02,74.981c-5.252-5.254-10.743-10.266-16.435-15.047\r\n" + 
			"                      		l-97.802,97.803V189.219z\"/>\r\n" + 
			"                                                </svg>\r\n" + 
			"                                            </div>\r\n" + 
			"                    English\r\n" + 
			"                                            <span class=\"caret-down\">\r\n" + 
			"                                                <svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" data-icon=\"caret-bottom\" data-container-transform=\"translate(0 24)\" viewBox=\"0 0 128 110\" x=\"0px\" y=\"0px\">\r\n" + 
			"                                                    <path d=\"M1.5 0c-.8 0-1.094.487-.594 1.188l62.094 77.719c.6.6 1.406.606 1.906-.094l62.188-77.625c.5-.7.206-1.188-.594-1.188h-125z\" transform=\"translate(0 24)\"/>\r\n" + 
			"                                                </svg>\r\n" + 
			"                                            </span>\r\n" + 
			"                                        </li>\r\n" + 
			"                                        <div id=\"myDropdown\" class=\"dropdown-content\">\r\n" + 
			"                                            <a href=\"https://qdownloader.net/es\">\r\n" + 
			"                                                <div class=\"country-flag\">\r\n" + 
			"                                                    <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                        	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                        <path style=\"fill:#FFDA44;\" d=\"M0,256c0,31.314,5.633,61.31,15.923,89.043L256,367.304l240.077-22.261\r\n" + 
			"                        	C506.367,317.31,512,287.314,512,256s-5.633-61.31-15.923-89.043L256,144.696L15.923,166.957C5.633,194.69,0,224.686,0,256z\"/>\r\n" + 
			"                                                        <g>\r\n" + 
			"                                                            <path style=\"fill:#D80027;\" d=\"M496.077,166.957C459.906,69.473,366.071,0,256,0S52.094,69.473,15.923,166.957H496.077z\"/>\r\n" + 
			"                                                            <path style=\"fill:#D80027;\" d=\"M15.923,345.043C52.094,442.527,145.929,512,256,512s203.906-69.473,240.077-166.957H15.923z\"/>\r\n" + 
			"                                                        </svg>\r\n" + 
			"                                                    </div>\r\n" + 
			"                      Español\r\n" + 
			"                                                </a>\r\n" + 
			"                                                <a href=\"https://qdownloader.net/fr\">\r\n" + 
			"                                                    <div class=\"country-flag\">\r\n" + 
			"                                                        <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                           viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                            <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                            <path style=\"fill:#D80027;\" d=\"M512,256c0-110.071-69.472-203.906-166.957-240.077v480.155C442.528,459.906,512,366.071,512,256z\"/>\r\n" + 
			"                                                            <path style=\"fill:#0052B4;\" d=\"M0,256c0,110.071,69.473,203.906,166.957,240.077V15.923C69.473,52.094,0,145.929,0,256z\"/>\r\n" + 
			"                                                        </svg>\r\n" + 
			"                                                    </div>\r\n" + 
			"                      Français\r\n" + 
			"                                                </a>\r\n" + 
			"                                                <a href=\"https://qdownloader.net/pt\">\r\n" + 
			"                                                    <div class=\"country-flag\">\r\n" + 
			"                                                        <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                        	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                            <path style=\"fill:#6DA544;\" d=\"M0,256c0,110.07,69.472,203.905,166.955,240.076l22.262-240.077L166.955,15.923\r\n" + 
			"                        	C69.472,52.095,0,145.929,0,256z\"/>\r\n" + 
			"                                                            <path style=\"fill:#D80027;\" d=\"M512,256C512,114.616,397.384,0,256,0c-31.314,0-61.311,5.633-89.045,15.923v480.154\r\n" + 
			"                        	C194.689,506.368,224.686,512,256,512C397.384,512,512,397.384,512,256z\"/>\r\n" + 
			"                                                            <circle style=\"fill:#FFDA44;\" cx=\"166.957\" cy=\"256\" r=\"89.043\"/>\r\n" + 
			"                                                            <path style=\"fill:#D80027;\" d=\"M116.87,211.478v55.652c0,27.662,22.424,50.087,50.087,50.087s50.087-22.424,50.087-50.087v-55.652\r\n" + 
			"                        	H116.87z\"/>\r\n" + 
			"                                                            <path style=\"fill:#F0F0F0;\" d=\"M166.957,283.826c-9.206,0-16.696-7.49-16.696-16.696V244.87h33.391v22.261\r\n" + 
			"                        	C183.652,276.336,176.162,283.826,166.957,283.826z\"/>\r\n" + 
			"                                                            <g>\r\n" + 
			"                        \r\n" + 
			"                                                            </svg>\r\n" + 
			"                                                        </div>\r\n" + 
			"                      Português\r\n" + 
			"                                                    </a>\r\n" + 
			"                                                    <a href=\"https://qdownloader.net/de\">\r\n" + 
			"                                                        <div class=\"country-flag\">\r\n" + 
			"                                                            <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                        	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                <path style=\"fill:#FFDA44;\" d=\"M15.923,345.043C52.094,442.527,145.929,512,256,512s203.906-69.473,240.077-166.957L256,322.783\r\n" + 
			"                        	L15.923,345.043z\"/>\r\n" + 
			"                                                                <path d=\"M256,0C145.929,0,52.094,69.472,15.923,166.957L256,189.217l240.077-22.261C459.906,69.472,366.071,0,256,0z\"/>\r\n" + 
			"                                                                <path style=\"fill:#D80027;\" d=\"M15.923,166.957C5.633,194.69,0,224.686,0,256s5.633,61.31,15.923,89.043h480.155\r\n" + 
			"                        	C506.368,317.31,512,287.314,512,256s-5.632-61.31-15.923-89.043H15.923z\"/>\r\n" + 
			"                                                            </svg>\r\n" + 
			"                                                        </div>\r\n" + 
			"                      Deutsch\r\n" + 
			"                                                    </a>\r\n" + 
			"                                                    <a href=\"https://qdownloader.net/ru\">\r\n" + 
			"                                                        <div class=\"country-flag\">\r\n" + 
			"                                                            <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                        	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                                <path style=\"fill:#0052B4;\" d=\"M496.077,345.043C506.368,317.31,512,287.314,512,256s-5.632-61.31-15.923-89.043H15.923\r\n" + 
			"                        	C5.633,194.69,0,224.686,0,256s5.633,61.31,15.923,89.043L256,367.304L496.077,345.043z\"/>\r\n" + 
			"                                                                <path style=\"fill:#D80027;\" d=\"M256,512c110.071,0,203.906-69.472,240.077-166.957H15.923C52.094,442.528,145.929,512,256,512z\"/>\r\n" + 
			"                                                            </svg>\r\n" + 
			"                                                        </div>\r\n" + 
			"                      Русский\r\n" + 
			"                                                    </a>\r\n" + 
			"                                                    <a href=\"https://qdownloader.net/it\">\r\n" + 
			"                                                        <div class=\"country-flag\">\r\n" + 
			"                                                            <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                          	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                                <path style=\"fill:#D80027;\" d=\"M512,256c0-110.071-69.472-203.906-166.957-240.077v480.155C442.528,459.906,512,366.071,512,256z\"/>\r\n" + 
			"                                                                <path style=\"fill:#6DA544;\" d=\"M0,256c0,110.071,69.472,203.906,166.957,240.077V15.923C69.472,52.094,0,145.929,0,256z\"/>\r\n" + 
			"                                                            </svg>\r\n" + 
			"                                                        </div>\r\n" + 
			"                        Italiano\r\n" + 
			"                                                    </a>\r\n" + 
			"                                                </div>\r\n" + 
			"                                            </div>\r\n" + 
			"                                        </ul>\r\n" + 
			"                                    </div>\r\n" + 
			"                                </div>\r\n" + 
			"                                <nav role=\"navigation\" id=\"responsive-nav\" class=\"row\">\r\n" + 
			"                                    <div class=\"col-m-2 col-sm-2 col-xs-2 responsive-menu\">\r\n" + 
			"                                        <div id=\"black-cover\" onclick=\"closeNav()\"></div>\r\n" + 
			"                                        <div id=\"mySidenav\" class=\"sidenav\">\r\n" + 
			"                                            <div class=\"side-content\">\r\n" + 
			"                                                <a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">&times;</a>\r\n" + 
			"                                                <div class=\"side-logo\">\r\n" + 
			"                                                    <a class=\"name\" href=\"https://qdownloader.net\">QDownloader.net</a>\r\n" + 
			"                                                </div>\r\n" + 
			"                                                <div class=\"links block\">\r\n" + 
			"                                                    <a href=\"https://qdownloader.net/bookmarklet\">Bookmarklet</a>\r\n" + 
			"                                                    <a target=\"_blank\" href=\"https://maxconverter.net/online-video-converter\">Video Converter</a>\r\n" + 
			"                                                    <a target=\"_blank\" href=\"https://alldownloader.net/\">YouTube Downloader</a>\r\n" + 
			"                                                    <a target=\"_blank\" href=\"https://fbdownload.io\">Facebook Downloader</a>\r\n" + 
			"                                                    <div class=\"dropdown\">\r\n" + 
			"                                                        <a onclick=\"showResponsiveDropdown()\" class=\"dropbtn\">\r\n" + 
			"                                                            <div class=\"country-flag\">\r\n" + 
			"                                                                <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                               viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                    <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                                    <g>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M52.92,100.142c-20.109,26.163-35.272,56.318-44.101,89.077h133.178L52.92,100.142z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M503.181,189.219c-8.829-32.758-23.993-62.913-44.101-89.076l-89.075,89.076H503.181z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M8.819,322.784c8.83,32.758,23.993,62.913,44.101,89.075l89.074-89.075L8.819,322.784L8.819,322.784\r\n" + 
			"                                z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M411.858,52.921c-26.163-20.109-56.317-35.272-89.076-44.102v133.177L411.858,52.921z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M100.142,459.079c26.163,20.109,56.318,35.272,89.076,44.102V370.005L100.142,459.079z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M189.217,8.819c-32.758,8.83-62.913,23.993-89.075,44.101l89.075,89.075V8.819z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M322.783,503.181c32.758-8.83,62.913-23.993,89.075-44.101l-89.075-89.075V503.181z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#0052B4;\" d=\"M370.005,322.784l89.075,89.076c20.108-26.162,35.272-56.318,44.101-89.076H370.005z\"/>\r\n" + 
			"                                                                    </g>\r\n" + 
			"                                                                    <g>\r\n" + 
			"                                                                        <path style=\"fill:#D80027;\" d=\"M509.833,222.609h-220.44h-0.001V2.167C278.461,0.744,267.317,0,256,0\r\n" + 
			"                                c-11.319,0-22.461,0.744-33.391,2.167v220.44v0.001H2.167C0.744,233.539,0,244.683,0,256c0,11.319,0.744,22.461,2.167,33.391\r\n" + 
			"                                h220.44h0.001v220.442C233.539,511.256,244.681,512,256,512c11.317,0,22.461-0.743,33.391-2.167v-220.44v-0.001h220.442\r\n" + 
			"                                C511.256,278.461,512,267.319,512,256C512,244.683,511.256,233.539,509.833,222.609z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#D80027;\" d=\"M322.783,322.784L322.783,322.784L437.019,437.02c5.254-5.252,10.266-10.743,15.048-16.435\r\n" + 
			"                                l-97.802-97.802h-31.482V322.784z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#D80027;\" d=\"M189.217,322.784h-0.002L74.98,437.019c5.252,5.254,10.743,10.266,16.435,15.048l97.802-97.804\r\n" + 
			"                                V322.784z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#D80027;\" d=\"M189.217,189.219v-0.002L74.981,74.98c-5.254,5.252-10.266,10.743-15.048,16.435l97.803,97.803\r\n" + 
			"                                H189.217z\"/>\r\n" + 
			"                                                                        <path style=\"fill:#D80027;\" d=\"M322.783,189.219L322.783,189.219L437.02,74.981c-5.252-5.254-10.743-10.266-16.435-15.047\r\n" + 
			"                                l-97.802,97.803V189.219z\"/>\r\n" + 
			"                                                                    </svg>\r\n" + 
			"                                                                </div>\r\n" + 
			"                          English\r\n" + 
			"                                                                <span class=\"caret-down\">\r\n" + 
			"                                                                    <svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" data-icon=\"caret-bottom\" data-container-transform=\"translate(0 24)\" viewBox=\"0 0 128 110\" x=\"0px\" y=\"0px\">\r\n" + 
			"                                                                        <path d=\"M1.5 0c-.8 0-1.094.487-.594 1.188l62.094 77.719c.6.6 1.406.606 1.906-.094l62.188-77.625c.5-.7.206-1.188-.594-1.188h-125z\" transform=\"translate(0 24)\"/>\r\n" + 
			"                                                                    </svg>\r\n" + 
			"                                                                </span>\r\n" + 
			"                                                            </a>\r\n" + 
			"                                                            <div id=\"myResponsiveDropdown\" class=\"dropdown-content\">\r\n" + 
			"                                                                <a href=\"https://qdownloader.net/es\">\r\n" + 
			"                                                                    <div class=\"country-flag\">\r\n" + 
			"                                                                        <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                               viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                            <path style=\"fill:#FFDA44;\" d=\"M0,256c0,31.314,5.633,61.31,15.923,89.043L256,367.304l240.077-22.261\r\n" + 
			"                              C506.367,317.31,512,287.314,512,256s-5.633-61.31-15.923-89.043L256,144.696L15.923,166.957C5.633,194.69,0,224.686,0,256z\"/>\r\n" + 
			"                                                                            <g>\r\n" + 
			"                                                                                <path style=\"fill:#D80027;\" d=\"M496.077,166.957C459.906,69.473,366.071,0,256,0S52.094,69.473,15.923,166.957H496.077z\"/>\r\n" + 
			"                                                                                <path style=\"fill:#D80027;\" d=\"M15.923,345.043C52.094,442.527,145.929,512,256,512s203.906-69.473,240.077-166.957H15.923z\"/>\r\n" + 
			"                                                                            </svg>\r\n" + 
			"                                                                        </div>\r\n" + 
			"                          Español\r\n" + 
			"                                                                    </a>\r\n" + 
			"                                                                    <a href=\"https://qdownloader.net/fr\">\r\n" + 
			"                                                                        <div class=\"country-flag\">\r\n" + 
			"                                                                            <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                               viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                                <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                                                <path style=\"fill:#D80027;\" d=\"M512,256c0-110.071-69.472-203.906-166.957-240.077v480.155C442.528,459.906,512,366.071,512,256z\"/>\r\n" + 
			"                                                                                <path style=\"fill:#0052B4;\" d=\"M0,256c0,110.071,69.473,203.906,166.957,240.077V15.923C69.473,52.094,0,145.929,0,256z\"/>\r\n" + 
			"                                                                            </svg>\r\n" + 
			"                                                                        </div>\r\n" + 
			"                          Français\r\n" + 
			"                                                                    </a>\r\n" + 
			"                                                                    <a href=\"https://qdownloader.net/pt\">\r\n" + 
			"                                                                        <div class=\"country-flag\">\r\n" + 
			"                                                                            <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                               viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                                <path style=\"fill:#6DA544;\" d=\"M0,256c0,110.07,69.472,203.905,166.955,240.076l22.262-240.077L166.955,15.923\r\n" + 
			"                              C69.472,52.095,0,145.929,0,256z\"/>\r\n" + 
			"                                                                                <path style=\"fill:#D80027;\" d=\"M512,256C512,114.616,397.384,0,256,0c-31.314,0-61.311,5.633-89.045,15.923v480.154\r\n" + 
			"                              C194.689,506.368,224.686,512,256,512C397.384,512,512,397.384,512,256z\"/>\r\n" + 
			"                                                                                <circle style=\"fill:#FFDA44;\" cx=\"166.957\" cy=\"256\" r=\"89.043\"/>\r\n" + 
			"                                                                                <path style=\"fill:#D80027;\" d=\"M116.87,211.478v55.652c0,27.662,22.424,50.087,50.087,50.087s50.087-22.424,50.087-50.087v-55.652\r\n" + 
			"                              H116.87z\"/>\r\n" + 
			"                                                                                <path style=\"fill:#F0F0F0;\" d=\"M166.957,283.826c-9.206,0-16.696-7.49-16.696-16.696V244.87h33.391v22.261\r\n" + 
			"                              C183.652,276.336,176.162,283.826,166.957,283.826z\"/>\r\n" + 
			"                                                                                <g>\r\n" + 
			"                            \r\n" + 
			"                                                                                </svg>\r\n" + 
			"                                                                            </div>\r\n" + 
			"                          Português\r\n" + 
			"                                                                        </a>\r\n" + 
			"                                                                        <a href=\"https://qdownloader.net/de\">\r\n" + 
			"                                                                            <div class=\"country-flag\">\r\n" + 
			"                                                                                <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                               viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                                    <path style=\"fill:#FFDA44;\" d=\"M15.923,345.043C52.094,442.527,145.929,512,256,512s203.906-69.473,240.077-166.957L256,322.783\r\n" + 
			"                              L15.923,345.043z\"/>\r\n" + 
			"                                                                                    <path d=\"M256,0C145.929,0,52.094,69.472,15.923,166.957L256,189.217l240.077-22.261C459.906,69.472,366.071,0,256,0z\"/>\r\n" + 
			"                                                                                    <path style=\"fill:#D80027;\" d=\"M15.923,166.957C5.633,194.69,0,224.686,0,256s5.633,61.31,15.923,89.043h480.155\r\n" + 
			"                              C506.368,317.31,512,287.314,512,256s-5.632-61.31-15.923-89.043H15.923z\"/>\r\n" + 
			"                                                                                </svg>\r\n" + 
			"                                                                            </div>\r\n" + 
			"                          Deutsch\r\n" + 
			"                                                                        </a>\r\n" + 
			"                                                                        <a href=\"https://qdownloader.net/ru\">\r\n" + 
			"                                                                            <div class=\"country-flag\">\r\n" + 
			"                                                                                <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                               viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                                    <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                                                    <path style=\"fill:#0052B4;\" d=\"M496.077,345.043C506.368,317.31,512,287.314,512,256s-5.632-61.31-15.923-89.043H15.923\r\n" + 
			"                              C5.633,194.69,0,224.686,0,256s5.633,61.31,15.923,89.043L256,367.304L496.077,345.043z\"/>\r\n" + 
			"                                                                                    <path style=\"fill:#D80027;\" d=\"M256,512c110.071,0,203.906-69.472,240.077-166.957H15.923C52.094,442.528,145.929,512,256,512z\"/>\r\n" + 
			"                                                                                </svg>\r\n" + 
			"                                                                            </div>\r\n" + 
			"                          Русский\r\n" + 
			"                                                                        </a>\r\n" + 
			"                                                                        <a href=\"https://qdownloader.net/it\">\r\n" + 
			"                                                                            <div class=\"country-flag\">\r\n" + 
			"                                                                                <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\r\n" + 
			"                              	 viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\">\r\n" + 
			"                                                                                    <circle style=\"fill:#F0F0F0;\" cx=\"256\" cy=\"256\" r=\"256\"/>\r\n" + 
			"                                                                                    <path style=\"fill:#D80027;\" d=\"M512,256c0-110.071-69.472-203.906-166.957-240.077v480.155C442.528,459.906,512,366.071,512,256z\"/>\r\n" + 
			"                                                                                    <path style=\"fill:#6DA544;\" d=\"M0,256c0,110.071,69.472,203.906,166.957,240.077V15.923C69.472,52.094,0,145.929,0,256z\"/>\r\n" + 
			"                                                                                </svg>\r\n" + 
			"                                                                            </div>\r\n" + 
			"                            Italiano\r\n" + 
			"                                                                        </a>\r\n" + 
			"                                                                    </div>\r\n" + 
			"                                                                </div>\r\n" + 
			"                                                            </div>\r\n" + 
			"                                                        </div>\r\n" + 
			"                                                    </div>\r\n" + 
			"                                                    <span class=\"menu-btn\" onclick=\"openNav()\">\r\n" + 
			"                                                        <div></div>\r\n" + 
			"                                                        <div></div>\r\n" + 
			"                                                        <div></div>\r\n" + 
			"                                                    </span>\r\n" + 
			"                                                </div>\r\n" + 
			"                                                <a href=\"https://qdownloader.net\">\r\n" + 
			"                                                    <div class=\"col-md-8 col-lg-8 col-sm-8 col-xs-8\" style=\"text-align: center;\">\r\n" + 
			"                                                        <div class=\"logo\">\r\n" + 
			"                                                            <a class=\"name\" href=\"https://qdownloader.net\">QDownloader.net</a>\r\n" + 
			"                                                        </div>\r\n" + 
			"                                                    </div>\r\n" + 
			"                                                </a>\r\n" + 
			"                                            </nav>\r\n" + 
			"                                        </div>\r\n" + 
			"                                    </div>\r\n" + 
			"                                    <div class=\"searchForm\" style=\" padding-top: 50px; \">\r\n" + 
			"                                        <form id=\"downloadForm\"class=\"\" method=\"GET\" action=\"https://qdownloader.net/download\">\r\n" + 
			"                                            <input name=\"video\" class=\"url-input\" type=\"text\" placeholder= \"Enter the video's link...\" value=\"https://www.youtube.com/watch?v=E7rdLT2xs9o\"/>\r\n" + 
			"                                            <div id=\"downloadBtn\">Download</div>\r\n" + 
			"                                        </form>\r\n" + 
			"                                        <style>\r\n" + 
			".cc-notice{\r\n" + 
			"  text-align: center;\r\n" + 
			"  color: #957c9c;\r\n" + 
			"  margin-top: 40px;\r\n" + 
			"  margin-bottom: -25px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".cc-notice a{\r\n" + 
			"  color: #957c9c;\r\n" + 
			"  text-decoration: underline;\r\n" + 
			"}\r\n" + 
			"</style>\r\n" + 
			"                                        <div class=\"cc-notice\">\r\n" + 
			"By using this website, you accept our \r\n" + 
			"                                            <a href=\"https://qdownloader.net/policies/terms-of-service\">Terms of Service</a> and agree not to download Copyright content.\r\n" + 
			"                                        </div>\r\n" + 
			"                                    </div>\r\n" + 
			"                                </div>\r\n" + 
			"                                <div id=\"loading-message\">\r\n" + 
			"                                    <div class=\"loader\">Generating download links, please wait...</div>\r\n" + 
			"                                    <div class=\"status\">Generating download links, please wait...</div>\r\n" + 
			"                                </div>\r\n" + 
			"                                <div class=\"main front-main\"  style=\"max-width: 1200px !important; padding: 0 !important;\" >\r\n" + 
			"                                    <div class=\"rhbn\" style=\"margin-top: 30px; margin-bottom: 20px;\">\r\n" + 
			"                                        <a class=\"rhbn-w\" target=\"_blank\" rel=\"nofollow\" href=\"https://wallpaperhunt.net\">\r\n" + 
			"                                            <img style=\"max-width: 720px; border-radius: 3px;\" src=\"https://qdownloader.net/img/wh-d2.jpg\" />\r\n" + 
			"                                            <div class=\"whText\">\r\n" + 
			"                  Download HD & 4K Wallpapers\r\n" + 
			"                </div>\r\n" + 
			"                                            <div  class=\"whDl\">\r\n" + 
			"                  Browse now >>\r\n" + 
			"                </div>\r\n" + 
			"                                        </a>\r\n" + 
			"                                        <a class=\"rhbn-s\" target=\"_blank\" rel=\"nofollow\" href=\"https://wallpaperhunt.net\">\r\n" + 
			"                                            <img style=\"width: 100%; border-radius: 3px;\" src=\"https://qdownloader.net/img/wh-m.jpg\" />\r\n" + 
			"                                            <div class=\"whText\">\r\n" + 
			"                  Download HD & 4K Wallpapers\r\n" + 
			"                </div>\r\n" + 
			"                                            <div  class=\"whDl\">\r\n" + 
			"                  Browse now >>\r\n" + 
			"                </div>\r\n" + 
			"                                        </a>\r\n" + 
			"                                    </div>\r\n" + 
			"                                    <style>\r\n" + 
			"          .rhbn-w img{\r\n" + 
			"            /* width: 728px !important; */\r\n" + 
			"            height: 100px;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          .rhbn-w .whText{\r\n" + 
			"            color: white;\r\n" + 
			"            max-width: 720px;\r\n" + 
			"            margin: 0 auto;\r\n" + 
			"            font-weight: bold;\r\n" + 
			"            font-size: 22px;\r\n" + 
			"            position: absolute;\r\n" + 
			"            /* top: 20px; */\r\n" + 
			"            right: 0;\r\n" + 
			"            left: 0;\r\n" + 
			"            top: 12px;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          .rhbn-w .whDl{\r\n" + 
			"            position: absolute;\r\n" + 
			"          right: 0;\r\n" + 
			"          left: 0;\r\n" + 
			"          top: 55px;\r\n" + 
			"          color: #b72626;\r\n" + 
			"          background: #ffffff;\r\n" + 
			"          font-weight: bold;\r\n" + 
			"          max-width: 130px;\r\n" + 
			"          font-size: 14px;\r\n" + 
			"          margin: 0 auto;\r\n" + 
			"          border-radius: 2px;\r\n" + 
			"          padding: 7px;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"          .rhbn-s .whText{\r\n" + 
			"            color: white;\r\n" + 
			"            max-width: 720px;\r\n" + 
			"            margin: 0 auto;\r\n" + 
			"            height: 90px;\r\n" + 
			"            font-weight: bold;\r\n" + 
			"            font-size: 27px;\r\n" + 
			"            position: absolute;\r\n" + 
			"            /* top: 20px; */\r\n" + 
			"            right: 0;\r\n" + 
			"            left: 0;\r\n" + 
			"            top: 60px;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          .rhbn-s .whDl{\r\n" + 
			"            position: absolute;\r\n" + 
			"                right: 0;\r\n" + 
			"                left: 0;\r\n" + 
			"                top: 175px;\r\n" + 
			"                color: #b72626;\r\n" + 
			"                background: #ffffff;\r\n" + 
			"                font-weight: bold;\r\n" + 
			"                max-width: 150px;\r\n" + 
			"                font-size: 17px;\r\n" + 
			"                margin: 0 auto;\r\n" + 
			"                border-radius: 2px;\r\n" + 
			"                padding: 10px 5px;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          .rhbn{\r\n" + 
			"            margin-bottom: 20px;\r\n" + 
			"            width: 100%;\r\n" + 
			"            text-align: center;\r\n" + 
			"            display: block;\r\n" + 
			"            position: relative;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          .rhbn .note{\r\n" + 
			"            color: #6f7e8a;\r\n" + 
			"            font-style: italic;\r\n" + 
			"            margin-top: 15px;\r\n" + 
			"            font-size: 14px;\r\n" + 
			"            text-align: center;\r\n" + 
			"          }\r\n" + 
			"          .rhbn-s{\r\n" + 
			"            display: none;\r\n" + 
			"            position: relative;\r\n" + 
			"            max-width: 300px;\r\n" + 
			"            margin: 0 auto;\r\n" + 
			"            height: 277px;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          .rhbn-s img{\r\n" + 
			"            height: 100%;\r\n" + 
			"            width: 100%;\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          @media  only screen and (max-width:800px){\r\n" + 
			"\r\n" + 
			"            .rhbn-w{\r\n" + 
			"              display: none !important;\r\n" + 
			"            }\r\n" + 
			"\r\n" + 
			"            .rhbn-s{\r\n" + 
			"                display: block !important;\r\n" + 
			"            }\r\n" + 
			"\r\n" + 
			"            .rhbn{\r\n" + 
			"              margin-bottom: 40px !important;\r\n" + 
			"            }\r\n" + 
			"\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"          </style>\r\n" + 
			"                                    <div class=\"downloadSection\" id=\"dlSection\">\r\n" + 
			"                                        <div class=\"row\">\r\n" + 
			"                                            <div class=\"info col-md-4\">\r\n" + 
			"                                                <img src=\"https://i.ytimg.com/vi/E7rdLT2xs9o/maxresdefault.jpg\" />\r\n" + 
			"                                                <span  class=\"title\" style=\"margin-bottom: 20px;\">Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus</span>\r\n" + 
			"                                                <div style=\"font-size: 19px; \">\r\n" + 
			"                                                    <span class=\"title\" style=\"display: inline-block; text-decoration: underline;\">Duration: </span> 00:44:27\r\n" + 
			"                                                </div>\r\n" + 
			"                                            </div>\r\n" + 
			"                                            <div class=\"col-md-8\">\r\n" + 
			"                                                <div class=\"download-type\">\r\n" + 
			"                                                    <h3>Download Video with Sound</h3>\r\n" + 
			"                                                </div>\r\n" + 
			"                                                <span class=\"downloadInstruction\" style=\"color: #e65426;\">\r\n" + 
			"                                                    <span style=\"color: #FF5722;\">***</span> To download, right-click on the download button (or tap and hold if using mobile) and choose the Save/Download option.\r\n" + 
			"                                                    <span style=\"color: #FF5722;\">***</span>\r\n" + 
			"                                                </span>\r\n" + 
			"                                                <table cellspacing = \"0\" cellpaddinig = \"0\" border=\"0\" class=\"downloadsTable\">\r\n" + 
			"                                                    <thead>\r\n" + 
			"                                                        <tr class=\"headerRow\">\r\n" + 
			"                                                            <th>Quality</th>\r\n" + 
			"                                                            <th>Format</th>\r\n" + 
			"                                                            <th>Size</th>\r\n" + 
			"                                                            <th>Downloads</th>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                    </thead>\r\n" + 
			"                                                    <tbody>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>1080p (HD)</td>\r\n" + 
			"                                                            <td>MP4</td>\r\n" + 
			"                                                            <td>N/A</td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a style=\"margin: 0 auto; max-width: 140px; display: block; background: #e63873 !important;\" href=\"https://qdownloader.net/download/hd?id=E7rdLT2xs9o&f=137&d=2667&i=https://i.ytimg.com/vi/E7rdLT2xs9o/maxresdefault.jpg&t=Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus\">Convert video</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>720p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 332.05MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?ratebypass=yes&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;key=yt6&amp;c=WEB&amp;lmt=1509688634686777&amp;mime=video%2Fmp4&amp;signature=941294396D3F1734941FD4B76C8CBAB746BB3A86.96645B0DFEA644A85720D0082694C66C02F17C57&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.974&amp;itag=22&amp;ipbits=0&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;requiressl=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>360p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 185.37MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?ratebypass=yes&amp;mime=video%2Fmp4&amp;signature=23F57C8CBFA93B82D48A66FD26AFADC73950E472.54EC3A5B9F68A306D44C4FA25783F4BE1D3CE7AD&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.974&amp;itag=18&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509678253833737&amp;clen=194369449&amp;key=yt6&amp;ipbits=0&amp;gir=yes&amp;sparams=clen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>360p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 242.68MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?ratebypass=yes&amp;mime=video%2Fwebm&amp;signature=D1DAC0D58D380BC8AD94541B8B1E74FE2C17A9C2.28791366303A67E877DAA288051E367DCE52383F&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=0.000&amp;itag=43&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509692251944625&amp;clen=254472995&amp;key=yt6&amp;ipbits=0&amp;gir=yes&amp;sparams=clen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                    </tbody>\r\n" + 
			"                                                </table>\r\n" + 
			"                                                <div class=\"download-type\">\r\n" + 
			"                                                    <h3>Download Video without Sound</h3>\r\n" + 
			"                                                </div>\r\n" + 
			"                                                <span class=\"downloadInstruction\" style=\"color: #e65426;\">\r\n" + 
			"                                                    <span style=\"color: #FF5722;\">***</span> To download, right-click on the download button (or tap and hold if using mobile) and choose the Save/Download option.\r\n" + 
			"                                                    <span style=\"color: #FF5722;\">***</span>\r\n" + 
			"                                                </span>\r\n" + 
			"                                                <table cellspacing = \"0\" cellpaddinig = \"0\" border=\"0\" class=\"downloadsTable\">\r\n" + 
			"                                                    <thead>\r\n" + 
			"                                                        <tr class=\"headerRow\">\r\n" + 
			"                                                            <th>Quality</th>\r\n" + 
			"                                                            <th>Format</th>\r\n" + 
			"                                                            <th>Size</th>\r\n" + 
			"                                                            <th>Downloads</th>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                    </thead>\r\n" + 
			"                                                    <tbody>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>1080p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 491.38MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=C07780853B231F18799E276FA55BC1EB509DA001.4076E0ED198FDD87437E78AD4AD6C9927CC839AB&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=137&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688261860497&amp;clen=515244937&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>720p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 291.77MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=5F189B436B2D4FE85C5E0C311E01B6D74520D59E.6E36CA924C2F2A5DBDAAFA060C1EAA029A97244B&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=136&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688260446062&amp;clen=305941832&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>480p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 176.84MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=BCC36D59EB2E14EFE8733623EAF2EB0103EC4944.A7F4070A609A4D67512524219235B1805A26DEED&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=135&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688257845507&amp;clen=185427229&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>360p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 90.95MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=233630DD66AAB01D8875949117BC44C3A0DD8604.B48AE59319CC975CD252667946CF90C7CD7F6B48&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=134&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688257542626&amp;clen=95367804&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>240p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 45.68MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=9E10AC5229E73FBFE33971DB785B0AFBFAF68E6A.4FB495851E3A9E14FF6D15833A0995AE5A62C0D6&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=133&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688252233364&amp;clen=47895694&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>144p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 25.62MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=60C87937C736D0281DB9C3FC6A740D15298153AC.36F40251DA60A720A7EE88B1A16FEF191FB079C4&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=160&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688253620563&amp;clen=26866817&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>1080p</td>\r\n" + 
			"                                                            <td>mp4</td>\r\n" + 
			"                                                            <td> 491.38MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.mp4\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fmp4&amp;signature=C07780853B231F18799E276FA55BC1EB509DA001.4076E0ED198FDD87437E78AD4AD6C9927CC839AB&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=137&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509688261860497&amp;clen=515244937&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>1080p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 587.48MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fwebm&amp;signature=908B301D341019F52FC4F095B02BA817389BA149.16EC5A5ABEC784617EC4AFE117F8A059B65F5763&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=248&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509698874696945&amp;clen=616015816&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>720p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 298.76MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fwebm&amp;signature=883763491DB3F944672500C2AA27E9480E2A6D5F.AF238FD534391AD8D5ADD53479B057645557062C&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=247&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509696417748068&amp;clen=313271506&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>480p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 182.51MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fwebm&amp;signature=2CE62830EED11D8FF9C642F32BD4D9D22D3FD77C.1560048D2CB4D2135E3CD055C944C617D3700565&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=244&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509697251028119&amp;clen=191377523&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>360p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 102.14MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fwebm&amp;signature=4DBDAB2368DF7A0533B29EAD95C3E2E4D86A119A.B721FE03B0C79033AF9DE923DDBAFD1772CB4AB8&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=243&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509698403791262&amp;clen=107100217&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>240p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 47.13MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fwebm&amp;signature=8535A12C896AE40219F8BD383EB24AB1A02985C4.03A6DCC9785CF116CF14A5A9A6BC4B3F91293748&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=242&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509696353167216&amp;clen=49417540&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                        <tr>\r\n" + 
			"                                                            <td>144p</td>\r\n" + 
			"                                                            <td>webm</td>\r\n" + 
			"                                                            <td> 29.28MB </td>\r\n" + 
			"                                                            <td>\r\n" + 
			"                                                                <a download=\"Baby Panda:  Digging Treasure with Excavators | Car Toys &amp; Pretend Play | BabyBus.webm\" href=\"https://r3---sn-ab5sznly.googlevideo.com/videoplayback?keepalive=yes&amp;mime=video%2Fwebm&amp;signature=2282A9A5456E6F093809AF7772576DC7B52ACD44.8177F8680902EE1539BC82A300F465AF195E256C&amp;ms=au%2Crdu&amp;source=youtube&amp;mv=m&amp;mt=1554864408&amp;id=o-ABhsx4_YOxWq_6NiTNfDP4E-3EBadN41zYBtLi4aRA_0&amp;initcwndbps=91250&amp;pl=22&amp;fvip=3&amp;dur=2666.920&amp;itag=278&amp;ip=138.197.76.161&amp;mm=31%2C29&amp;mn=sn-ab5sznly%2Csn-ab5l6ndr&amp;expire=1554886107&amp;ei=e1mtXMLREMm4hgaK3qOICw&amp;c=WEB&amp;lmt=1509696353040580&amp;clen=30701876&amp;key=yt6&amp;ipbits=0&amp;aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&amp;gir=yes&amp;sparams=aitags%2Cclen%2Cdur%2Cei%2Cgir%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Ckeepalive%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&amp;requiressl=yes&amp;ratebypass=yes&amp;title=Baby+Panda:++Digging+Treasure+with+Excavators+|+Car+Toys+&amp;+Pretend+Play+|+BabyBus\">Download</a>\r\n" + 
			"                                                            </td>\r\n" + 
			"                                                        </tr>\r\n" + 
			"                                                    </tbody>\r\n" + 
			"                                                </table>\r\n" + 
			"                                            </div>\r\n" + 
			"                                        </div>\r\n" + 
			"                                    </div>\r\n" + 
			"                                </div>\r\n" + 
			"                            </body>\r\n" + 
			"                            <footer>\r\n" + 
			"                                <script>\r\n" + 
			"\r\n" + 
			"  var translationShown = false;\r\n" + 
			"\r\n" + 
			"  /* When the user clicks on the button,\r\n" + 
			"  toggle between hiding and showing the dropdown content */\r\n" + 
			"  function myFunction() {\r\n" + 
			"    // document.getElementById(\"myDropdown\").classList.toggle(\"show\");\r\n" + 
			"\r\n" + 
			"    if (translationShown == true){\r\n" + 
			"      document.getElementById(\"myDropdown\").classList.remove(\"show\");\r\n" + 
			"      translationShown = false;\r\n" + 
			"    } else{\r\n" + 
			"      document.getElementById(\"myDropdown\").classList.add(\"show\");\r\n" + 
			"      translationShown = true;\r\n" + 
			"    }\r\n" + 
			"\r\n" + 
			"  }\r\n" + 
			"\r\n" + 
			"  function showResponsiveDropdown() {\r\n" + 
			"    // document.getElementById(\"myResponsiveDropdown\").classList.toggle(\"show\");\r\n" + 
			"\r\n" + 
			"    if (translationShown){\r\n" + 
			"      document.getElementById(\"myResponsiveDropdown\").classList.remove(\"show\");\r\n" + 
			"      translationShown = false;\r\n" + 
			"    } else{\r\n" + 
			"      document.getElementById(\"myResponsiveDropdown\").classList.add(\"show\");\r\n" + 
			"      translationShown = true;\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
			"\r\n" + 
			"  // Close the dropdown menu if the user clicks outside of it\r\n" + 
			"  window.onclick = function(event) {\r\n" + 
			"    if (!event.target.matches('.dropbtn')) {\r\n" + 
			"      var dropdowns = document.getElementsByClassName(\"dropdown-content\");\r\n" + 
			"      var i;\r\n" + 
			"      for (i = 0; i < dropdowns.length; i++) {\r\n" + 
			"        var openDropdown = dropdowns[i];\r\n" + 
			"        if (openDropdown.classList.contains('show')) {\r\n" + 
			"          openDropdown.classList.remove('show');\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
			"  \r\n" + 
			"                                </script>\r\n" + 
			"                                <div>\r\n" + 
			"                                    <ul>\r\n" + 
			"                                        <li>\r\n" + 
			"                                            <a href=\"https://qdownloader.net\">Home</a>\r\n" + 
			"                                        </li>\r\n" + 
			"                                        <li>\r\n" + 
			"                                            <a href=\"https://qdownloader.net/policies/terms-of-service\">Terms</a>\r\n" + 
			"                                        </li>\r\n" + 
			"                                        <li>\r\n" + 
			"                                            <a href=\"https://qdownloader.net/policies/copyright\">Copyright (DMCA)</a>\r\n" + 
			"                                        </li>\r\n" + 
			"                                    </ul>\r\n" + 
			"                                </div>\r\n" + 
			"                                <div class=\"copyright\">\r\n" + 
			"    Copyright © 2018 QDownloader. All rights reserved.\r\n" + 
			"  </div>\r\n" + 
			"                                <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
			"                                <script src=\"https://qdownloader.net/inc/js.cookie.js\"></script>\r\n" + 
			"                                <script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"  $(document).ready(function() {\r\n" + 
			"\r\n" + 
			"        var searchVideo = true;\r\n" + 
			"\r\n" + 
			"        $(\"#downloadForm\").submit(function(event) {\r\n" + 
			"            submitTheForm(event);\r\n" + 
			"        });\r\n" + 
			"\r\n" + 
			"        $(\"#downloadBtn\").click(function(event){\r\n" + 
			"\r\n" + 
			"            submitTheForm(event);\r\n" + 
			"\r\n" + 
			"        });\r\n" + 
			"\r\n" + 
			"        function submitTheForm(event){\r\n" + 
			"\r\n" + 
			"          event.preventDefault();\r\n" + 
			"\r\n" + 
			"          var downloadUrl = document.forms[\"downloadForm\"][\"video\"].value;\r\n" + 
			"\r\n" + 
			"          if (downloadUrl==null || downloadUrl==\"\"){\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"          } else {\r\n" + 
			"\r\n" + 
			"            if (searchVideo == true){\r\n" + 
			"\r\n" + 
			"              var that = $(\"#loading-message\");\r\n" + 
			"              var that1 = $(\"#dlSection\");\r\n" + 
			"              var that2 = $(\"footer\");\r\n" + 
			"              var that3 = $(\"#appInfo\");\r\n" + 
			"              var that4 = $(\".bannera\");\r\n" + 
			"\r\n" + 
			"                              that.css('display','block');\r\n" + 
			"                that1.css('display','none');\r\n" + 
			"                that2.css('display','none');\r\n" + 
			"                that4.css('display','none');\r\n" + 
			"              \r\n" + 
			"\r\n" + 
			"              \r\n" + 
			"              searchVideo = false;\r\n" + 
			"\r\n" + 
			"              setTimeout(function(){\r\n" + 
			"                $('#downloadForm')[0].submit();\r\n" + 
			"              },20);\r\n" + 
			"\r\n" + 
			"              setTimeout(\r\n" + 
			"              function() {\r\n" + 
			"                searchVideo = true;\r\n" + 
			"              }, 30000);\r\n" + 
			"\r\n" + 
			"              if(Cookies.get('dld121')){\r\n" + 
			"\r\n" + 
			"              } else {\r\n" + 
			"                var adLink = 'https://p276234.clksite.com/adServe/banners?tid=BUTTON_QDOWNCONVERTER&action=r';\r\n" + 
			"                // var adLink = 'https://deloplen.com/afu.php?zoneid=2369248';\r\n" + 
			"                window.open(adLink, '_blank');\r\n" + 
			"                // var minutes = 60 * 1;\r\n" + 
			"                var minutes = 10;\r\n" + 
			"                var date =  new Date();\r\n" + 
			"                date.setTime(date.getTime() + (minutes * 60 * 1000));\r\n" + 
			"                Cookies.set('dld121', '1', { expires: date });\r\n" + 
			"\r\n" + 
			"              //   var e = window.open(this.adUrl, \"_blank\");\r\n" + 
			"              // e ? e.focus() : window.open(this.adUrl), this.updateCookies()\r\n" + 
			"              }\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"            } else {\r\n" + 
			"            }\r\n" + 
			"\r\n" + 
			"          }\r\n" + 
			"\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"  });\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"      </script>\r\n" + 
			"                            </footer>";
	
	public static void main(String[] args) {
		
		String html = ImageDownloadInfoData.testParseData;
		
		
		Document doc = Jsoup.parse(html);
		/**
		 * parse video info(解析视频基础信息)
		 * info block[视频信息块]
		 * 
		 */
		Element videoInfoElem = doc.getElementsByClass("info col-md-4").get(0);
		
		String imgURL = videoInfoElem.getElementsByTag("img").attr("src");
		String title = videoInfoElem.getElementsByTag("span").get(0).text();

		//parse duration
		Document videoInfoDoc = Jsoup.parse(videoInfoElem.toString());
		Elements divElems = videoInfoDoc.select("div>div");
		String durationSpan = divElems.get(0).html();
		
		String duration = durationSpan.split("</span>")[1].trim();
		
		
		System.out.println(
				"title->"  + title  + "\n"
			  + "imgURL->" + imgURL + "\n"
			  + "duration->" + duration  + "\n"
//			  + "durationSpan->" + durationSpan  + "\t"
				);
		
		/**
		 * 解析视频格式及列表
		 * 
		 */
		Elements videoDetailElem = doc.getElementsByClass("downloadsTable");
		
		int cnt=0;
		
		for (Element element : videoDetailElem) {
			//是否有声音
			boolean hasVideoVoice = false ;
			if(cnt==0) { // sound video block
				hasVideoVoice = true;
				parseVideoQualityList(element,hasVideoVoice);
			} else if(cnt==1) { // mute video block
				parseVideoQualityList(element,hasVideoVoice);
			} 
			cnt++;
			if(cnt>=2) {
				break;
			}
		}
		
	}

	/**
	 * 解析视频数据
	 * @param element
	 * @param hasVideoVoice
	 */
	public static void parseVideoQualityList(Element element, boolean hasVideoVoice) {
		//表头
//				Elements theadBlock = element.getElementsByTag("thead");
		//表正文
		Elements tbodyBlock = element.getElementsByTag("tbody");
//				System.out.println("\n\n"+tbodyBlock);
		
		
		String voiceInfo = hasVideoVoice ? "有声音视频" : "无声音视频";
		System.out.println("=================" + voiceInfo + "=================");
		
		// parse video list from tbodyBlock
		Elements videoList = tbodyBlock.get(0).getElementsByTag("tr");
		for (Element videoDownloadInfoElem : videoList) {
			// 解析各分辨率视频信息
			Elements cellAttr = videoDownloadInfoElem.getElementsByTag("td");
			
			String quality = cellAttr.get(0).text();
			String formater = cellAttr.get(1).text();
			String size = cellAttr.get(2).text();
			String downloads = cellAttr.get(3).getElementsByTag("a").attr("href");
			
			System.out.println("downloadInfo->\n"
					+ "quality->" + quality + "\t"
					+ "formater->" + formater + "\t"
					+ "size->" + size + "\t\n"
					+ "downloads->" + downloads + "\t\n"
					);
		}
	}
	
	public void downloadFiles() {
		String fileURL = "https://i.ytimg.com/vi/E7rdLT2xs9o/maxresdefault.jpg";
	}
	
}
