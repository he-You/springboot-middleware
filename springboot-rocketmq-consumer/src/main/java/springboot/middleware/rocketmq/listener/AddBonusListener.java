package springboot.middleware.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import springboot.middleware.rocketmq.entity.TestMessaging;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/1/3 下午6:24
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "consumer-group", topic = "add-bonus")
public class AddBonusListener implements RocketMQListener<TestMessaging> {
    @Override
    public void onMessage(TestMessaging testMessaging) {
        log.warn("消费到消息 => "+testMessaging.toString());
    }
}
