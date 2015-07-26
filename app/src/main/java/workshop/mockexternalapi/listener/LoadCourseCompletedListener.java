package workshop.mockexternalapi.listener;


import java.util.List;

import workshop.mockexternalapi.data.Course;

public interface LoadCourseCompletedListener {
    public void onFinish(List<Course> courses);
}
