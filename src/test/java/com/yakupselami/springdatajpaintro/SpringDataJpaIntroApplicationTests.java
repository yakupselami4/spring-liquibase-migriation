package com.yakupselami.springdatajpaintro;

import com.yakupselami.springdatajpaintro.domain.Book;
import com.yakupselami.springdatajpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataJpaIntroApplicationTests {

	@Autowired
	BookRepository bookRepository;


	@Test
	void testBookRepository() {
		long count = bookRepository.count();

		assertThat(count).isGreaterThan(0);
	}


	@Commit
	@Order(1)
	@Test
	void testJpaTestSplice() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(3);

		bookRepository.save(new Book("My Book", "1235555", "Self",null));

		long countAfter = bookRepository.count();

		assertThat(countBefore).isLessThan(countAfter);
	}

	@Order(2)
	@Test
	void testJpaTestSpliceTransaction() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(3);

	}
	@Test
	void contextLoads() {
	}

}
