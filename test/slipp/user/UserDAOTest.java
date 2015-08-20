package slipp.user;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;


public class UserDAOTest {

	private UserDAO userDao;		// 지역변수'이름'에 우클릭 - Refactor - Convert Local Variable to Field   : 여러 메소드에 공통적인 지역변수 끄집어 낼  유용!!

	@Before
	public void setup(){
		userDao = new UserDAO();	// @Before는 테스트가 실행되기 전에 항상 먼저 실행되는 "전처리" 역할!
	}
	
	@Test
	public void connection() {
		Connection con = userDao.getConnection();
		assertNotNull(con);
	}
	
	@Test
	public void crud() throws Exception{		// crud : create retrieve update delete
		User user = UserTest.TEST_USER;
		userDao.removeUser(user.getUserId());	// 기본키 값 중복되지 않게 기존에 등록한 userId는 db에서 지우기.
		userDao.addUser(UserTest.TEST_USER);	// UserTest에 이미 TEST_USER라는 static 변수가 있으므로 그냥 그거 가져다 쓰자. 
		User dbUser = userDao.findByUserId(user.getUserId());
		assertEquals(user, dbUser);
		
		User updateUser = new User(user.getUserId(), "uPassword", "update name", "update@slipp.net");
		userDao.updateUser(updateUser);
		
		dbUser = userDao.findByUserId(user.getUserId());
		assertEquals(updateUser, dbUser);
	}
	
	@Test
	public void 존재하지_않는_사용자_조회() throws Exception {
		User user = UserTest.TEST_USER;
		userDao.removeUser(user.getUserId());
		User dbUser = userDao.findByUserId(user.getUserId());
		assertNull(dbUser);
		
	}

}
