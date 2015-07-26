package workshop.mockexternalapi.task;


import android.os.AsyncTask;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import workshop.mockexternalapi.data.Course;
import workshop.mockexternalapi.listener.LoadCourseCompletedListener;

public class CourseAsyncTask extends AsyncTask<String, Void, List<Course>> {

    private final LoadCourseCompletedListener listener;

    public CourseAsyncTask(LoadCourseCompletedListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
    }

    protected List<Course> doInBackground(String... urls)   {
        List<Course> courses = new ArrayList<>();

        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder();
        System.out.println("URL = " + urls[0]);
        Request request = builder.url(urls[0]).build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                Gson gson = new Gson();
                ListCourse courseList = gson.fromJson(response.body().charStream(), ListCourse.class);
                for(CourseDetail courseDetail : courseList.results){
                    courses.add(new Course(courseDetail.title, "detail"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    static class ListCourse {
        List<CourseDetail> results;
    }

    static class CourseDetail {
        String title;
        String price;
    }

    protected void onPostExecute( List<Course> courses)  {
        listener.onFinish(courses);
    }
}