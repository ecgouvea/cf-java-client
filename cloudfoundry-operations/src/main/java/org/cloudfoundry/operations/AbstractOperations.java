/*
 * Copyright 2013-2015 the original author or authors.
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

package org.cloudfoundry.operations;

import org.cloudfoundry.client.CloudFoundryClient;

abstract class AbstractOperations {

    protected final CloudFoundryClient cloudFoundryClient;

    private final String organizationId;

    private final String spaceId;

    protected AbstractOperations(CloudFoundryClient cloudFoundryClient, String organizationId, String spaceId) {
        this.cloudFoundryClient = cloudFoundryClient;
        this.organizationId = organizationId;
        this.spaceId = spaceId;
    }

    protected final String getTargetedOrganization() {
        if (this.organizationId == null) {
            throw new IllegalStateException("No organization targeted");
        }
        return this.organizationId;
    }

    protected final String getTargetedSpace() {
        if (this.spaceId == null) {
            throw new IllegalStateException("No space targeted");
        }
        return this.spaceId;
    }

}

