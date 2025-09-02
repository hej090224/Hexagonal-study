package adapter.in.web;


import domain.port.in.PostUseCase;
import domain.model.Post;
import domain.port.in.PostUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostUseCase postUseCase;

    public PostController(PostUseCase postUseCase) {
        this.postUseCase = postUseCase;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("post", new Post());
        return "posts.form";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("post", new Post());
        return "posts.form";
    }

    @PostMapping
    public String create(@ModelAttribute Post post) {
        postUseCase.createPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        postUseCase.getPost(id).ifPresent(p -> model.addAttribute("post", p));
        return "posts.form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Post post) {
        postUseCase.updatePost(id, post);
        return "redirect:/posts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postUseCase.deletePost(id);
        return "redirect:/posts";
    }
}
