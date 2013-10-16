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

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.ArrayUtils.isNotEmpty;
import com.timgroup.statsd.StatsDClient;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Represents the camel component that manages {@link StatsDEndpoint} which may be used to post metrics
 * in the form of counters, timers, and gauges.
 * <p/>
 * Format:   statsd:[counter:|value:|time:]aspect[?options]
 * <p/>
 * Three type of data-points:
 * <ul>
 *      <li> counter - adds one to the value of the specified named counter</li>
 *      <li> value  - records the latest fixed value for the specified named gauge</li>
 *      <li> time - records an execution time in milliseconds for the specified named operation</li>
 * </ul>
 * <p/>
 * options:
 * value - value to change the current value in accordance of data-point.
 *
 * @author dmgcodevil
 */
public class StatsDComponent extends DefaultComponent {

    private StatsDClient statsDClient;

    public StatsDClient getStatsDClient() {
        return statsDClient;
    }

    public void setStatsDClient(StatsDClient statsDClient) {
        this.statsDClient = statsDClient;
    }

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        StatsDEndpoint endpoint = new StatsDEndpoint(uri, this);
        String[] parts = StringUtils.split(remaining, ":");
        // maybe regex is better here ...
        checkArgument(isNotEmpty(parts) && parts.length == 2, "bad uri format, uri = %s", uri);
        endpoint.setOperation(StatsDOperation.fromName(parts[0]));
        endpoint.setAspect(parts[1]);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
