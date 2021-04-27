package com.springboot.demo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {

        // 指定集群名,默认为elasticsearch,如果改了集群名,这里一定要加
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        /*
        ES的TCP端口为9300,而不是之前练习的HTTP端口9200
        这里只配置了一个节点的地址然添加进去,也可以配置多个从节点添加进去再返回
         */
        TransportAddress node = new TransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );
        client.addTransportAddress(node);

        return client;
    }
}
