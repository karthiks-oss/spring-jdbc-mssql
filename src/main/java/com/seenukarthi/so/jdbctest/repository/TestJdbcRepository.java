package com.seenukarthi.so.jdbctest.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Objects;


/**
 * DDL For Table
 *
 * create table TEST_TRANS
 * (
 * 	DESCRIPTION_2 float,
 * 	AMOUNT_STR varchar(255),
 * 	DESCRIPTION varchar(255)
 * )
 * go
 */
@Repository
public class TestJdbcRepository extends NamedParameterJdbcDaoSupport {

    //This dose not works
    private static final String testQuery = "UPDATE TEST_TRANS SET DESCRIPTION_2 = CAST(AMOUNT_STR as float)/100 WHERE DESCRIPTION != :DESCRIPTION";

    //This Works
    //private static final String testQuery = "UPDATE TEST_TRANS SET DESCRIPTION_2 = CAST(AMOUNT_STR as float)/100 WHERE DESCRIPTION != 'AED'";

    public TestJdbcRepository(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void test() {
        Objects.requireNonNull(getNamedParameterJdbcTemplate())
                .update(testQuery, Collections.singletonMap("DESCRIPTION","AED"));
    }
}
