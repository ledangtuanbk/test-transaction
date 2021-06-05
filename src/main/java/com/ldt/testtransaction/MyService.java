package com.ldt.testtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private TestRepository testRepository;

    public void test() {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        throw new Error("test");
    }
}
