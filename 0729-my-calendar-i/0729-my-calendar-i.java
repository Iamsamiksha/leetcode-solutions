class MyCalendar {
    public List <int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {
        for(int[] s : calendar){
            if(
                (start< s[0] && end >s[0]) || (start == s[0]) || (start >s[0]) && start < s[1])
            {
                return false;
            }
    
        }
        calendar.add(new int[] {start,end});
        return true;
    }
}
