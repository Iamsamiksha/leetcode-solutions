import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {  
                return false;
            }
        }
       
        calendar.add(new int[] {start, end});
        return true;
    }
}

