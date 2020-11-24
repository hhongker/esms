<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>京东商城 - 图书频道首页</title>
<link rel="stylesheet" type="text/css" href="css/book.css" />
<link rel="stylesheet" type="text/css" href="css/book_list.css" />
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap-paginator.js"></script>

    <script type="text/javascript">
    // 在这里 定义五个js 的全局变量
    var  first_category_id = -1;
    var  order_std = "print_number";
    var  order_type = "desc";
    var  start_pos = 0;
    var  page_size = 4;
    // 页面加载完成时 给ul 下的 li 绑定点击事件
    $(function(){
        $(".item.tab li").on("click",function () {
            //alert($(this).attr("class"));
            // 点击li 时 给第一个分类id 的变量赋值
            first_category_id = $("#first_category_id").val();
            order_std = $(this).attr("name");
            //alert(order_std);
            var classStr = $(this).attr("class");
            // 如果classStr 中包含 up 则替换成 down  如果包含down 则替换成up 否则追加down
            if (classStr.indexOf("up") != -1){
                classStr = classStr.replace("up","down");
                order_type = "desc";
            } else if (classStr.indexOf("down") != -1){
                classStr = classStr.replace("down","up");
                order_type = "asc";
            } else{
                classStr += " down";
                order_type = "desc";
            }
            $(this).attr("class",classStr);
            // 去掉li 上的 id 属性
            $(".item.tab li").removeAttr("id");
            // 给当前加一个id
            $(this).attr("id","filter-curr");
            start_pos = 0;
            page_size = 4;
            // 凑齐了 五个参数了 可以发送ajax 了
            $.ajax({
                url:"bookListAJAX",
                type:"post",
                success:function (datas) {
                    //alert(products)
                    //拼接booklist的html
                    var str ='';
                    for(var i=0;i < datas.length;i++){
                        var d = datas[i];
                        str+='<div class="pro_item">';
                        str+='<div class="pro_picture"><a href="${pageContext.request.contextPath }/bookDetail.do?&productId='+d.product_id+'"><img src="'+d.picture+'" /></a></div>'
                        str+='<div class="pro_info">';
                        str+='<div class="pro_up">';
                        str+='<div class="bookName"><a href="${pageContext.request.contextPath }/bookDetail.do?&productId='+d.product_id+'"  style="display: inline-block;width: 600px;overflow: hidden;">'+d.name+'</a></div>';
                        str+='<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>'+d.author+'</span> 著，译<br />出&nbsp;版&nbsp;社：<span>'+d.publishing+'</span><br /></div>';
                        str+='</div>';
                        str+='<div class="pro_down">';
                        str+='<div class="pro_left">';
                        str+='出版时间：'+d.publish_time+'<br />';
                        str+='定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥'+d.fixed_price+'</s>';
                        str+='</div>';
                        str+='<div class="pro_right">';
                        str+=' 顾客评价：<span class="star" style="display:inline-block;width:65px;background-position-x: -'+(5-datas[i].score)*13+'px;"></span>（<a href="${pageContext.request.contextPath }/commentView.do?productId='+d.product_id+'"><span>已有'+123+'人评价<span></a>）<br />';
                        str+='销量：<b><font>￥'+d.print_number+'</font></b><span class="user_price"></span> 京东价：<b>￥'+d.lower_price+'</b>（'+Math.ceil(d.vip_price/d.fixed_price*100)+'折)';
                        str+='</div>';
                        str+='</div>';
                        str+='<div class="clear"></div>';
                        str+='<div class="book_btn">';
                        str+='<a href="${pageContext.request.contextPath}/initCart?product_id='+d.product_id+'" class="buy"></a><input type="button" value="收藏" class="favorite" onclick="addCollection(this)" name="'+d.product_id+'"/><h2 style="padding:4px;color:red;"></h2>';
                        str+='</div>';
                        str+='</div>';
                        str+='</div>';
                    }
                    //将列表设置到页面上
                    $(".product_list").html(str);
                },
                data:{first_category_id:first_category_id,order_std:order_std,
                  order_type:order_type,start_pos:start_pos,page_size:page_size},
                dataType:"json"
            });
        });
    });
</script>
</head>
<body id="book">
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>
<!--头部导航结束-->
<div class="clear"></div>
<!--位置-->
<div id="position" class="page_width">
	<ul>
     	<li><a href="#">首页</a></li>
        <li>&gt;</li>
     	<li><a href = "#">图书</a></li>
        <li>&gt;</li>
     	<li><a href="#">小说</a></li>
        <li>&gt;</li>
     	<li><a href="#">中国当代小说</a></li>
     </ul>
</div>
<!--主体main部分开始-->
<div class="clear"></div>

<div id="main" class="page_width">
<!--左侧开始-->
	<div id="left_list">
    	<div id="same_sort">
			<div class="book_tit" style="width:209px;"><h2>浏览同级分类<br /><span>Browse other categories</span></h2></div>
				<div class="book_content">
					<ul>
                        <c:forEach items="${categories}" var="category">
                        <li><a href='#'>${category.name}</a></li>
                        </c:forEach>

                    </ul>
                    <div class="clear"></div>
					<div class="extra"><a href="#">返回上级分类&gt;&gt;</a></div>
				</div>
			</div>	
			
            <div class="books">
			<div class="book_title">
				<h2>新书推荐<br /><span>New Releases</span></h2>
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src="img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src="img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="bookDetail.jsp" target="_blank"><img src="img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			</div>
            
		
			<div class="ad_left_list">
            	<div class=""><a href="#" target="_blank"><img src="img/book_61.jpg" /></a></div>
				<div class=""><a href="#" target="_blank"><img src="img/book_47.jpg"></a></div>
			</div>

    </div>
<!--左侧结束-->

<!--右侧开始-->    
    <div id="right_list">
        <input type="hidden" value="${first_category_id}" id="first_category_id" />
        <input type="hidden" value="${sumPages}" id="sumPages" />
		<div id="filter">
			<div class="fore item">排序：</div>
			<ul class="item tab">
                <li  class='down' id='filter-curr' name="print_number"><b></b><a >销售排行</a><span></span></li>
                <li   class='up price' name="lower_price"><b></b><a >价格</a><span></span></li>
                <li  class="up discount"><b></b><a href='#'>折扣</a><span></span></li>
                <li class="down"><b></b><a href='#'>好评度</a><span></span></li>
                <li  class='down'><b></b><a href='#'>上架时间</a><span></span></li>
                <li  class="down"><b></b><a href='#'>出版时间</a><span></span></li>
			</ul>
			<span class="clear"></span>
		</div>
        
        <div class="page" >
             <div id="page"></div>
		</div>
        
        <div class="clear"></div>
        
        <div class="product_list">
            <c:forEach items="${products}" var="product">
        	<div class="pro_item">
            	<div class="pro_picture"><a href="bookDetail.jsp"><img src="${product.picture}" /></a></div>
                <div class="pro_info">
                	<div class="pro_up">
                    	<div class="bookName"><a href="bookDetail.jsp">${product.name}</a></div>
                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>${product.author}</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>
                    </div>
                    <div class="pro_down">
                    	<div class="pro_left">
                    	出版时间：${product.publish_time}<br />
                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥${product.fixed_price}</s>
                        </div>
                        <div class="pro_right">
                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />
                        销量：<b><font>${product.print_number}</font></b><span class="user_price"></span>
                            京东价：<b>￥${product.lower_price}</b>（43折)
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="book_btn">
                    <a href="initCart?product_id=${product.product_id}" class="buy"></a><input type="button" value="收藏" class="favorite" />
                    </div>
                </div>            
            </div>
            </c:forEach>

        </div><!--列表结束-->
        
        <div class="page">
			<img src="images/page.jpeg" />
		</div>
          
    </div>
<!--右侧结束-->
</div>

<div class="clear"></div>
<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
<script type="text/javascript">
    $(function(){
        var  sumPages = $("#sumPages").val();
        var options={
            bootstrapMajorVersion:1,    //版本
            currentPage:1,    //当前页数
            numberOfPages:sumPages < page_size?sumPages : page_size,    //最多显示Page页
            totalPages:sumPages,    //所有数据可以显示的页数
            onPageClicked:function(e,originalEvent,type,page){
                console.log(page);
                // 发送ajax 请求
                //  给first_category_id 再次赋值
                first_category_id = $("#first_category_id").val();
                $.ajax({
                    url:"bookListAJAX",
                    type:"post",
                    success:function (datas) {
                        //alert(products)
                        //拼接booklist的html
                        var str ='';
                        for(var i=0;i < datas.length;i++){
                            var d = datas[i];
                            str+='<div class="pro_item">';
                            str+='<div class="pro_picture"><a href="${pageContext.request.contextPath }/bookDetail.do?&productId='+d.product_id+'"><img src="'+d.picture+'" /></a></div>'
                            str+='<div class="pro_info">';
                            str+='<div class="pro_up">';
                            str+='<div class="bookName"><a href="${pageContext.request.contextPath }/bookDetail.do?&productId='+d.product_id+'"  style="display: inline-block;width: 600px;overflow: hidden;">'+d.name+'</a></div>';
                            str+='<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>'+d.author+'</span> 著，译<br />出&nbsp;版&nbsp;社：<span>'+d.publishing+'</span><br /></div>';
                            str+='</div>';
                            str+='<div class="pro_down">';
                            str+='<div class="pro_left">';
                            str+='出版时间：'+d.publish_time+'<br />';
                            str+='定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥'+d.fixed_price+'</s>';
                            str+='</div>';
                            str+='<div class="pro_right">';
                            str+=' 顾客评价：<span class="star" style="display:inline-block;width:65px;background-position-x: -'+(5-datas[i].score)*13+'px;"></span>（<a href="${pageContext.request.contextPath }/commentView.do?productId='+d.product_id+'"><span>已有'+123+'人评价<span></a>）<br />';
                            str+='销量：<b><font>￥'+d.print_number+'</font></b><span class="user_price"></span> 京东价：<b>￥'+d.lower_price+'</b>（'+Math.ceil(d.vip_price/d.fixed_price*100)+'折)';
                            str+='</div>';
                            str+='</div>';
                            str+='<div class="clear"></div>';
                            str+='<div class="book_btn">';
                            str+='<a href="${pageContext.request.contextPath}/initCart.do?productId='+d.product_id+'" class="buy"></a><input type="button" value="收藏" class="favorite" onclick="addCollection(this)" name="'+d.product_id+'"/><h2 style="padding:4px;color:red;"></h2>';
                            str+='</div>';
                            str+='</div>';
                            str+='</div>';
                        }
                        //将列表设置到页面上
                        $(".product_list").html(str);
                    },
                    data:{first_category_id:first_category_id,order_std:order_std,
                        order_type:order_type,start_pos:(page-1)*page_size,page_size:page_size},
                    dataType:"json"
                });
            }
        }
        $("#page").bootstrapPaginator(options);
    })
</script>
</html>
