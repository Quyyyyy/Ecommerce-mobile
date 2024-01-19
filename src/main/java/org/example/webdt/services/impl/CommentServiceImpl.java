package org.example.webdt.services.impl;

import org.example.webdt.dto.CommentDto;
import org.example.webdt.dto.ResultResponse;
import org.example.webdt.dto.UserDto;
import org.example.webdt.dto.mapper.CommentMapper;
import org.example.webdt.dto.mapper.UserMapper;
import org.example.webdt.entities.CommentEntity;
import org.example.webdt.entities.UserEntity;
import org.example.webdt.repositories.CommentEntityRepository;
import org.example.webdt.repositories.ProductEntityRepository;
import org.example.webdt.repositories.UserEntityRepository;
import org.example.webdt.services.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentEntityRepository commentRepository;
    private ProductEntityRepository productRepository;
    private UserEntityRepository userRepository;

    public CommentServiceImpl(CommentEntityRepository commentRepository, ProductEntityRepository productRepository, UserEntityRepository userRepository) {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommentEntity createComment(UserEntity user,Long productId, String  content) {
        CommentEntity comment = new CommentEntity();
        comment.setProduct(productRepository.findById(productId).get());
        comment.setUser(user);
        comment.setReview(content);
        CommentEntity commentSave = commentRepository.save(comment);
        return commentSave;
    }

    @Override
    public ResultResponse getAllCommentByProduct(Long productId,int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<CommentEntity> comments = commentRepository.findCommentEntitiesByProductId(productId,pageable);
        List<CommentEntity> commentEntityList = comments.getContent();
        List<CommentDto> contents = commentEntityList
                .stream().map((comment)->CommentMapper.MAPPER.mapToCommentDto(comment)).collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setContent(commentEntityList);
        resultResponse.setPageNo(comments.getNumber());
        resultResponse.setPageSize(comments.getSize());
        resultResponse.setTotalElements(comments.getTotalElements());
        resultResponse.setTotalPages(comments.getTotalPages());
        resultResponse.setLast(comments.isLast());
        return resultResponse;
    }
}
