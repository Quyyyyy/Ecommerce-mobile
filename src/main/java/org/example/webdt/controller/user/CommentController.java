package org.example.webdt.controller.user;


import org.example.webdt.controller.BaseController;
import org.example.webdt.entities.BaseEntity;
import org.example.webdt.entities.CommentEntity;
import org.example.webdt.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller

public class CommentController extends BaseController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/ajax/add-comment/{id}")
    public ResponseEntity<Map<String, Object>> addComment(
            @PathVariable("id") Long productId, @RequestParam("content") String content){
        CommentEntity comment = commentService.createComment(userLogined(),productId,content);
        Map<String,Object> jsonResult = new HashMap<>();
        jsonResult.put("user",comment.getUser().getUsername());
        jsonResult.put("created",comment.getCreated());
        jsonResult.put("content",comment.getReview());
        return ResponseEntity.ok(jsonResult);
    }
}
