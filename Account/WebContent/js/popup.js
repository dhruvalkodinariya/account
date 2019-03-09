/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function clientSideError(errorTitle, errorArray) {
	if ($("body").find(".dialog-icon").length == 0) {
		var html = '<div class="dialog-container-wrap">'
				+ '<div class="dialog-container-inner">'
				+ '<div class="dialog-header errorHeader">'
				+ '<div class="dialog-icon errorIcon"></div>'
				+ '<div class="dialog-title">Following error ocurred while your request.</div>'
				+ '<div class="dialog-close"></div>' + '</div>'
				+ '<div class="dialog-description">Dialog</div>' + '</div>'
				+ '</div>';
		$("#dialog-container").append(html);
		btnCloseServerMsgEvent();
	}
	else{
		$(".dialog-header").addClass("errorHeader");
		$(".dialog-icon").addClass("errorIcon");
	}
	$(".dialog-title").text(
			($.trim(errorTitle).length != 0) ? errorTitle
					: "Enable to process your request");
	$(".dialog-description").html("");
	// for (var i = 0;i < errorArray.length;i++) {
	$(".dialog-description").append(errorArray[0]);
	// }

	$(".mask").css("display", "block");
	$("#dialog-container").slideDown(200);
	window.scroll(0, 0);
}

function clientSideWarning(warnTitle, warnArray, callback) {
	if ($(".mainInnerPanel").find(".popServerMsg.warn").length == 0) {
		var html = '<div class="popServerMsg warn">'
				+ '<table cellspacing="0" width="100%">'
				+ '<tr><td class="popCenterL"></td><td class="popCenterC">'
				+ '<div class="popDataContainer">'
				+ '<div class="errorBack" id="serWarnTitle"><span>Your confirmation required for further proceed</span><div class="btnCloseBig btnCloseServerMsg"></div></div>'
				+ '<div class="popData"><table cellspacing="0" width="100%" class="warnTable"></table></div>'
				+ '<div style="float: right;margin: 8px 0px 5px 0px;">'
				+ '<a href="javascript:void(0);" class="btnYes" id="warnBtnYes"></a><a href="javascript:void(0);" class="btnNo" id="warnBtnNo"></a>'
				+ '</div>'
				+ '</div>'
				+ '</td><td class="popCenterR"></td></tr>'
				+ '<tr><td class="popBottomL"></td><td class="popBottomC"></td><td class="popBottomR"></td></tr>'
				+ '</table>' + '</div>';
		$(".mainInnerPanel").append(html);
		btnCloseServerMsgEvent();
	}
	$("#serWarnTitle span").text(
			(warnTitle != null && $.trim(warnTitle).length != 0) ? warnTitle
					: "Your confirmation required for further proceed");
	$(".warnTable").html("");
	for (var i = 0; i < warnArray.length; i++) {
		$(".warnTable").append(
				"<tr><td class=\"confirmationIcon\">" + warnArray[i]
						+ "</td></tr>");
	}
	$(".warnTable")
			.append(
					'<tr><td>Press <b>"Yes"</b> to continue and <b>"No"</b> to cancel</td></tr>');
	$(".popServerLayer").css("display", "block");
	$(".popServerMsg.warn").slideDown(200);
	window.scroll(0, 0);
	if (callback != undefined) {
		$("#warnBtnYes").bind("click", function() {
			$(".btnCloseServerMsg").trigger("click");
			callback();
			$("#warnBtnYes,#warnBtnNo").unbind("click");
		});
		$("#warnBtnNo").bind("click", function() {
			$(".btnCloseServerMsg").trigger("click");
			$("#warnBtnYes,#warnBtnNo").unbind("click");
		});
	}
	$("#warnBtnYes").select().focus();
}

function clientSideSuccess(sucObj) {
	if ($("body").find(".dialog-icon").length == 0) {
		var html = '<div class="dialog-container-wrap">'
			+ '<div class="dialog-container-inner">'
			+ '<div class="dialog-header successHeader">'
			+ '<div class="dialog-icon successIcon"></div>'
			+ '<div class="dialog-title">Record updated successfully...</div>'
			+ '<div class="dialog-close"></div>' + '</div>'
			+ '<div class="dialog-description"></div>' + '</div>'
			+ '</div>';
		$("#dialog-container").append(html);
		btnCloseServerMsgEvent();
	}
	else{
		$(".dialog-header").removeClass("errorHeader").addClass("successHeader");
		$(".dialog-icon").removeClass("errorIcon").addClass("successIcon");
		$(".dialog-title").html("Record updated successfully...");
		$(".dialog-description").html("");
	}
	$(".mask").css("display", "block");
	$("#dialog-container").slideDown(200);
	window.scroll(0, 0);
}

function btnCloseServerMsgEvent() {
	$(".dialog-close").unbind("click");
	$(".dialog-close").click(function() {
		$("#dialog-container").slideUp(200, function() {
			$(".mask").css("display", "none");
		});
	});
}