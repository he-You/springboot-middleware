package springboot.middleware.rocketmq.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/1/3 下午6:23
 */
@Data
@Accessors(chain = true)
public class TestMessaging {
    /**
     * 消息id
     */
    private String msgId;
    /**
     * 消息内容
     */
    private String msgText;
}
