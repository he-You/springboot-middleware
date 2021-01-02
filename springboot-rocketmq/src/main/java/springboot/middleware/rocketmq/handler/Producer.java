package springboot.middleware.rocketmq.handler;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/1/2 下午11:14
 */
@Component
public class Producer {
    @Resource
    private RocketMQTemplate mqTemplate;

    public void send() {
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("name", "testName");
        resultMap.put("id", "1");
        resultMap.put("sex", "1");
        //发送消息
        mqTemplate.convertAndSend("Topic1:TagA", resultMap);

        //发送spring的Message
        mqTemplate.send("Topic1:TagA", MessageBuilder.withPayload(resultMap).build());

        //发送异步消息
        mqTemplate.asyncSend("Topic1:TagA", resultMap, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });

        //发送顺序消息
        mqTemplate.syncSendOrderly("Topic1", "1,创建", "3");
        mqTemplate.syncSendOrderly("Topic1", "2,支付", "2");
        mqTemplate.syncSendOrderly("Topic1", "3,完成", "1");
    }
}
