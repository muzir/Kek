package com.muzir.kek.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomErrorController http://www.w3schools.com/tags/ref_httpmessages.asp
 * @author erhun.baycelik
 *
 */
@RestController
public class CustomErrorController implements ErrorController {
	private static final String path = "/error";

	@Override
	public String getErrorPath() {
		return path;
	}

	@RequestMapping(value = path)
	public String error(HttpServletResponse response) {
		return getResponse(response.getStatus());
	}

	private String getResponse(int status) {
		System.out.println("CustomErrorController.getResponse()");
		String content = null;
		switch (status) {
		case 404:
			content = get404Response();
			break;
		default:
			content = getDefaultResponse(status);
			break;
		}
		return content;
	}

	private String get404Response() {
		return "<!DOCTYPE html><html><head><title>ScoreLeague.net - Source not found!</title><link href=\"https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cerulean/bootstrap.min.css\" rel=\"stylesheet\" />"
				+ "<script type=\"text/javascript\">window.setTimeout(function() { window.location.href = '/'; }, 10000);</script></head>"
				+ "<body><br /><br /><div class=\"container\"><div class=\"row\"><div class=\"panel panel-warning\"><div class=\"panel-heading\"><h3 class=\"panel-title\">404 - Source not found!</h3></div>"
				+ "<div class=\"panel-body\">The requested page or source could not be found. Now, you are redirecting to main page or click <a href=\"javascript:history.back()\">here</a> to go back and try again.</div>"
				+ "</div></div></div></body></html>";
	}

	private String getDefaultResponse(int status) {
		return "<!DOCTYPE html><html><head><title>Redirecting...</title>" //
				+ "<script type=\"text/javascript\">window.setTimeout(function() { window.location.href = '/'; }, 50);</script></head>" //
				+ "<body style=\"font-size: 8px; color: #cccccc;\">HTTP " + status + "</body></html>";
	}
}
