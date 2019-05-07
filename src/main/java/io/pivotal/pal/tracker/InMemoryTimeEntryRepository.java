package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> data = new HashMap<>();
    long sequence = 1;

    public TimeEntry create(TimeEntry timeEntry) {
        Long id = generatedId();

        TimeEntry timeEntrySaved = new TimeEntry(
            id,
            timeEntry.getProjectId(),
            timeEntry.getUserId(),
            timeEntry.getDate(),
            timeEntry.getHours()
        );

        data.put(id, timeEntrySaved);
        return timeEntrySaved;
    }

    private long generatedId() {
        return sequence++;
    }

    public TimeEntry find(long id) {
        return data.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(data.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        if(data.containsKey(id)){
            TimeEntry timeEntrySaved = new TimeEntry(
                    id,
                    timeEntry.getProjectId(),
                    timeEntry.getUserId(),
                    timeEntry.getDate(),
                    timeEntry.getHours()
            );

            data.put(id, timeEntrySaved);
            return timeEntrySaved;
        } else {
            return null;
        }
    }

    public void delete(long id) {
        data.remove(id);
    }
}
