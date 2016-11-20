package com.muzir.kek.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.muzir.kek.domain.User;
import com.muzir.kek.enums.Constants;
import com.muzir.kek.service.SessionService;
import com.muzir.kek.service.impl.LoginServiceImpl;
import com.muzir.kek.util.Message;
import com.muzir.kek.util.MessageType;

/**
 * @author erhun.baycelik
 *
 */
@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String get(HttpServletRequest request) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constants.KEKUSER.name());
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String getRegister(HttpServletRequest request) {
		return "register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String post(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Optional<User> userOptional = loginService.getUser(userName, password);
		if (userOptional.isPresent()) {
			HttpSession session = request.getSession();
			sessionService.setUser(session, userOptional.get());
		} else {
			redirectAttributes.addFlashAttribute("message",
					new Message(MessageType.ERROR, "User name or password are wrong!"));
			return "redirect:/login";
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User();
		user.setName(userName);
		user.setEmail(email);
		user.setPasswordSha256(password);
		user.setCreationTs(new Date());
		System.out.println("register POST");
		User savedUser = loginService.createUser(user);
		if (savedUser != null) {
			redirectAttributes.addFlashAttribute("message", new Message(MessageType.SUCCESSFUL,
					"User created successfully, please login with your credentials!"));
		} else {
			redirectAttributes.addFlashAttribute("message",
					new Message(MessageType.ERROR, "Something went wrong, let us check!"));
		}
		return "redirect:/login";
	}

}
