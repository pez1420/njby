/**
 * Created by Administrator on 2015/4/1.
 */

define(["jquery", "slider", "fancybox", "fancyboxbutton","online"], function($, slider, fancybox, fancyboxbutton, online){
    var init_page = function () {
        $(function() {
            $("#slider").responsiveSlides({
                auto: true,
                nav: true,
                speed: 500,
                namespace: "callbacks",
                pager: true
            });

            $('.fancybox-buttons').fancybox({
                openEffect  : 'none',
                closeEffect : 'none',
                prevEffect : 'none',
                nextEffect : 'none',
                closeBtn  : false,

                helpers : {
                    title : {
                        type : 'inside'
                    },
                    buttons	: {}
                },

                afterLoad : function() {
                    this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
                }
            });
        });

        online.init_online_consulting();
    };

    return {
        init_page : init_page
    };
});