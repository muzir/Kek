package com.muzir.kek.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;
import com.muzir.kek.service.SessionService;
import com.muzir.kek.service.TodoService;

/**
 * @author erhun.baycelik
 *
 */
@Controller
public class HomeController {
	@Autowired
	private TodoService todoService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		User user = sessionService.getUser(request.getSession());
		List<Todo> todos = todoService.getUserTodos(user);
		todos.stream().forEach(t -> System.out.println(t));
		model.addAttribute("todos", todos);
		return "home";
	}

	@RequestMapping(value = "/createTodo", method = RequestMethod.POST)
	public String createTodo(HttpServletRequest request, Model model) {
		String description = request.getParameter("todoText");
		User user = sessionService.getUser(request.getSession());
		Todo todo = new Todo();
		todo.setCreationTs(new Date());
		todo.setUser(user);
		todo.setDescription(description);
		todoService.saveTodo(todo);
		return "redirect:/home";
	}

	@RequestMapping(value = "/markAsDone", method = RequestMethod.POST)
	public String markAsDone(HttpServletRequest request, Model model) {
		User user = sessionService.getUser(request.getSession());
		String[] markAsDoneIds = request.getParameterValues("markAsDoneId");
		System.out.println("markAsDoneIds:" + markAsDoneIds.length);
		return "redirect:/home";
	}
}
