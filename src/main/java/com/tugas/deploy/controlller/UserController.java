package com.tugas.deploy.controlller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // List statis untuk menyimpan data sementara (Temporary)
    private static List<User> listMahasiswa = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        // Logika login: username=admin, password=NIM masing-masing
        if (username.equals("admin") && password.equals("20230140015")) { // Ganti NIM ini
            return "redirect:/home";
        }
        return "redirect:/";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("dataMhs", listMahasiswa);
        return "home";
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveData(@ModelAttribute User user) {
        listMahasiswa.add(user);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        listMahasiswa.clear(); // Opsional: hapus data saat logout
        return "redirect:/";
    }
}