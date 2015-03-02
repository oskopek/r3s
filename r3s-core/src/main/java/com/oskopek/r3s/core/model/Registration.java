package com.oskopek.r3s.core.model;

/**
 * Created by oskopek on 2/20/15.
 */
public interface Registration {

    public Runner getRunner();

    public int getRaceNumber();

    public Category getCategory();

    public boolean isConfirmed();

    public boolean isAccepted();

    public Results getResults();

}
