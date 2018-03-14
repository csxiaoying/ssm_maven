package controller.test;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration //用于声明一个ApplicationContext集成测试加载

//需要注解指定spring的配置文件，扫描相应的配置，将类初始化等。
@ContextConfiguration({"classpath*:/spring-context.xml", "classpath*:/spring-context-mvc.xml", "classpath*:/mybatis-config.xml"})
public class UserControllerTest {
	
	private static final long serialVersionUID = 1L;
	
	//WebApplicationContext。作用是模拟ServletContext
	@Autowired
    private WebApplicationContext wac;  
	private MockMvc mockmvc;
	
	@Before
	public void setup() {
		this.mockmvc = webAppContextSetup(this.wac).build();
	}
	
	public void userListTest() {
		MockHttpServletRequestBuilder mockBuild = MockMvcRequestBuilders.get("/user/list");
//		mockBuild.params("");
		
		
	}
}
