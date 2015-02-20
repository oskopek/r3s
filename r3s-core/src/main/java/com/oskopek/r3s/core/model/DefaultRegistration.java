package com.oskopek.r3s.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by oskopek on 2/20/15.
 */
@Entity
public class DefaultRegistration extends AbstractModel implements Registration {

    private Runner runner;

    private int raceNumber;
    private Category category;

    private boolean confirmed, accepted;

    private Results results;

    public DefaultRegistration() {
        // JPA intentionally empty
    }

    public DefaultRegistration(boolean accepted, Category category, boolean confirmed, int raceNumber, Results results, Runner runner) {
        this.accepted = accepted;
        this.category = category;
        this.confirmed = confirmed;
        this.raceNumber = raceNumber;
        this.results = results;
        this.runner = runner;
    }

    @NotNull
    @Override
    public Category getCategory() {
        return category;
    }

    @NotNull
    @Override
    public int getRaceNumber() {
        return raceNumber;
    }

    @Embedded
    @Override
    public Results getResults() {
        return results;
    }

    @NotNull
    @Override
    public boolean isAccepted() {
        return accepted;
    }

    @NotNull
    @Override
    public boolean isConfirmed() {
        return confirmed;
    }

    @NotNull
    @Override
    public Runner getRunner() {
        return runner;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof DefaultRegistration)) {
            return false;
        }
        DefaultRegistration dr = (DefaultRegistration) o;
        return new EqualsBuilder().append(runner, dr.getRunner()).append(accepted, dr.isAccepted())
                .append(confirmed, dr.isConfirmed()).append(category, dr.getCategory()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(runner).append(accepted).append(confirmed).append(category).toHashCode();
    }
}
