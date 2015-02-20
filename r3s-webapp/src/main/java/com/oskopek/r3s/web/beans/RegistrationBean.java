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

package com.oskopek.r3s.web.beans;

import com.oskopek.r3s.core.model.DefaultRegistration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Provides basic JPA EntityManager persistence for the FileEntry entity.
 */
@Stateless
public class RegistrationBean {

    @PersistenceContext
    private EntityManager em;

    /**
     * Persists the list of FileEntries to the database.
     *
     * @param entries array of FileEntries to persist
     * @see EntityManager#persist(Object)
     */
    public void persist(DefaultRegistration... registrations) {
        for (DefaultRegistration e : registrations) {
            em.persist(e);
        }
    }

    /**
     * Finds the FileEntry with primary key <code>id</code>.
     *
     * @param id the id to query for
     * @return the FileEntry with the given id or null if no such FileEntry exists
     * @see EntityManager#find(Class, Object)
     */
    public DefaultRegistration findById(long id) {
        // return (FileEntry) em.createQuery("select e from FileEntry e where e.id = :id").setParameter("id", id)
        // .getSingleResult();
        return em.find(DefaultRegistration.class, id);
    }

    /**
     * Queries the database, selecting all FileEntries in the table.
     * <p/>
     * Query: <code>select e from FileEntry e</code>
     *
     * @return the list result of the query
     */
    @SuppressWarnings("unchecked")
    public List<DefaultRegistration> getAll() {
        return em.createQuery("select e from DefaultRegistration e").getResultList();
    }

    /**
     * Removes the list of FileEntries from the database.
     *
     * @param entries array of FileEntries to remove
     * @see EntityManager#remove(Object)
     */
    public void remove(DefaultRegistration... registrations) {
        for (DefaultRegistration e : registrations) {
            DefaultRegistration entryToRemove = findById(e.getId());
            em.remove(entryToRemove);
        }
    }

    /**
     * Removes the list of FileEntries from the database.
     *
     * @param ids array of FileEntry IDs to remove
     * @see EntityManager#remove(Object)
     */
    public void remove(long... ids) {
        DefaultRegistration e;
        for (long l : ids) {
            e = em.find(DefaultRegistration.class, l);
            em.remove(e);
        }
    }
}