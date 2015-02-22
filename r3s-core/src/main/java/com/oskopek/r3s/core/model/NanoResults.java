package com.oskopek.r3s.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
        long time = resultTimeNano;

        long CONVERT = 1_000_000_000;

        long hours = time / (CONVERT * 3600);
        time -= hours * CONVERT * 3600;

        long minutes = time / (CONVERT * 60);
        time -= minutes * CONVERT * 60;

        BigDecimal seconds = BigDecimal.valueOf(time);
        seconds = seconds.divide(BigDecimal.valueOf(CONVERT));

        return String.format("%d:%02d:%06.3f", hours, minutes, seconds.doubleValue());
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
