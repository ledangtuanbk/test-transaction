package com.ldt.testtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @GetMapping("/get")
    @Transactional
    public void get() throws Exception {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        throw new Exception("test");
    }

    @GetMapping("/get2")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void get2() throws Exception {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        throw new Exception("test");
    }

    @GetMapping("/get3")
    @Transactional
    public void get3() throws Exception {
        TestEntity testEntity = new TestEntity();
        testRepository.save(testEntity);
        throw new Error("test");
//        throw new RuntimeException("test");
    }
}
