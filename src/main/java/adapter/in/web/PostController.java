package adapter.in.web;

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

    // 게시글 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postUseCase.getAllPosts());
        return "posts/list"; // templates/posts/list.html
    }

    // 새 글 작성 폼
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("post", new Post());
        return "posts/form"; // templates/posts/form.html
    }

    // 글 생성
    @PostMapping
    public String create(@ModelAttribute Post post) {
        postUseCase.createPost(post);
        return "redirect:/posts";
    }

    // 수정 폼
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        postUseCase.getPost(id).ifPresent(p -> model.addAttribute("post", p));
        return "posts/form";
    }

    // 글 수정
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Post post) {
        postUseCase.updatePost(id, post);
        return "redirect:/posts";
    }

    // 글 삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postUseCase.deletePost(id);
        return "redirect:/posts";
    }
}
