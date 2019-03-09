/**
 * 
 */
$(".amount").each(function(){
				$(this).html(accounting.formatMoney($(this).text(), { symbol: "₹",  format: "%s %v" }));
			});
$("#backButton").on(
		"click",
		function(e) {
			removeLastLink();
});
$("#cancelButton").on(
		"click",
		function(e) {
			removeLastLink();
});
$("#editButton").on("click",function(e) {
			var param = new Object();
			var id = $(this).attr("cusid");
			param['action']='edit';
            param['id']=id;
			addNewLink("Edit Contact", "contactmisc",param);
});