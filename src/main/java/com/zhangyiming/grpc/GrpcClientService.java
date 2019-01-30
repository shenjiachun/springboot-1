package com.zhangyiming.grpc;

import io.grpc.Channel;
import net.devh.examples.grpc.lib.HelloReply;
import net.devh.examples.grpc.lib.HelloRequest;
import net.devh.examples.grpc.lib.SimpleGrpc;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @Autowired
    private Channel serverChannel;

    public GrpcClientService(Channel serverChannel) {
        this.serverChannel = serverChannel;
    }

    public String sendMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }

//    public void onlineDeviceCount() {
//        EventModelGrpc.EventModelBlockingStub event = EventModelGrpc.newBlockingStub(serverChannel);
//        bamtracing.Event.OnlineDevOrMsgRes result = event.onlineDeviceCount(Event.NullReq.newBuilder().build());
//        System.out.println("onlineDeviceCount===================="+result.toString());
//    }
//
//    public void dev2PlatformMsgCount() {
//        EventModelGrpc.EventModelBlockingStub event = EventModelGrpc.newBlockingStub(serverChannel);
//        Long end = System.currentTimeMillis()/1000;
//        Long start = end - 60;
//        bamtracing.Event.OnlineDevOrMsgRes result = event.dev2PlatformMsgCount(Event.MpReq.newBuilder().setStartTimestamp(start).setEndTimestamp(end).build());
//        System.out.println("dev2PlatformMsgCount===================="+result.toString());
//    }
//
//    public void platform2DevMsgCount() {
//        EventModelGrpc.EventModelBlockingStub event = EventModelGrpc.newBlockingStub(serverChannel);
//        Long end = System.currentTimeMillis()/1000;
//        Long start = end - 60;
//        bamtracing.Event.OnlineDevOrMsgRes result = event.platform2DevMsgCount(Event.MpReq.newBuilder().setStartTimestamp(start).setEndTimestamp(end).build());
//        System.out.println("platform2DevMsgCount===================="+result.toString());
//    }
//
//    public void getDevName() {
//        EventModelGrpc.EventModelBlockingStub event = EventModelGrpc.newBlockingStub(serverChannel);
//        bamtracing.Event.DevNameRes result = event.getDevName(Event.NullReq.newBuilder().build());
//        System.out.println("getDevName===================="+result.toString());
//    }

}