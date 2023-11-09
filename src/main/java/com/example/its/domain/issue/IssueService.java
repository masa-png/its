package com.example.its.domain.issue;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
    }

    @Transactional
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }

    public IssueEntity findById(long issueId) {
        return issueRepository.findById(issueId);
    }

    @Transactional
    public void update(String summary, String description, long issueId) {
        issueRepository.update(summary, description, issueId);
    }

    public void deleteById(long issueId) {
        issueRepository.deleteById(issueId);
    }

}