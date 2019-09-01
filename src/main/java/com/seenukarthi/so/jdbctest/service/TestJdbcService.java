package com.seenukarthi.so.jdbctest.service;

import com.seenukarthi.so.jdbctest.repository.TestJdbcRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestJdbcService {

    private final TestJdbcRepository testJdbcRepository;

    public TestJdbcService(TestJdbcRepository testJdbcRepository) {
        this.testJdbcRepository = testJdbcRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testService(){
        testJdbcRepository.test();
    }
}
