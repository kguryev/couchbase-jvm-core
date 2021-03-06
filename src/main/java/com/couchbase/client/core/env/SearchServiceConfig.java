/*
 * Copyright (c) 2017 Couchbase, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.couchbase.client.core.env;

/**
 * Allows to configure a Search Service on a per-node basis.
 *
 * @author Michael Nitschinger
 * @since 1.4.2
 */
public final class SearchServiceConfig extends AbstractServiceConfig {

    /**
     * Internal constructor to create a {@link SearchServiceConfig}.
     *
     * @param minEndpoints minimum number of endpoints to be used
     * @param maxEndpoints maximum number of endpoints to be used
     * @param idleTime the configured idle time
     */
    private SearchServiceConfig(final int minEndpoints, final int maxEndpoints, final int idleTime) {
        super(minEndpoints, maxEndpoints, false, idleTime);
    }

    /**
     * Creates a {@link SearchServiceConfig} with the default idle time.
     *
     * This constructor creates a config with the {@link #DEFAULT_IDLE_TIME}. It allows to configure
     * both the minimum number of endpoints per node to be present at every point in time as well
     * as the allowed maximum.
     *
     * If an endpoint is idle longer than the configured idle time and the service pool does not
     * fall below the configured minimum, it is removed from the pool.
     *
     * @param minEndpoints minimum number of endpoints to be used
     * @param maxEndpoints maximum number of endpoints to be used
     * @return the created {@link SearchServiceConfig}.
     */
    public static SearchServiceConfig create(final int minEndpoints, final int maxEndpoints) {
        return create(minEndpoints, maxEndpoints, DEFAULT_IDLE_TIME);
    }

    /**
     * Creates a {@link SearchServiceConfig} with a custom idle time.
     *
     * This constructor creates a config with a custom idle timeout. It allows to configure
     * both the minimum number of endpoints per node to be present at every point in time as well
     * as the allowed maximum.
     *
     * If an endpoint is idle longer than the configured idle time and the service pool does not
     * fall below the configured minimum, it is removed from the pool.
     *
     * @param minEndpoints minimum number of endpoints to be used
     * @param maxEndpoints maximum number of endpoints to be used
     * @param idleTime the configured idle time
     * @return the created {@link SearchServiceConfig}.
     */
    public static SearchServiceConfig create(final int minEndpoints, final int maxEndpoints, final int idleTime) {
        return new SearchServiceConfig(minEndpoints, maxEndpoints, idleTime);
    }

    @Override
    public String toString() {
        return "SearchServiceConfig{" +
            "minEndpoints=" + minEndpoints() +
            ", maxEndpoints=" + maxEndpoints() +
            ", pipelined=" + isPipelined() +
            ", idleTime=" + idleTime() +
            '}';
    }
}
