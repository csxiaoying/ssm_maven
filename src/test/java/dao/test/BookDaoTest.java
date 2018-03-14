package dao.test;

import com.ssm.maven.core.dao.BookDao;
import com.ssm.maven.core.entity.Book;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matcher.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 13 on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
public class BookDaoTest {
	@Autowired
	private BookDao bookDao;

	@Test
	@Ignore
	public void getBookByIdTest() {
		Book book1 = bookDao.getBookById("1");
		Assert.assertEquals(book1, null);
		Book book2 = bookDao.getBookById("1002");
		Assert.assertEquals(book2.getTitle(), "材料成型概论");
	}

	@Test
	@Ignore
	public void insertBookTest() {
		Book book1 = new Book();
		book1.setIntro("hello");
		book1.setBinding("binding");
		book1.setCatalog("科幻");
		book1.setIsbn("33334555");
		book1.setPath("path");
		book1.setAuthor("xiaoying");
		book1.setHot(3);
		book1.setMarketPrice("23");
		book1.setOriginalTitle("我是一个小小的石头");
		book1.setPages("500");
		book1.setPublisher("中国新华社");
		book1.setStatus("1");
		book1.setSubtitle("sbustra");
		book1.setSupply(400);
		book1.setTitle("红海行动");

		int returnCount = bookDao.insertBook(book1);
		Assert.assertEquals(1, returnCount);
	}

	@Test
	public void getTotalBooksTest() {
		long bookCount = bookDao.getTotalBooks(null);
		System.out.println(bookCount);
	}

}
