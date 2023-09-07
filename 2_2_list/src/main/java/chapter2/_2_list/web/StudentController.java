package chapter2._2_list.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import chapter2._2_list.domain.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    
    @GetMapping("/hello")
    public String showStudents(Model model) {
        List<Student> students = Arrays.asList(
                new Student("Kate", "Cole"),
                new Student("Dan", "Brown"),
                new Student("Mike", "Mars")
        );
        
        model.addAttribute("students", students);
        return "hello";
    }
}
