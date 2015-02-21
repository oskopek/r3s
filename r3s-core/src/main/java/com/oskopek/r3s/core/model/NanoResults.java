package com.oskopek.r3s.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by oskopek on 2/20/15.
 */
@Embeddable
public class NanoResults extends AbstractEmbeddable implements Results {

    private long resultTimeNano;

    private NanoResults() {
        // JPA intentionally empty
    }

    public NanoResults(long resultTimeNano) {
        this.resultTimeNano = resultTimeNano;
    }

    @NotNull
    public long getResultTimeNano() {
        return resultTimeNano;
    }

    private void setResultTimeNano(long resultTimeNano) {
        this.resultTimeNano = resultTimeNano;
    }

    @Transient
    @Override
    public String getResultTime() {
        return resultTimeNano + ""; // TODO nanores
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NanoResults)) return false;

        NanoResults that = (NanoResults) o;

        return new EqualsBuilder().append(resultTimeNano, that.getResultTimeNano()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(resultTimeNano).toHashCode();
    }
}
