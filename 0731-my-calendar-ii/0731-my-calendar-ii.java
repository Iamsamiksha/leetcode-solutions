import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> calendar;  // To store all single bookings
    private List<int[]> overlaps;  // To store double bookings (overlaps)

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if this new event causes a triple booking
        for (int[] event : overlaps) {
            if (start < event[1] && end > event[0]) {  // If the new event overlaps with any double booking
                return false;
            }
        }

        // Check for overlaps with single bookings and add them to overlaps
        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {  // If the new event overlaps with an existing single booking
                // Calculate the overlapping interval and add it to the overlaps list
                int overlapStart = Math.max(start, event[0]);
                int overlapEnd = Math.min(end, event[1]);
                overlaps.add(new int[] {overlapStart, overlapEnd});
            }
        }

        // Add the new event to the calendar (single bookings)
        calendar.add(new int[] {start, end});
        return true;
    }
}
