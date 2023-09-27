import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        recyclerView = findViewById(R.id.recycler_view);

        // RecyclerView 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ScheduleAdapter();
        recyclerView.setAdapter(adapter);

        // 캘린더 뷰 리스너 설정
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // 선택한 날짜에 해당하는 일정을 RecyclerView에 표시
                String selectedDate = year + "/" + (month + 1) + "/" + dayOfMonth;
                adapter.setScheduleData(getScheduleForDate(selectedDate));
            }
        });

        // 예시: 2023년 9월 27일에 "일정 1" 추가
        addSchedule("2023/9/27", "일정 1");
    }

    // 날짜별 일정을 가져오는 메서드 (실제로는 데이터베이스나 파일에서 데이터를 가져와야 합니다)
    private List<String> getScheduleForDate(String date) {
        List<String> scheduleList = new ArrayList<>();

        // 예시 데이터
        if (date.equals("2023/9/27")) {
            scheduleList.add("일정 1");
        } else if (date.equals("2023/9/28")) {
            scheduleList.add("일정 2");
        }

        return scheduleList;
    }

    // 일정을 추가하는 메서드
    private void addSchedule(String date, String schedule) {
        // 실제로는 데이터베이스나 파일에 일정을 추가하는 코드를 여기에 작성해야 합니다.
    }
}
