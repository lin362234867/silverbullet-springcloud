package com.tianque.receiver;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by QQ on 2018/7/3.
 */
@EnableBinding(Sink.class)
public class RabbitmqReceiver{
    @StreamListener(Sink.INPUT)
    public void receive(Object mem){
        System.out.println("getmessage:"+mem);
    }
}
