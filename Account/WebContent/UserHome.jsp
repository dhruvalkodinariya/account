<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello index.jsp</h2>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserHome</title>
<link rel="stylesheet" type="text/css" href="css/autocomplete.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<style type="text/css">
html, body {
	font-family: Verdana, Geneva, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #E4E4E4;
}
</style>
</head>
<body>
		<%
	    HttpSession s = request.getSession(false);
		String str=null;
		String id=null;
		String company=null;
		if(s!=null){
			str = (String)s.getAttribute("uname");
			company = (String)s.getAttribute("company");
            id = (String)s.getId(); 
		}
           
           if(str!=null){
            	
        %>
         <%-- <h3> </h3>        
        <h3> Welcome, <%=id%></h3>
        
        <a href="Logout.jsp">Logout</a> --%>
        
	<div class="main">
		<div class="main-header">
			<div class="main-header-wrapper">
				<div class="login-controls flex">
					<div class="login-control-wrapper"></div>
				</div>
			</div>

		</div>
		<div class="mainHeadPanel">
		<div class="blankDiv">
		
		</div>
		<div>
			<div class="logout"> Welcome <a href="changepassword.jsp" title="Click here to change your password"><%=str%></a> |  <a href="Logout.jsp" style="color:red;"> Logout</a></div>
            <div class="shopname"><%=company%></div>
		</div>
			
                                
        </div>
		
		<div class="layout horizontal" id="menudatadiv">
			<div style="width: 328px;"></div>
		</div>
		<div class="main-content layout horizontal flex">
			<div class="drawer-menu">
				<ul class="drawer-list">
					<li class="drawer-item layout horizontal" lang="dashboard">
						<span class="layout vertical center-center"> <i class="fas fa-chart-pie"></i>
					</span> <a href="#" name="Dashboard">Dashboard</a>
					</li>
					<li class="drawer-item layout horizontal selected" lang="contactmain"><span
						class="layout vertical center-center"> <i class="far fa-address-book"></i>
					</span> <a href="#" name="Contact">Contacts</a></li>
					<li class="drawer-item layout horizontal" lang="bank"><span
						class="layout vertical center-center"> <i class="fas fa-university"></i>
					</span> <a href="#" name="Bank">Bank accounts</a></li>
					<li class="drawer-item layout horizontal" lang="salesmain"><span
						class="layout vertical center-center"> <i class="fas fa-chart-line"></i>
					</span> <a href="#" name="Sales">Sales</a></li>
					<li class="drawer-item layout horizontal" lang="purchasemain"><span
						class="layout vertical center-center"> <i class="fas fa-shopping-cart"></i>
					</span> <a href="#" name="Purchase">Purchases</a></li>
					<li class="drawer-item layout horizontal" lang="itemmain"><span
						class="layout vertical center-center"> <i class="fas fa-shopping-basket"></i>
					</span> <a href="#" name="Item">Items</a></li>
					<li class="drawer-item layout horizontal" lang="paymentmain"><span
						class="layout vertical center-center""> <i class="fas fa-credit-card"></i>
					</span> <a href="#" name="Payment/Receipt">Payments/Receipts</a></li>
					<li class="drawer-item layout horizontal" lang="jvmain"><span
						class="layout vertical center-center"> <i class="fas fa-notes-medical"></i>
					</span> <a href="#" name="Journal Voucher">Journal vouchers</a></li>
					<li class="drawer-item layout horizontal" lang="reportmain"><span
						class="layout vertical center-center"> <i class="fas fa-clipboard-check"></i>
					</span> <a href="#" name="Report">Report</a></li>
					<li class="drawer-item layout horizontal" lang="ledgermain"><span
						class="layout vertical center-center"> <i class="fas fa-clipboard-list"></i>
					</span> <a href="#" name="Legder">Legder</a></li>
					<li class="drawer-item layout horizontal" lang="settingsmain"><span
						class="layout vertical center-center""> <i class="fas fa-cogs"></i>
					</span> <a href="#" name="Settings">Settings</a></li>
				</ul>
			</div>
			<div class="content-area">
				<div id="dataContainer"></div>
			</div>
		</div>

	</div>
	<div class="mask"></div>
	<div id="actionBar">
		<div class="layout horizontal">
			<div class="flex layout vertical center-center selectedText">Selected</div>
			<div class="layout horizontal self-end">
				<span style="margin-right: 12px;"> <i class="fas fa-cogs"></i>
				</span> <span style="margin-right: 12px;"> <i class="fas fa-cogs"></i>
				</span> <span style="margin-right: 12px;"> <i class="fas fa-cogs"></i>
				</span>
			</div>
		</div>
	</div>
	<div id="actionBar1"></div>
	<div class="loading-container" id="loading-container"></div>
	<div class="dialog-container" id="dialog-container"></div>
	<script src="js/jquery.min.js"></script>
	<!-- <script src="js/jquery.migrate.js"></script> -->
	<script src="js/autocomplete.js"></script>
	<script src="js/accounting.min.js"></script>
	<script src="js/userHome.js"></script>
	<script src="js/popup.js"></script>
	<script src="js/createNavigation.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".amount").each(function(){
				$(this).html(accounting.formatMoney($(this).text(), { symbol: "₹",  format: "%s %v" }));
			});
					$("a").on("click",function(e){
						/* e.preventDefault(); */
					});
					navigationObj = $("#menudatadiv").createNavigation({
						initialTitle : "Contact",
						div : $("#dataContainer")
					});
					addNewLink("Contact View", "contactmain",'action=getcontent');
					var data = [ "dhruval", "kodinariya" ];
					$("#customerName").autocomplete(data, {
						minChars : 0,
						scrollHeight : 204,
						width : 218,
						matchContains : true
					}).on("blur", function() {
						console.log($(this).val())
					});
					$(".drawer-list .drawer-item").on("click",function(e) {
								var img = $(this).children("a").attr("name");
								$(".drawer-list li").removeClass("selected");
								$(this).addClass("selected");
								$("#menudatadiv").html(
										'<div style="width: 328px;"></div>');
								$("#dataContainer").html("");
								$("#dataContainer").removeAttr("style");
								var img = $(this).children("a").attr("name");
								var lang = $(this).attr("lang");
								navigationObj = $("#menudatadiv").createNavigation({
											initialTitle : img,
											div : $("#dataContainer")
										});
								addNewLink(img + " View", lang,'action=getcontent');
							});
					$(".nav-list .menu-item").on("click", function(e) {
						$(".nav-list li").removeClass("selected");
						$(this).addClass("selected");
					});
				});
		function showActionBar() {
			/* $("#actionBar").addClass("showActionBar"); */
			$("#actionBar1").slideDown(200);
		}
		function closeActionBar() {
			/* $("#actionBar").removeClass("showActionBar"); */
			$("#actionBar1").slideUp(200);
		}
	</script>
	<%
            }else{
            	/* String redirect = response.encodeRedirectURL(request.getContextPath() + "/Login.jsp" );
                response.sendRedirect(redirect); */
            }
        %>
</body>
</html>
