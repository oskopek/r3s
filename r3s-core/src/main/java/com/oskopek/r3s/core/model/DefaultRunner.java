package com.oskopek.r3s.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by oskopek on 2/20/15.
 */
@Entity
public class DefaultRunner extends AbstractEntity implements Runner {

    private String firstName, lastName, teamName;
    private int birthYear;

    private DefaultRunner() {
        // JPA intentionally empty
    }

    public DefaultRunner(int birthYear, String firstName, String lastName, String teamName) {
        this.birthYear = birthYear;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamName = teamName;
    }

    @NotNull
    @Override
    public int getBirthYear() {
        return birthYear;
    }

    @NotNull
    @Override
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Override
    public String getLastName() {
        return lastName;
    }

    @NotNull
    @Override
    public String getTeamName() {
        return teamName;
    }

    //Because of JPA
    private void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    //Because of JPA
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Because of JPA
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Because of JPA
    private void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int age() {
        return 0; // TODO calcAge
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
        return false;
    } else if (!(o instanceof DefaultRunner)) {
        return false;
    }
        DefaultRunner lr = (DefaultRunner) o;
        return new EqualsBuilder().append(firstName, lr.getFirstName()).append(lastName, lr.getLastName())
                .append(birthYear, lr.getBirthYear()).append(teamName, lr.getTeamName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(birthYear).append(teamName).toHashCode();
    }
}
