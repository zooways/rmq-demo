package atguigu.mq.controller;


import atguigu.mq.config.ExtRocketMQTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/mq")
@Slf4j
public class MqMessageController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Resource(name = "extRocketMQTemplate")
    private ExtRocketMQTemplate extRocketMQTemplate;

    @GetMapping("/send")
    public String get(@RequestParam("id") int id) {
        rocketMQTemplate.convertAndSend("first-topic", "你好,Java旅途" + id);
        return "ok";
    }


    @GetMapping("/receive")
    public void consume() {
        //This is an example of pull consumer using rocketMQTemplate.
        List<String> messages = rocketMQTemplate.receive(String.class);
        log.info("receive from rocketMQTemplate, messages={}", messages);

        //This is an example of pull consumer using extRocketMQTemplate.
        messages = extRocketMQTemplate.receive(String.class);
        messages.forEach(System.out::println);
    }
}