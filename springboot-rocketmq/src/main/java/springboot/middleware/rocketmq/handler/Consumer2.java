package springboot.middleware.rocketmq.handler;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/1/2 下午11:23
 */
@Component
@RocketMQMessageListener(topic = "Topic1", consumerGroup = "consumerGroup2")
public class Consumer2 implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("2收到： "+s);
    }
}
