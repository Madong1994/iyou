/**
 * Created by hxjd on 2018/1/8.
 */

/**
 * 初始化容器尺寸
 * @param $obj 需要初始化尺寸的jq对象
 * @param isIndex 由于首页和其他页面存在一个控制栏高度的差别，这里用次标志区分
 */
function initSize($obj, isIndex)
{
    var width = document.documentElement.clientWidth;
    var height = $(window).height();
    if(isIndex)
    {
        $obj.css({width: width, height: height - 112});//112是控制栏
    }
    else
    {
        $obj.css({width: width, height:height });
    }
     //onWindowResize();
}