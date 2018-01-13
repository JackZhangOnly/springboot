package com.jackzhang.rabbitmq;

import com.jackzhang.rabbitmq.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private Sender sender;

	@Test
	public void sendTest() throws Exception {

		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (int i=0;i<5;i++){
			sender.send(format.format(new Date()));
			Thread.sleep(3000);
		}
	}
}
