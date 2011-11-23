/**
 *页数的显示
 *不包括提交
 *<script src="<%=request.getContextPath() %>/js/pageInfo.js" type="text/javascript"></script>
 *使用：只需要在页面加载的时候即onload="initPage(${pageInfo.totalPage},${pageInfo.pageIndex},${pageInfo.pageSize},${pageInfo.totalRec})",
 *								传过来四个参数，一个是总页数，一个当前页数,一个是当前每页记录条数，一个是总条数
 	
 *	<s:form action="" id="pageForm" name="pageForm"> 		
 *  	<s:hidden name="pageInfo.pageIndex" id="pageIndex"/>
 *  	<s:hidden name="pageInfo.pageSize" id="pageSize"/>	
 * 	</s:form>
 *	注:把这个表单复制到页面body里，id不能变，至少包含两个hidden
 *
 */

var total = 0;//总页数
var pageIndex = 0;//当前页数
var pageSize = 0;//每页记录数
var totalRec = 0;//总记录数
var pageInfo = new PageInfo();
var arg3s;//存储第一个查询信息时的查询条件
function initPage(total, pageIndex, pageSize, totalRec) {//初始化页面
	this.total = total;
	this.pageIndex = pageIndex;
	this.pageSize = pageSize;
	this.totalRec = totalRec;
	showPageSize();
	showPages();
}

function showPages() {//显示页数
	//var i=((pageIndex-(pageIndex%5))/5)*5+1;
	var i = (Math.ceil(pageIndex / 5) - 1) * 5 + 1;
	$("#Flexigrid_Bar").html(""); //初始化标签
	if (i == 1) { //如果当前为第一页，则不能向前翻页
		$("#Flexigrid_Bar").append("<span>&lt;&lt;上5页</span>");
	} else {
		$("#Flexigrid_Bar").append(
				"<a id='upPage' href="
						+ "\"javascript:ajaxPage('back')\">&lt;&lt;上5页</a>");
	}
	$("#Flexigrid_Bar").append("&nbsp;");
	var n = 5;
	while (n--) {
		if (i == pageIndex) {//如果为当前页
			$("#Flexigrid_Bar").append("<font color='red'>" + i + "</font>");
		} else {
			$("#Flexigrid_Bar").append(
					"<a class='indexPage' href='javascript:ajaxPageClick(" + i
							+ ")'>" + i + "</a>");
		}
		$("#Flexigrid_Bar").append("&nbsp;");
		if (i >= total)
			break; //如果达到最后一页了,刚跳出
		i++;
	}

	if (((Math.ceil(pageIndex / 5)) * 5) < total) {//如果
		$("#Flexigrid_Bar").append(
				"<a id='downPage' href="
						+ "\"javascript:ajaxPage('front')\">下5页&gt;&gt;</a>");
	} else {
		$("#Flexigrid_Bar").append("<span>下5页&gt;&gt;</span>");
	}
	$("#Flexigrid_Bar").append("&nbsp;");
}

//显示每页记录数按钮
//javascript:changeCount(),此函数为点击事件。
function showPageSize() {
	var num = 10;
	$("#setupNum").html("");//初始化
	$("#setupNum").append("<span>每页显示数量:</span>");
	$("#setSize").width(50);
	$("#setSize").empty();
	for ( var i = 10; i <= 50; i += 20) {
		var opt = $("<option value='" + i + "'>" + i + "</option>");
		$("#setSize").append(opt);
	}
	setTimeout(function() {////由于jquery传统的select选值方法对于ie6不再适应，只能使用这种方式,在增加select options时，立即选择其中的项目，可能会导致错误：无法设置selected 未指明的错误
				$("#setSize").val(pageSize)
			}, 0.1)

	//显示“共几页，几条”
	$("#AllPage").html("");
	$("#AllPage").append("共" + total + "页/共" + totalRec + "条");

	//显示查看第几页
	$("#checkPage").html("");
	$("#checkPage")
			.append(
					"<input type='text' id='txtPage' name='txtPage' size='5'/><span>页</span><a id='goPage' href='javascript:ajaxGoPage();'>GO</a>");

}

//跳到第几页
function ajaxGoPage() {
	var page = $("#txtPage").attr("value");
	var checkPage = /^\d+$/;//正则表达示验证数字
	var pagetotal = total;
	if (page == null || page == "" || !checkPage.test(page)) {
		alert("请输入一个正整数!");
		return;
	}
	if (page > pagetotal) {
		alert("已经达到最大页数，无法继续查看到!");
		return;
	}
	if (page < 1) {
		alert("请输入一个大于0的整数!");
		return;
	}
	var index = page;
	var size = $("#setSize").val();
	pageInfo.pageIndex = index;
	pageInfo.pageSize = size;
	executeQuery();
	$("#setSize").empty();
}

//点击页数
function ajaxPageClick(i) {
	var index = i;
	var size = $("#setSize").val();
	//alert("index  " + index)
	//	alert("size  " + size)
	pageInfo.pageIndex = index;
	pageInfo.pageSize = size;
	executeQuery();
	$("#setSize").empty();
}

//点击每页记录数
function ajaxChangeCount(pSize) {
	var index = 1;
	var size = pSize;
	pageSize = pSize;
	pageInfo.pageIndex = index;
	pageInfo.pageSize = size;
	executeQuery();
	$("#setSize").empty();
}

//向前向后翻页
function ajaxPage(method) {
	if (method == "back") {
		pageIndex = (Math.ceil(pageIndex / 5) - 1) * 5;
	} else {
		pageIndex = (Math.ceil(pageIndex / 5)) * 5 + 1;
	}
	var index = pageIndex;
	var size = $("#setSize").val();
	pageInfo.pageIndex = index;
	pageInfo.pageSize = size;
	executeQuery();
	$("#setSize").empty();
}
/**
 * 执行分页查询
 * @param 1.当调用executeQuery()即不传参数时，表示此时非第一次查询 2传参数时表第一次查询，此时参数是一个对象，需调用 下面的dealArgs方法对参数进行处理后再传进这个方法
 * @memberOf {TypeName} 
 */
function executeQuery(remoteFunction,remoteArgs) {

	if (arguments.length==0) {
		args = arg3s;
	} else {
		args=dealArgs(remoteFunction,remoteArgs);
		arg3s = args;

	}

	var arg0s = args.arguments;//所有要传给dwr的基本参数，不包括回调方法和分页对象
	var arg1s = [];//用于存要传给dwr的所有参数，包括回调方法和分页对象
	var i = 0
	for (i = 0; i < arg0s.length; i++) {
		arg1s.push(arg0s[i]);//加入参数
	}
	arg1s.push(pageInfo);//给参数加上分页对象
	arg1s.push(args.callBackFunction);
	args.remoteFunction.apply(this, arg1s);//动态执行远程的dwr方法，并将参数传进

}

//第一个参数为dwr远程方法名,第二个为远程方法的所有参数（最后一个为回调方法）
function dealArgs(remoteFunction,remoteArgs){
	var args = {};
	args.remoteFunction = remoteFunction;//要执行的远程方法
	args.arguments = [];
	for(var i=0;i<remoteArgs.length;i++){
		
		if(i==remoteArgs.length-1&&typeof remoteArgs[i]=='function'){
			args.callBackFunction = remoteArgs[i];
		}else{
			args.arguments.push(remoteArgs[i]);
		}
	}
	return args;
}