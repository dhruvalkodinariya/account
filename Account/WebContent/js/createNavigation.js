/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var CurrentDiv;
(function($) {
	
	$.fn.createNavigation = function(settings) {
		settings = jQuery.extend({
			initialTitle : "",
			div : "",
			slideDivClass : "slideDiv",
			minHeight : "675"
		}, settings);

		var mainContainerDiv = settings.div;
		var curObj = this;
		var slideDivClass = settings.slideDivClass;
		var minHeight = settings.minHeight;
		var animationTime = 300;
		var flag = true;

		var navigationDiv = $(document.createElement("div"));
		var navigationTable = '<table cellspacing="0" width="100%"><tr><td class="linkListT"></td></tr>'
				+ '<tr><td class="linkListC"><span class="disableLink" index="0">'
				+ settings.initialTitle
				+ '</span><span class="help"></span></td></tr>'
				+ '<tr><td class="linkListB"></td></tr></table>';

		navigationDiv.append(navigationTable);

		curObj.append(navigationTable);

		var totalWidth = mainContainerDiv.innerWidth();
		var slideWidth = mainContainerDiv.width();
		var paddingTop = mainContainerDiv.css("padding-top");
		var paddingBottom = mainContainerDiv.css("padding-bottom");
		var paddingLeft = mainContainerDiv.css("padding-left");
		var paddingRight = mainContainerDiv.css("padding-right");
		mainContainerDiv.css("padding","0px");
		mainContainerDiv.css({
			"height" : "auto",
			"position" : "relative",
			"overflow" : "hidden"
		});
		var sliderDiv = $(document.createElement("div")).css(
				{
					"width" : totalWidth + "px",
					"position" : "relative",
					"overflow" : "hidden",
					"padding" : paddingTop + " " + paddingRight + " "
							+ paddingBottom + " 0px"
				}).attr("class", "sliderDiv");
		var blankSlideDiv = $(document.createElement("div")).attr("class",
				slideDivClass);
		blankSlideDiv.css({
			"width" : slideWidth + "px",
			"height" : minHeight + "px",
			"margin-left" : paddingLeft
		}).attr("index", "0");
		sliderDiv.append(blankSlideDiv)
		mainContainerDiv.append(sliderDiv);

		var lastIndex = 0, curIndex = 0;

		var addLink = function(linktitle) {
			if (curObj.find(".activeLink").attr("index") != undefined
					&& curObj.find(".activeLink").attr("index") != lastIndex) {
				curObj.find(".activeLink").nextAll('span').not("span.help")
						.remove();
				mainContainerDiv.find(
						"div[index="
								+ (curObj.find(".activeLink").attr("index"))
								+ "]").nextAll().remove();

			}
			// add title
			// title.html(linktitle);
			curObj.find(".activeLink").attr("class", "disableLink");
			// add link
			var index = curObj.find(".disableLink").length;

			var activeLink = $(document.createElement("span")).attr("index",
					index).html(linktitle);
			activeLink.attr("class", "activeLink");
			curObj.find(".disableLink:last").after(
					'<span class="linkSep">&nbsp;</span>');
			curObj.find(".disableLink:last").next().after(activeLink);
			activeLink.click(function() {
				var curLink = $(this);
				if (curLink.attr("class") == "activeLink" || flag == false) {
					return;
				}
				flag = false;
				curObj.find(".activeLink").attr("class", "disableLink");
				curLink.attr("class", "activeLink");
				var clickIndex = curLink.attr("index");
				curIndex = clickIndex;

				var animateDiv = mainContainerDiv.find("div[index="
						+ clickIndex + "]")

				animateDiv.animate({
					"height" : animateDiv.find("div:eq(1)").height() + "px"
				}, animationTime, function() {
					animateDiv.css("height", "auto");
				});
				animateDiv.parent().animate({
					"height" : animateDiv.find("div:eq(1)").height() + "px"
				}, animationTime, function() {
					animateDiv.parent().css("height", "auto");
				});

				window.setTimeout(function() {
					slideTo(animateDiv);
					// title.html(curLink.html());
				}, animationTime);
				CurrentDiv=clickIndex;
				console.log(CurrentDiv);
			});

			lastIndex = index;
			mainContainerDiv.find(".sliderDiv").css("width",
					totalWidth * (index + 1) + "px");
			// add div
			curIndex = lastIndex;
			var slideDiv = $(document.createElement("div")).css(
					{
						"height" : mainContainerDiv.find(
								"div[index=" + (lastIndex - 1) + "]").height()
								+ "px",
						"width" : slideWidth + "px",
						"margin-left" : paddingLeft
					}).attr("index", index);
			slideDiv.attr("class", slideDivClass);

			var slideLoadingDiv = $(document.createElement("div")).attr(
					"class", "navigationLoadingLayer").css("min-height",
					minHeight + "px");
			slideLoadingDiv.append("<b class='loadingImg'></b>");
			var slideContent = $(document.createElement("div"));
			slideDiv.append(slideLoadingDiv);
			slideDiv.append(slideContent);

			mainContainerDiv.find(".sliderDiv").append(slideDiv);
			// slide div
			if (index == 1) {
				mainContainerDiv.find(".sliderDiv").css("left",
						-slideDiv.position().left + "px");
			} else {
				slideTo(slideDiv);
			}
			CurrentDiv=curIndex;
			console.log(CurrentDiv);
			return slideDiv.find("div:eq(1)").css("display", "none");
		}

		var hideLoading = function() {
			var slideDiv = mainContainerDiv
					.find("div[index=" + lastIndex + "]");
			if (flag == false
					|| (slideDiv.find("div:eq(1)").html() != null && slideDiv
							.find("div:eq(1)").html().length == 0)) {
				return;
			}

			slideDiv.find("div:eq(1)").css("display", "block");
			slideDiv.find("div:eq(0)").css("display", "none");
			// - loading div hide.
			var divHeight = (slideDiv.find("div:eq(1)").height() > 400) ? slideDiv
					.find("div:eq(1)").height()
					: 400;
			slideDiv.parent().animate({
				"height" : slideDiv.find("div:eq(1)").height() + "px"
			}, animationTime, function() {
				if (lastIndex != 0)
					slideDiv.parent().css("height", "auto");
			});
			slideDiv.animate({
				"height" : slideDiv.find("div:eq(1)").height() + "px"
			}, animationTime, function() {
				if (curIndex != 0) {
					mainContainerDiv.find("div[index]").find("div:eq(1)").css({
						"height" : "400px",
						"overflow" : "hidden"
					});
					mainContainerDiv.find("div[index=" + curIndex + "]").find(
							"div:eq(1)").removeAttr("style");
					mainContainerDiv.find("div[index=" + curIndex + "]").find(
							"div:eq(1)").find(
							"a:first,input:first,select:first").not(
							":disabled,:hidden").first().focus();
				}
				if (lastIndex != 0)
					slideDiv.css("height", "auto");
			});
			mainContainerDiv.data("curindex", curIndex);
		}

		var removeLastLink = function() {
			// if(lastIndex==1){return;}
			var activeLink = curObj.find(".activeLink");
			lastIndex = parseInt(activeLink.attr("index"));

			curObj.find(".activeLink").nextAll('span').not("span.help")
					.remove();
			mainContainerDiv.find("div[index=" + (lastIndex) + "]").nextAll()
					.remove();

			var lastDiv = mainContainerDiv.find("div[index=" + lastIndex + "]");
			// change title
			// title.html(activeLink.prev().prev().html());
			activeLink.prev().prev().attr("class", "activeLink");
			// remove activelink
			activeLink.prev().remove();
			activeLink.remove();
			lastDiv.find(":eq(1)").html("");
			lastDiv.animate({
				"height" : lastDiv.prev().height() + "px"
			}, animationTime);
			lastDiv.parent().animate({
				"height" : lastDiv.prev().height() + "px"
			}, animationTime);
			window.setTimeout(function() {
				if (lastDiv.find(":eq(0)").css("display") != "block") {
					slideTo(mainContainerDiv.find("div[index="
							+ (lastIndex - 1) + "]"));
				} else {
					mainContainerDiv.find(".sliderDiv").css(
							"left",
							-mainContainerDiv.find(
									"div[index=" + (lastIndex - 1) + "]")
									.position().left
									+ "px");
				}
				window.setTimeout(function() {
					lastDiv.remove();
				}, animationTime);
				lastIndex--;
				curIndex = lastIndex;
			}, animationTime);
			CurrentDiv=curIndex;
			console.log(CurrentDiv-1);
		}

		var slideTo = function(div) {
			flag = false;
			var leftPos = -div.position().left;
			mainContainerDiv.find(".sliderDiv").animate({
				"left" : leftPos + "px"
			}, animationTime, function() {
				flag = true;
				hideLoading();
			});
		}

		var obj = {
			addLink : addLink,
			hideLoading : hideLoading,
			removeLastLink : removeLastLink,
			slideTo : slideTo
		}
		return obj;
	}
})(jQuery);

// Functions specific to Application. Not library functions
function addNewLink(linktitle, url, param, callbackFn, errorFn) {
	if (param == undefined) {
		param = "";
	}
	var contentDiv = navigationObj.addLink(linktitle);
	var internalCallback = function(data, div) {
		div.html(data);
		navigationObj.hideLoading();
		if (callbackFn) {
			callbackFn(data);
		}
	}
	var internalErrorFn = function(xhr, ajaxOptions) {
		navigationObj.removeLastLink();
		if (errorFn) {
			errorFn(xhr, ajaxOptions);
		}
	}
	jqueryAjax(url, param, internalCallback, contentDiv, undefined,
			internalErrorFn);
}

function reloadData(index, url, param, callbackFn, errorFn) {
	if (param == undefined) {
		param = "";
	}
	var contentDiv = $(".sliderDiv").find("div[index=" + index + "]");
	var internalCallback = function(data, div) {
		div.html(data);
		navigationObj.hideLoading();
		if (callbackFn) {
			callbackFn(data);
		}
	}
	var internalErrorFn = function(xhr, ajaxOptions) {
		navigationObj.removeLastLink();
		if (errorFn) {
			errorFn(xhr, ajaxOptions);
		}
	}
	jqueryAjax(url, param, internalCallback, contentDiv, undefined,
			internalErrorFn);
}

function removeLastLink() {
	navigationObj.removeLastLink();
}
