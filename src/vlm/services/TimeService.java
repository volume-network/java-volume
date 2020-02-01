package vlm.services;

import vlm.util.Time;

public interface TimeService {

    int getEpochTime();

    long getEpochTimeMillis();

    void setTime(Time.FasterTime fasterTime);
}
