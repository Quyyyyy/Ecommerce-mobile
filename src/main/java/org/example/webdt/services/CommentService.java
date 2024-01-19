package org.example.webdt.services;

import org.example.webdt.dto.ResultResponse;
import org.example.webdt.entities.CommentEntity;
import org.example.webdt.entities.UserEntity;

public interface CommentService {
    CommentEntity createComment(UserEntity user,Long productId, String  content);
    ResultResponse getAllCommentByProduct(Long productId,int pageNo,int pageSize);
}
