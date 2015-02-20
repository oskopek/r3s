/*
 * Copyright 2015 R3S Development Team
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

import com.oskopek.r3s.web.beans.RegistrationBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
@RunWith(Arquillian.class)
public class PersistenceIT {

    @Deployment
    public static WebArchive createDeployment() {

        WebArchive testArchive = ShrinkWrap.createFromZipFile(WebArchive.class, new File("target/r3s-webapp.war"));

        testArchive.delete("WEB-INF/classes/META-INF/persistence.xml");
        testArchive.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");

        testArchive.delete("WEB-INF/jboss-web.xml");
        testArchive.addAsWebInfResource("WEB-INF/test-jboss-web.xml", "jboss-web.xml");

        testArchive.addAsResource("arquillian.xml");

        // testArchive.as(ZipExporter.class).exportTo(new
        // File("target/r3s-webapp-test.war"));

        return testArchive;
    }

    @EJB
    private RegistrationBean registrationBean;

    @Test
    public void persistenceTest() {
        // TODO PersistenceTest
        // Entity code

        /*
        Speed speed = new Speed(80d, SpeedUnit.KPH);
        Address address = new Address("Myjava", "90701", "Jablonská", "Slovakia", 27, 860);
        NumberPlate licencePlate = new NumberPlate("MY-077AU", "SK");
        Date timestamp = new Date(System.currentTimeMillis());
        FileCarImage carImage = new FileCarImage(Paths.get("/tmp/test/video.h264"));
        CarData carData = new CarData(speed, address, licencePlate, timestamp);
        FileEntry fileEntry = new FileEntry(carData, Arrays.asList(carImage));


        assertNotNull(fileEntry);
        // End entity code

        // Persist
        assertNotNull(registrationBean);
        registrationBean.persist(fileEntry);

        // Get
        FileEntry got = registrationBean.getAll().get(0);
        assertEquals(fileEntry, got);

        // Check
        assertEquals(carImage, got.getCarImages().get(0));
        assertEquals(speed, got.getCarData().getSpeed());
        assertEquals(address, got.getCarData().getAddress());
        assertEquals(licencePlate, got.getCarData().getNumberPlate());
        assertEquals(carData, got.getCarData());
        assertEquals(timestamp, got.getCarData().getTimestamp());
        assertEquals(fileEntry, got);

        // Remove
        registrationBean.remove(fileEntry.getId());
        assertEquals(0, registrationBean.getAll().size());
        assertEquals(null, registrationBean.findById(fileEntry.getId()));

        */
    }
}