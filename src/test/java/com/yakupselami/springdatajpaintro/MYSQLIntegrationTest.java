package com.yakupselami.springdatajpaintro;

import com.yakupselami.springdatajpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
    @DataJpaTest
    @ComponentScan(basePackages = {"com.yakupselami.springdatajpaintro.bootstrap"})
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    public class MYSQLIntegrationTest {

        @Autowired
        BookRepository bookRepository;

        @Test
        void testMySQL() {
            long countBefore = bookRepository.count();
            assertThat(countBefore).isEqualTo(2);

        }

    }

