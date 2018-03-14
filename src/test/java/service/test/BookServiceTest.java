package service.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.maven.core.entity.Book;
import com.ssm.maven.core.service.BookService;

/**
 * Created by 13 on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
@Rollback(value=true)
@Transactional(transactionManager="transactionManager")
//不添加此设置,测试service层的事务管理
//service层与dao层的测试时相同的,不同之处,在于service多数都在配置文件中配置了spring的事务管理
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test(expected= DataIntegrityViolationException.class)
    @Ignore
    public void insertStoreTest() {
        Book book = new Book();
        book.setTitle("不测事物");
        book.setHot(3);
        int i = bookService.insertBook(book);
//        int i = 10 / 0;
        //这里发生异常是不会回滚的,因为此方法并没有被纳入事务管理中
    }
    
    @Test
    public void insertStoreTest2() {
        Book book = new Book();
        book.setTitle("不测事物");
        book.setHot(3);
        int i = bookService.insertBook(book);
        System.out.println(i);
//        int i = 10 / 0;
    }

}
