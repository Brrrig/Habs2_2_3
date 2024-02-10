package mvc_ent2_2_3.controller;

import mvc_ent2_2_3.model.User;
import mvc_ent2_2_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUsers(Model model) {
        model.addAttribute("users",userService.listUsers());
        return "/gen";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model,@RequestParam long id) {
        model.addAttribute("user", userService.userById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        userService.remove(id);
        return "redirect:/";
    }
}
