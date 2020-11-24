<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" href="css/orderInfoSure_style.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
<div id="bodyPart">
	<div id="top">
		<div id="logo"></div>
		<div id="Cart">
			<ul>
				<li id="myCart">1.我的购物车</li>
				<li id="writeInfo" class="white">2.填写核对订单信息</li>
				<li id="successSub">3.成功提交订单</li>				
			</ul>
		</div>
	</div>
	<div class="List_cart">
		<h2>
			<strong>填写核对订单信息</strong>
		</h2>
				
		<div class="cart_table">		
			<div id="part_consignee">
				<div class="o_show">
			
					<h1>
					收货人信息&nbsp;<a href="#">[修改]</a>
					</h1>
			
					<div class="middle">
						<input  id="address_id" type="hidden" value="${address.reveive_address_id}"/>
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td align="right" style="width: 80px;">收货人姓名：</td>
								<td>${address.receive_name}</td>
							</tr>
							
							<tr>
								<td align="right">省　　份：</td>
								<td>${address.province}</td>
							</tr>
						
							<tr>
								<td align="right">地　　址：</td>
								<td>${address.address}</td>
							</tr>
						
							<tr>
								<td align="right">手机号码：</td>
								<td>${address.mobile}</td>
							</tr>
						
							<tr>
								<td align="right">固定电话：</td>
								<td>${address.telephone}</td>
							</tr>
						
							<tr>
								<td align="right">电子邮件：</td>
								<td>${address.email}</td>
							</tr>
						
							<tr>
								<td align="right">邮　　编：</td>
								<td>${address.zipcode}</td>
							</tr>
												
						</table>
					</div>
				</div>
			</div>		


			<div id="part_payTypeAndShipType">
				<div class="o_show">
					<h1>支付及配送方式&nbsp;<a href="#" id="linkPayTypeShipType">[修改]</a></h1>
     				<div class="middle">
						<table cellpadding="0" cellspacing="0">
							  <tr>
								  <td style="text-align: right; width: 80px;">支付方式：</td>
								  <td>在线支付</td>
							  </tr>
							  <tr style="">
								  <td style="text-align: right;">配送方式：</td>
								  <td>京东快递</td>
							  </tr>
							  <tr>
								  <td style="text-align: right;">运　　费：</td>
								  <td>0.00元<span style="color: red;">(免运费)</span></td>
							  </tr>
							  <tr>
								  <td style="text-align: right;">送货日期：</td>
								  <td style="color: red;">只双休日、假日送货(工作日不用送)</td>
							  </tr>
						</table>
       				</div>
				</div>
			</div>


			<div id="part_invoice">
				<div class="o_show">
					 <h1>发票信息&nbsp;<a href="#">[修改]</a></h1>
					  <div class="middle">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td style="text-align: right; width: 82px;">发票类型：</td>
									<td>普通发票</td>
								</tr>
								<tr>
									<td style="text-align: right;">发票抬头：</td>
									<td>个人 </td>
								</tr>
								 <tr>
								   <td style="text-align: right;">发票内容：</td>
								   <td>明细</td>
								</tr>
							</table>
					   </div>
				 </div>			 
			</div>


			<div id="part_remark">
				<div class="o_show">
				   <h1>订单备注&nbsp;<a href="#">[修改]</a></h1>
					 <div class="middle">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td style="text-align: left; padding-left: 20px;">暂无备注</td>
							</tr>
						</table>
					</div>
				</div>
			</div>


			<div id="part_cart">
				<div class="o_show">
				   <h1><span style="margin-right: 700px;">商品清单</span><a  href="myCart.html" id="backCart">返回修改购物车</a></h1>
				   <div class="middle">
					   <table width="100%" cellspacing="0" cellpadding="0" class="Table">
						 <tr class="align_Center Thead">
							<td width="7%">商品编号</td>
							<td>商品名称</td>
							<td width="10%">京东价</td>
							<td width="8%">返现</td>
							<td width="8%">赠送积分</td>
							<td width="9%">库存状态</td>
							<td width="9%">商品数量</td>
						 </tr>
						<c:forEach items="${cart}" var="cartItem">
						<tr class="align_Center">
							 <td style="padding: 5px 0pt;">${cartItem.product_id}</td>
							 <td class="align_Left">
							 	<a href="#">${cartItem.name}</a>
								<div><span class="tip_bag">[赠品]</span>相机包 <font color="red">×1</font></div>
				
							 </td>
							 <td>￥<span class="price">${cartItem.lower_price}</span></td>
							 <td>￥${cartItem.back_money}</td>
							 <td>${cartItem.score}</td>
							 <td>现货</td>
							 <td>${cartItem.product_count}</td>
						</tr>
						</c:forEach>
					 </table>
				   </div>
				</div>
			</div>	
	

			<div id="ware_info">
				<div id="acc_info">结算信息</div>
				<h1></h1>
				<div class="middle">
					<ul id="part_info">
						<li style="padding-bottom: 5px;" class="info1">商品金额：${sum_price}元 + 运费：0.00元 - 优惠券：<span id="price_coupon">0.00</span>元 - 礼品卡：<span id="price_coupon">0.00</span>元 - 返现：0.00元
						<br>
						</li>

						<li style="width: 100%; overflow: hidden;" class="info2">
							 <table cellspacing="0" cellpadding="0" width="100%">
								<tr>
								  <td><a href="#">(<span id="couponStateShow">+</span>)使用优惠券抵消部分总额</a>            </td>
								  <td style="text-align: right; font-size: 15px;"><b>应付总额：￥<font color="red" id="sum_price">${sum_price}</font> 元</b></td>
							   </tr>
								<tr>
								  <td colspan="2"><a href="#">(<span id="couponStateShow">+</span>)使用京东礼品卡</a>            </td>
							   </tr>
							</table>
						</li>
                    </ul>
				</div>				
			</div>


			<div id="submit_btn" onclick="sendOrderInfo()"><a href="javascript:"><img src="img/submit.jpg"/></a></div>
			<div id="line"></div>
		</div><!----cart_table结束---->
		
		<div class="round">
			<div class="lround"></div>
			<div class="rround"></div>
		</div>			
	</div>	
</div>
<script type="text/javascript">
    function sendOrderInfo() {
        var  part_cart = $("#part_cart tr");
        var  param_obj = new Object();
        param_obj.total_price = $("#sum_price").html();
        param_obj.bak = $("#part_remark td").html();
        param_obj.reveive_address_id = $("#address_id").val();
        param_obj.status = "下单成功";

        var  items = new Array();
        part_cart.each(function getTd(index,e) {
            //alert(index);
            if (index != 0){
                var item = new Object();
                item.product_id  = $(e).find("td").eq(0).html();
                item.product_price = $(e).find("td .price").html();
                item.product_num = $(e).find("td").eq(6).html();
                items[index-1] = item;
            }
        });
        param_obj.items = items;
        $.ajax({
            url:"orderSubmit",
            type:"post",
            success:function (datas) {
                //把总价格 和 订单 id 传到下一个页面
                window.location.href = datas.location+"?order_id="+datas.order_id;
            },
            contentType:"application/json",
            data:JSON.stringify(param_obj)
        });
    }
</script>

<!-- 页脚类型1 -->
<%@include file="footer1.jsp"%>
</body>
</html>
