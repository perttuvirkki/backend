package chapter2._3_friendlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    List<String> friends = new ArrayList<>();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("friends", friends);
        return "index";
    }

    @PostMapping("/addFriend")
    public String addFriend(@RequestParam String name, Model model) {
        friends.add(name);
        return "redirect:/index";
    }
}