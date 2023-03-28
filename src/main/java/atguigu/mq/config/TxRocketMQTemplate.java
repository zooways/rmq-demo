package atguigu.mq.config;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * @Author: LiHuaZhi
 * @Date: 2020/11/5 15:09
 * @Description:
 **/

@ExtRocketMQTemplateConfiguration
public class TxRocketMQTemplate extends RocketMQTemplate {

    @Override
    public void setConsumer(DefaultLitePullConsumer consumer) {
        super.setConsumer(consumer);
    }
}
