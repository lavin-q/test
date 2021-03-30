package com.qhm.redis.jedis.PubSub;

import redis.clients.jedis.JedisPubSub;

/**
 * @Description :   //描述
 * @Author : qhm  //作者
 * @Date: 2021-03-30 14:06  //时间
 */
public class SubscribeListener extends JedisPubSub {

    private String subscriber;

    public SubscribeListener(String subscriber) {
        // TODO Auto-generated constructor stub
        this.subscriber = subscriber;
    }

    @Override
    public void onMessage(String channel, String message) {
        // TODO Auto-generated method stub
        System.out.println(this.subscriber + " received message from channel ["
                + channel + "]:" + message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        // TODO Auto-generated method stub
        System.out.println(this.subscriber + " received message from channel ["
                + channel + "]:" + message);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(this.subscriber + " subscribe channel in pattern: "
                + pattern + ", channels count: " + subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(this.subscriber
                + " unsubscribe channel in pattern: " + pattern
                + ", channels count: " + subscribedChannels);

    }

    @Override
    public void onSubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(this.subscriber + " subscribe channel: " + pattern
                + ", channels count: " + subscribedChannels);

    }

    @Override
    public void onUnsubscribe(String pattern, int subscribedChannels) {
        // TODO Auto-generated method stub
        System.out.println(this.subscriber + " unsubscribe channel: " + pattern
                + ", channels count: " + subscribedChannels);
    }
}
