/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v2.serviceusageevents;

import org.cloudfoundry.ValidationResult;
import org.junit.Test;

import static org.cloudfoundry.ValidationResult.Status.INVALID;
import static org.cloudfoundry.ValidationResult.Status.VALID;
import static org.junit.Assert.assertEquals;

public final class GetServiceUsageEventRequestTest {

    @Test
    public void isNotValidNoId() {
        ValidationResult result = GetServiceUsageEventRequest.builder()
            .build()
            .isValid();

        assertEquals(INVALID, result.getStatus());
        assertEquals("service usage event id must be specified", result.getMessages().get(0));
    }

    @Test
    public void isValid() {
        ValidationResult result = GetServiceUsageEventRequest.builder()
            .serviceUsageEventId("test-service-usage-event-id")
            .build()
            .isValid();

        assertEquals(VALID, result.getStatus());
    }

}