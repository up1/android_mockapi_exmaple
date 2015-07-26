package workshop.mockexternalapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import workshop.mockexternalapi.adapter.CourseApdater;
import workshop.mockexternalapi.data.Course;
import workshop.mockexternalapi.listener.LoadCourseCompletedListener;
import workshop.mockexternalapi.task.CourseAsyncTask;

public class MainActivity extends AppCompatActivity implements LoadCourseCompletedListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        String courseUrl = BuildConfig.COURSE_URL;
        new CourseAsyncTask(this).execute(courseUrl);
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Course 01", "Description for course 01"));
        courses.add(new Course("Course 02", "Description for course 02"));
        courses.add(new Course("Course 03", "Description for course 03"));
        courses.add(new Course("Course 04", "Description for course 04"));
        courses.add(new Course("Course 05", "Description for course 05"));
        courses.add(new Course("Course 06", "Description for course 06"));

        return  courses;
    }

    @Override
    public void onFinish(List<Course> courses) {
        CourseApdater courseApdater = new CourseApdater(courses);
        recyclerView.setAdapter(courseApdater);
    }
}
