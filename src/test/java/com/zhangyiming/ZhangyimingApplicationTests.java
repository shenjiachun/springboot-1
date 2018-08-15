package com.zhangyiming;

import com.zhangyiming.timer.rabbitmq.Receiver;
import com.zhangyiming.timer.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZhangyimingApplication.class)
@WebAppConfiguration
public class ZhangyimingApplicationTests {

	@Test
	public void contextLoads() {
		Sender sender = new Sender();
		Receiver receiver = new Receiver();
		try {
			//sender.sendMsg("消息测试！");
			receiver.process();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}
