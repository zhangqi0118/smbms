package com.smbms.mapper;/*package com.smbms.mapper;

import com.github.pagehelper.PageHelper;
import com.smbms.pojo.Role;
import com.smbms.pojo.User;
import com.smbms.service.UserService;
import com.smbms.util.DateUtil;
import com.smbms.util.GetAge;
import net.sf.jsqlparser.parser.ParseException;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void updatePassWord() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        System.out.println(context.getBean(UserService.class).updatePassWord(null, "000"));

    }
//@Test
//    public void user() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
//       context.getBean(UserService.class).getUserByUserNameAndroleName("李明" ,"经理").forEach(user -> System.out.println(user));
//
//    }

    @Test
    public void getUserRole() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        UserService service = context.getBean(UserService.class);
        List<Role> list = service.getUserRole();

        for (Role user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void getUserByUserNameAndroleName() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        UserService service = context.getBean(UserService.class);
        List<User> userByUserNameAndroleName = service.getUserByUserNameAndroleName(null, null);
        for (User user : userByUserNameAndroleName) {
            System.out.println(GetAge.getAge(GetAge.parse(DateUtil.getStringDate(user.getBirthday()))));
        }
    }
}*/