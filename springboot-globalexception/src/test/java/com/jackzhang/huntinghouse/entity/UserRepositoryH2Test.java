package com.jackzhang.huntinghouse.entity;

import com.jackzhang.huntinghouse.HuntinghousesApplicationTests;
import com.jackzhang.huntinghouse.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by Jack
 */
@ActiveProfiles("test")
public class UserRepositoryH2Test extends HuntinghousesApplicationTests{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFind(){
        User user=userRepository.findOne(1l);
        System.out.println("===================="+user.getName());
    }
}
