package springboot.middleware.rocketmq.handler;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/1/2 下午11:21
 */
@Component
@RocketMQMessageListener(topic = "Topic1", consumerGroup = "consumerGroup1")
public class Consumer implements RocketMQListener<Map<String, Object>> {
    @Override
    public void onMessage(Map<String, Object> paramsMap) {
        System.out.println("1收到： "+paramsMap.get("name"));
    }
}
