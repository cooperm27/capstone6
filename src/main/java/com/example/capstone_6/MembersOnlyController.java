package com.example.capstone_6;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.capstone_6.dao.TaskDao;
import com.example.capstone_6.pojo.Task;
import com.example.capstone_6.pojo.User;







@Controller
public class MembersOnlyController {
	
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/tasks")
	public String secrets(Model model, RedirectAttributes redir) {
		User user = (User) session.getAttribute("user");
		// For this URL, make sure there is a user on the session.
		if (user == null) {
			// if not, send them back to the login page with a message.
			redir.addFlashAttribute("message", "Wait! Please log in.");
			return "redirect:/login";
		}
		
		// if the user is logged in, proceed as normal.
		List<Task> tasks = taskDao.findByUserId(user.getId());
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@RequestMapping("/add-task")
	public String addTask(
			@RequestParam("description") String description, @RequestParam ("Date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
		User user = (User) session.getAttribute("user");
		Task task = new Task();
		task.setUser(user);
		task.setDescription(description);
		task.setDueDate(dueDate);
		task.setComplete(false);
		taskDao.save(task);
		return "redirect:/tasks";
	}

	@RequestMapping("/completeTask")
	public String completeTask(@RequestParam("id") Long id, Model model) {
		Task task = taskDao.findById(id).get();
		task.setComplete(true);
		taskDao.save(task);	
		return "redirect:/tasks";
	}
	
	@RequestMapping("/deleteTask")
	public String removeTask(@RequestParam("id") Long id, Model model) {
		taskDao.deleteById(id);
		return "redirect:/tasks";
	}

}
