#!/bin/bash

java -javaagent:/Users/tangshihui/Downloads/skywalking/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=service-score -Dskywalking.collector.backend_service=10.100.39.212:11800 -Dskywalking.logging.dir=/Users/tangshihui/Downloads/skywalking/skywalking-agent -server -jar ./service-score/build/libs/service-score-1.0-SNAPSHOT.jar