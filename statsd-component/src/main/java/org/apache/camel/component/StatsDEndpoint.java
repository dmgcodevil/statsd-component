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

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * Represents a StatsDEndpoint endpoint.
 */
public class StatsDEndpoint extends DefaultEndpoint {


    private StatsDOperation operation;

    private Integer value;

    private String aspect;

    public StatsDEndpoint() {
    }

    public StatsDEndpoint(String uri, StatsDComponent component) {
        super(uri, component);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public StatsDOperation getOperation() {
        return operation;
    }

    public void setOperation(StatsDOperation operation) {
        this.operation = operation;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public Producer createProducer() throws Exception {
        return new StatsDProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new StatsDConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
}
