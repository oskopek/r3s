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

package com.oskopek.r3s.core.model;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Serves as the base abstract class for all Entity model classes. Implements Serializable and is Comparable with other
 * AbstractModels.
 * <p/>
 * The preferred way to override <code>equals</code> and <code>hashCode</code> is to use Apache Commons {@link EqualsBuilder}
 * and {@link HashCodeBuilder}. Do not append the id field to any of the two methods.
 * <p/>
 * The main purpose of this class is to handle the ID of all models and all compares that are done using the id.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Comparable<AbstractEntity> {

    private static final long serialVersionUID = -5140579589148423614L;

    private Long id;

    /**
     * A traditional getter for the id of the model. The field is annotated with {@link Id}, {@link GeneratedValue} and
     * {@link NotNull}.
     *
     * @return the id of the model
     */
    @Id
    @GeneratedValue
    @NotNull
    public Long getId() {
        return id;
    }

    /**
     * @param id the Long number to set
     * @see #getId()
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public int compareTo(AbstractEntity o) {
        return new CompareToBuilder().append(getClass().getName(), o.getClass().getName()).append(id, o.id)
                .toComparison();
    }
}