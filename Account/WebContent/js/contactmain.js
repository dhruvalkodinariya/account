/**
 * 
 */
$(document).ready(function(){
	$(".amount").each(function(){
		$(this).html(accounting.formatMoney($(this).text(), { symbol: "₹",  format: "%s %v" }));
	});
var flag = false;
var selCus = [];
$(".list-item").on(
		"click",
		function(e) {
			if (flag) {
				var check = $(this).find("input:checkbox");
				if (check.is(":checked")) {
					check.prop('checked', false).trigger("change");
				} else {
					check.prop('checked', true).trigger("change");
				}
			} else {
				closeActionBar();
				var id = $(this).find("a").attr("cusid");
				var param = new Object();
				param['action']='view';
	            param['id']=id;
				addNewLink($(this).find(".flex-3").text(), "contactmisc",
						param);
			}
		});

$("input:checkbox").click(function(e) {
	e.stopPropagation();
});
$("a").on("click",function(e){
//	e.preventDefault();
});

$("input:checkbox").change(
		function(e) {
			manageActionBar();
			$("#actionBar").find(".selectedText").html(
					"Selected (" + selCus.length + ")");
			if ($("input:checkbox").is(":checked")) {
				flag = true;
				showActionBar();
			} else {
				flag = false;
				closeActionBar();

			}
		});

function manageActionBar() {
	$("input:checkbox").each(function() {
		if ($(this).is(":checked")) {
			addSelectedListBack($(this).parent());
			var id = $(this).parent().attr("cusid");
			if (!selCus.includes(id)) {
				selCus.push($(this).parent().attr("cusid"));
			}
		} else {
			removeSelectedListBack($(this).parent());
			var id = $(this).parent().attr("cusid");
			var index = selCus.indexOf(id);
			if (!(index === -1)) {
				selCus.splice(index, 1);
			}
		}
	});
}
function addSelectedListBack(e) {
	e.addClass("selectedList");
}
function removeSelectedListBack(e) {
	e.removeClass("selectedList");
}

});

var contactView=function(contextobj){
	var contact=new Object();
	contact.initContactListView=function(){
		
		$("#addNewContactBtn",contextobj).on("click",function(e) {
			var param = new Object();
			param['action']='add';
			addNewLink("Add Contact", "contactmisc",param);
		});
		$("#searchContactBtn",contextobj).on("click",function(e) {
			
		});
	}
	contact.initContactAddView=function(){
		
		$("#cancelBtn",contextobj).on("click",function(e) {
			removeLastLink();
		});
		$("#addBtn",contextobj).on("click",function(e) {
			var newContact={};
			$("input:text",contextobj).each(function(){
				var key = $(this).attr("name");
				var val = $(this).val();
				newContact[key] = val;
			});
			$("textarea,input[name='cont_is']:checked",contextobj).each(function(){
				var key = $(this).attr("name");
				var val = $(this).val();
				newContact[key] = val;
			});
			var param = new Object();
			param["action"]="addnew";
			param["data"]=JSON.stringify(newContact);
			jqueryAjax("contactmain", param);
			console.log(newContact);
			clientSideSuccess();
			window.setTimeout(function(){
              $(".dialog-close").trigger("click");
            }, 1500);
			removeLastLink();
//			reloadData(CurrentDiv,"contactmain", 'action=getcontent');
		});
	}
	contact.initContactEdit=function(){
		var type = $("#cont_type").val();
		$("input[name='cont_is'][value="+type+"]").attr('checked', true);
		$("#updateContactBtn",contextobj).on("click",function(e) {
			var newContact={};
			$("input:text",contextobj).each(function(){
				var key = $(this).attr("name");
				var val = $(this).val();
				newContact[key] = val;
			});
			$("textarea,input[name='cont_is']:checked,input[type=hidden]",contextobj).each(function(){
				var key = $(this).attr("name");
				var val = $(this).val();
				newContact[key] = val;
			});
			var param = new Object();
			param["action"]="editcontact";
			param["data"]=JSON.stringify(newContact);
			jqueryAjax("contactmain", param);
			clientSideSuccess();
			window.setTimeout(function(){
                $(".dialog-close").trigger("click");
            }, 1500);
			removeLastLink();
		});
		$("#cancelButton",contextobj).on("click",function(e) {
			removeLastLink();
		});
	}
	contact.initContactView=function(){
		$("#editButton",contextobj).on("click",function(e) {
			var param = new Object();
			var id = $(this).attr("cusid");
			param['action']='edit';
            param['id']=id;
			addNewLink("Edit Contact", "contactmisc",param);
		});
		$("#backButton",contextobj).on("click",function(e) {
			removeLastLink();
		});
	}
	return contact;
};