package com.dongguk.campton.service;

import com.dongguk.campton.respository.ChattingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChattingService {
    private final ChattingRepository chattingRepository;
}
