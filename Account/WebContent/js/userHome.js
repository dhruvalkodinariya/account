function jqueryAjax(Url, Param, CallBackFunction, contentDiv, loadingDiv,
		errCallback) {
	if (Param == undefined) {
		Param = "";
	}
	$.extend(Param, {
		ajax : "true"
	});
	if (loadingDiv != undefined && loadingDiv.length != 0) {
		// loading image div put after 'loadingDiv'
		loadingDiv.parent().css("position", "relative");
		var html = "<div class='tableLoading' style='width:"
				+ (loadingDiv.width())
				+ "px;height:100%;position:absolute;top:0px;background-color:#FAFAFA;'>";
		html += "<div class='loadingData' style='position:relative;top:50%;'></div></div>";
//		loadingDiv.after(html);
	}

	var errorFn = function ajaxError(xhr, ajaxOptions) {
		var Url1 = Url;
		var Param1 = Param;
		if (xhr.status == 0) {
			jqueryAjax(Url1, Param1, CallBackFunction1);
		} else {
//			if (xhr.status == 400) {
				// window.location='UnauthorizedAccess.jsp';
//			} else if (xhr.status == 500) {
				// window.location='SessionExpired.jsp';
//			} else {
				var response = xhr.responseText;
				var bodyindex = response.indexOf("<h1>");
				var endIndex = response.lastIndexOf("</p>");
				var errMsg = response.substr(bodyindex, endIndex);
				clientSideError(
						"Following error occured while processing your request",
						new Array(errMsg));
				if (errCallback) {
					errCallback(xhr, ajaxOptions);
				}
//			}
		}
	};

	
			$.ajax({
				type : "POST",
				url : Url,
				data : Param,
				success : function(data, status, xhr) {
					var type = xhr.getResponseHeader("message-type");
					if (type == "1" || type == "2" || type == "3") {
						if (type == "3") {
							var errObj = jQuery.parseJSON(xhr.responseText);

							if (errObj.title != null
									&& errObj.title.length != 0)
								clientSideError(errObj.title, errObj.msgs);
							else
								clientSideError(
										"Following error occured while processing your request",
										errObj.msgs)

							if (errCallback) {
								errCallback(xhr);
							}
						} else if (type == "1") {
							var sucObj = jQuery.parseJSON(xhr.responseText);
							clientSideSuccess(sucObj);
							CallBackFunction(sucObj.data);
							window.setTimeout(function() {
								$(".btnCloseServerMsg").trigger("click");
							}, 1500);
						} else if (type == "2") {
							var warnObj = jQuery.parseJSON(xhr.responseText);
							clientSideWarning(warnObj.title, warnObj.msgs);

							var warnParam = "seqno=" + warnObj.param["seqno"];
							$("#warnBtnYes").click(
									function() {
										warnParam += "&answer=YES";
										$('.btnCloseBig').trigger('click');
										$(this).unbind();
										jqueryAjax(warnObj.url, warnParam,
												CallBackFunction);
									});
							$("#warnBtnNo").click(
									function() {
										warnParam += "&answer=NO";
										$('.btnCloseBig').trigger('click');
										$(this).unbind();
										jqueryAjax(warnObj.url, warnParam,
												CallBackFunction);
									});
						}
					} else {
						if (loadingDiv) {
							loadingDiv.parent().css("position", "static");
							loadingDiv.next("div").remove();
						}
						if (CallBackFunction) {
							CallBackFunction(data, contentDiv);
						}
					}
				},
				error : errorFn
			});
}