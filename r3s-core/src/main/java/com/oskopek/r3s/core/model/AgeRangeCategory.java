package com.oskopek.r3s.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by oskopek on 2/20/15.
 */
@Entity
public class AgeRangeCategory extends AbstractEntity implements Category {

    private int minAge, maxAge;
    private String name;

    private AgeRangeCategory() {
        // JPA intentionally empty
    }

    public AgeRangeCategory(String name, int minAge, int maxAge) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @NotNull
    public int getMaxAge() {
        return maxAge;
    }

    //Because of JPA
    private void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @NotNull
    public int getMinAge() {
        return minAge;
    }

    //Because of JPA
    private void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @NotNull
    @Override
    public String getName() {
        return name;
    }

    //Because of JPA
    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isAgeAllowed(int age) {
        return minAge <= age && age <= maxAge;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof AgeRangeCategory)) {
            return false;
        }
        AgeRangeCategory arc = (AgeRangeCategory) o;
        return new EqualsBuilder().append(getName(), arc.getName()).append(getMinAge(), arc.getMinAge())
                .append(getMaxAge(), arc.getMaxAge()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName()).append(getMinAge()).append(getMaxAge()).toHashCode();
    }
}
