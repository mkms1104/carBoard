package com.carboard.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest
public abstract class JpaTestSupport {
    @Autowired protected EntityManager em;
    protected JPAQueryFactory factory;

    @BeforeEach
    void innerInit() {
        factory = new JPAQueryFactory(em);
    };
    protected abstract void mapper();
    protected abstract void jpaRepository();
    protected abstract void querydsl();
}
