package workshop.mockexternalapi.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import workshop.mockexternalapi.R;
import workshop.mockexternalapi.data.Course;

public class CourseApdater extends RecyclerView.Adapter<CourseApdater.CourseViewHolder>{

    private List<Course> courses;

    public CourseApdater(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course, viewGroup, false);
        CourseViewHolder courseViewHolder = new CourseViewHolder(view);
        return courseViewHolder;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder courseViewHolder, int i) {
        courseViewHolder.courseName.setText(courses.get(i).name);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView courseName;
        ImageView coursePhoto;

        CourseViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            courseName = (TextView)itemView.findViewById(R.id.course_name);
            coursePhoto = (ImageView)itemView.findViewById(R.id.course_photo);
        }
    }

}