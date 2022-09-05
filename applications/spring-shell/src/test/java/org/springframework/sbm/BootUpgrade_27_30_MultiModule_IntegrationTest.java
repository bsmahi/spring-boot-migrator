/*
 * Copyright 2021 - 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.sbm;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BootUpgrade_27_30_MultiModule_IntegrationTest  extends IntegrationTestBaseClass {
    @Override
    protected String getTestSubDir() {
        return "boot-migration-27-30-multi-module";
    }

    @Test
    @Tag("integration")
    void migrateMultiModuleApplication() {
        intializeTestProject();

        scanProject();

        applyRecipe("boot-2.7-3.0-dependency-version-update");

        buildProject();
    }

    private void buildProject() {
        executeMavenGoals(getTestDir(), "clean", "verify");
    }
}