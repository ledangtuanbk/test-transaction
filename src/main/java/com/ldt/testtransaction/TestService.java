package com.ldt.testtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Transactional
    public void test() throws Exception {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        throw new Exception("Test");
    }
}
