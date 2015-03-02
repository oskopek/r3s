/*
 * Copyright 2014 R3S Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.oskopek.r3s.web.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
@Ignore
public class RolesIT {

    private static final String adminRole = "admin";
    private static final String userRole = "user";
    @Inject
    private HttpServletRequest adminRequest;
    @Inject
    private HttpServletRequest userRequest;

    @Deployment
    public static WebArchive createDeployment() {

        WebArchive testArchive = ShrinkWrap.createFromZipFile(WebArchive.class, new File("target/r3s-webapp.war"));

        testArchive.delete("WEB-INF/classes/META-INF/persistence.xml");
        testArchive.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");

        testArchive.delete("WEB-INF/jboss-web.xml");
        testArchive.addAsWebInfResource("WEB-INF/test-jboss-web.xml", "jboss-web.xml");

        testArchive.addAsResource("arquillian.xml");

        return testArchive;
    }

    @Test
    public void userRoleTest() throws Exception {
        userRequest.login("r3s_user", "user_test");
        assertTrue(userRequest.isUserInRole(userRole));
        userRequest.logout();
    }

    @Test
    public void adminRoleTest() throws Exception {
        adminRequest.login("r3s_admin", "admin_test");
        assertTrue(adminRequest.isUserInRole(adminRole));
        adminRequest.logout();
    }

}
