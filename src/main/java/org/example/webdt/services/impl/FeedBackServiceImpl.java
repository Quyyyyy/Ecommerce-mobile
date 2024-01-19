package org.example.webdt.services.impl;

import org.example.webdt.dto.FeedBackDto;
import org.example.webdt.dto.mapper.FeedBackMapper;
import org.example.webdt.entities.FeedBackEntity;
import org.example.webdt.repositories.FeedBackEntityRepository;
import org.example.webdt.services.FeedBackService;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    private FeedBackEntityRepository feedBackRepository;

    public FeedBackServiceImpl(FeedBackEntityRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }

    @Override
    public FeedBackDto createFeed(FeedBackDto feedBackDto) {
        FeedBackEntity feedBack = FeedBackMapper.MAPPER.mapToFeedBackEntity(feedBackDto);
        FeedBackEntity feedBack1 = feedBackRepository.save(feedBack);
        FeedBackDto feedBackto1 = FeedBackMapper.MAPPER.mapToFeedBackDto(feedBack1);
        return feedBackto1;
    }
}
