package com.bayazid.cpik_present_system.Auth_Profile.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bayazid.cpik_present_system.R;

public class TeachersFragment extends Fragment {
    private Button SignOut, View_Schduled_Attendance_Date,Take_Attendance,View_Attendance_Book, EditAttendance,Single_STD_Qurey;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.content_teachers__panel,container,false);
                Take_Attendance = view.findViewById(R.id.take_attendance_button);
        View_Attendance_Book = view.findViewById(R.id.view_attendance_book_button3);
        EditAttendance = view.findViewById(R.id.edit_already_taken_btn);
        Single_STD_Qurey = view.findViewById(R.id.single_std_query__button4);
        SignOut = view.findViewById(R.id.sign_out_button5);
        SignOut.setVisibility(View.GONE);
                Take_Attendance.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"hii",Toast.LENGTH_SHORT).show();
                    }
                });




                return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Take_Attendance = findViewById(R.id.take_attendance_button);
//        View_Attendance_Book = findViewById(R.id.view_attendance_book_button3);
//        EditAttendance = findViewById(R.id.edit_already_taken_btn);
//        Single_STD_Qurey = findViewById(R.id.single_std_query__button4);
//        SignOut = findViewById(R.id.sign_out_button5);

    }
}
