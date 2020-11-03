/*
 * Copyright (C) 2020 Bosch.IO GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

package org.ossreviewtoolkit.model

import com.fasterxml.jackson.annotation.JsonInclude

import java.time.Instant

/**
 * A short summary of the advisor result.
 */
data class AdvisorSummary(
    /**
     * The time when the advisor started.
     */
    val startTime: Instant,

    /**
     * The time when the advisor finished.
     */
    val endTime: Instant,

    /**
     * The list of issues that occurred during the advisor run.
     * This property is not serialized if the list is empty to reduce the size of the result file. If there are no
     * issues at all, [AdvisorRecord.hasIssues] already contains that information.
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val issues: List<OrtIssue> = emptyList()
)
