package com.example.HexagonalStudy.adapter.in.web;

import com.example.HexagonalStudy.domain.model.Post;
import com.example.HexagonalStudy.domain.port.in.PostUseCase;
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
        model.addAttribute("posts", postUseCase.getAllPosts());
        return "posts/list"; // templates/posts/list.html
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("post", new Post());
        return "posts/form"; // templates/posts/form.html
    }

    @PostMapping
    public String create(@ModelAttribute Post post) {
        postUseCase.createPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        postUseCase.getPost(id).ifPresent(p -> model.addAttribute("post", p));
        return "posts/form";
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
