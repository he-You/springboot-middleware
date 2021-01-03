package springboot.middleware.rocketmq.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.middleware.rocketmq.entity.TestMessaging;

import java.util.UUID;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/1/3 下午6:08
 */
@RestController
@RequestMapping(value = "/produce")
public class TestController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 普通消息投递
     */
    @GetMapping("/test")
    public String test(@RequestParam String msg) {
        TestMessaging testMessaging = new TestMessaging()
                .setMsgId(UUID.randomUUID().toString())
                .setMsgText(msg);
        rocketMQTemplate.convertAndSend("add-bonus", testMessaging);
        return "投递消息 => " + msg + " => 成功";
    }
}
