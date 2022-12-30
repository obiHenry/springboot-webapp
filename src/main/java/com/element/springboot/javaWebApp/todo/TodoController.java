package com.element.springboot.javaWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todo-list")
	public String todosList(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);

		return "todosList";
	}

	private String getLoggedInUsername(ModelMap model) {
		
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
		
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodo(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, " default desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = getLoggedInUsername(model);
		todoService.addTodo(username, todo.getDescription(), todo.getDate(), false);
		return "redirect:todo-list";
	}

	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// Delete todo
		todoService.deleteById(id);

		return "redirect:todo-list";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:todo-list";
	}
}
