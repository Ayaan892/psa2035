package com.crm.controller;


import com.crm.entity.Comment;
import com.crm.entity.Post;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")  //this is used to map the request to this controller class and its methods.
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    @PostMapping
    public String creatComment(
            @RequestBody Comment comment,    // It is called Request Binding Annotaion.Maps the body of the HTTP request (typically in JSON format) to a Java object.
            @RequestParam long postId
    ) {
        Post post = postRepository.findById(postId).get();

        comment.setPost(post);
        commentRepository.save(comment);
          return  "Comment created successfully";
    }

}
