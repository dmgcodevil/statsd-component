/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component;

import com.timgroup.statsd.StatsDClient;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;

/**
 * The StatsDProducer producer.
 */
public class StatsDProducer extends DefaultProducer {

    private StatsDEndpoint endpoint;

    public StatsDProducer(StatsDEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        StatsDComponent statsDComponent = (StatsDComponent) endpoint.getComponent();
        StatsDClient statsDClient = statsDComponent.getStatsDClient();
        if (statsDClient != null) {
            // whipped up for a while
            if (StatsDOperation.COUNTER.equals(endpoint.getOperation())) {
                statsDClient.count(endpoint.getAspect(), endpoint.getValue());
            } else if (StatsDOperation.VALUE.equals(endpoint.getOperation())) {
                statsDClient.gauge(endpoint.getAspect(), endpoint.getValue());
            } else {
                statsDClient.time(endpoint.getAspect(), endpoint.getValue());
            }
        } else {
            // do nothing. add logger
            System.out.printf("operation = %s, aspect = %s, value = %s",
                endpoint.getOperation().getName(), endpoint.getAspect(), endpoint.getValue());
        }
    }
}

