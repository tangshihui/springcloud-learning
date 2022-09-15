#!/bin/bash
instanceId="xx"
java -javaagent:/Users/tangshihui/Downloads/skywalking/skywalking-agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=service-demo \
-Dskywalking.agent.instance_name=service-demo-02 \
-Dskywalking.collector.backend_service=10.100.39.212:11800 \
-Dskywalking.logging.dir=/Users/tangshihui/Downloads/skywalking/skywalking-agent \
-server -jar ./service-demo/build/libs/service-demo-1.0-SNAPSHOT.jar