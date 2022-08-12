package org.example.hello.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.example.hello.config.NacosConfig;
import org.example.hello.config.YamlConfig;
import org.example.hello.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${mysql.server}")
    public String server;

    @Value("${mysql.port}")
    public String port;


    @Autowired
    NacosConfig nacosConfig;

    @GetMapping("/")
    public String hello() {
        return "server:" + server + "/ port:" + port;
    }


    @GetMapping("/{dataId}")
    public String getUtilityConfig(@PathVariable("dataId") String dataId, @RequestParam(value = "group", required = false) String group) {
        return getConfig(dataId, group);
    }


    String getConfig(String dataId, String groupValue) {
        String nacosSever = "10.100.39.212";//nacosConfig.server;
        String group = nacosConfig.group;
        if (groupValue!=null && groupValue.length()>0){
            group = groupValue;
        }

        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, nacosSever);
        properties.put(PropertyKeyConst.USERNAME, "nacos");
        properties.put(PropertyKeyConst.PASSWORD, "nacos");
        properties.put(PropertyKeyConst.NAMESPACE, "6f58cc0d-ea1f-4f63-bf44-bd78ca20f10b");
        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("recieve:" + configInfo);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });

            return content;
        } catch (NacosException ex) {
            System.out.println(Arrays.stream(ex.getStackTrace()).map(x -> x.toString()));
            return "Failed:" + ex.getMessage();
        }

    }


}
