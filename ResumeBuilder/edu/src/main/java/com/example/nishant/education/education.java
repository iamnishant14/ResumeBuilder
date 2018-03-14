package com.example.nishant.education;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nisha on 29-12-2017.
 */

public class education extends Fragment {
    private static ArrayList<eduDetails> listEdu;
    private ListView eduListView;
    private ImageButton moreDetails;
    private LinearLayout layout;
    private ImageButton detailsCancel;
    private ImageButton detailsDone;
    private View embeddedView;
    private eduAdapter eduAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.educationdetails,container,false);
        eduListView=v.findViewById(R.id.eduListDetailsList);
        layout=v.findViewById(R.id.addMoreDetails);
        embeddedView=inflater.inflate(R.layout.edulist,null,false);
        layout.addView(embeddedView);
        layout.setVisibility(View.GONE);
        moreDetails=v.findViewById(R.id.more_details);
        detailsCancel=(ImageButton) embeddedView.findViewById(R.id.edu_details_cancel);
        detailsDone=(ImageButton)embeddedView.findViewById(R.id.edu_details_done);

        /**
         * Sample DataSet
         */
        eduDetails e= new eduDetails("DAV","9.7","2","2009","Intermediate");
        listEdu= new ArrayList<>();
        eduAdapter= new eduAdapter(getContext(),listEdu);
        eduListView.setAdapter(eduAdapter);

        /**
         * onClick Method for saving the details.
         */
        detailsDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetails();
            }
        });

        /**
         * onClick Method for deleting current pending details;
         */
        detailsCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreDetails.setVisibility(View.VISIBLE);
                layout.setVisibility(View.GONE);
            }
        });

        /**
         * onClick Method for expanding list to update details;
         */
        moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                moreDetails.setVisibility(View.GONE);
            }
        });
        /**
         *  Method to flood the listView of already saved details.
         */

        if(listEdu==null){
            eduListView.setVisibility(View.GONE);
        }
        else{
            if(listEdu.size()==0){
                eduListView.setVisibility(View.GONE);
            }
            else{
                eduListView.setVisibility(View.VISIBLE);
            }
        }
        return v;
    }

    /**
     * Method to update the listView for current details;
     */
    private void updateDetails(){
        EditText school=embeddedView.findViewById(R.id.edu_school);
        EditText branch=embeddedView.findViewById(R.id.edu_branch);
        EditText cgpa=embeddedView.findViewById(R.id.edu_cgpa);
        EditText rank=embeddedView.findViewById(R.id.edu_rank);
        EditText session=embeddedView.findViewById(R.id.edu_session);
        Log.v("School Details",school.getText().toString());
        if(school.getText().toString()==""){
            Toast.makeText(getContext(),"Invalid School Details",Toast.LENGTH_LONG).show();
            return;
        }
        if(branch.getText().toString()==""){
            Toast.makeText(getContext(),"Invalid Class / Branch Details",Toast.LENGTH_LONG).show();
            return;
        }
        if(cgpa.getText().toString()==""){
            Toast.makeText(getContext(),"Invalid CGPA / % Marks Details",Toast.LENGTH_LONG).show();
            return;
        }
        if(rank.getText().toString()==""){
            Toast.makeText(getContext(),"Invalid Class / Branch Rank Details",Toast.LENGTH_LONG).show();
            return;
        }
        if(session.getText().toString()==""){
            Toast.makeText(getContext(),"Invalid Session Details",Toast.LENGTH_LONG).show();
            return;
        }

        eduDetails localEduDetails= new eduDetails(school.getText().toString(),cgpa.getText().toString(),rank.getText().toString(),session.getText().toString(),branch.getText().toString());
        listEdu.add(localEduDetails);
        eduListView.setVisibility(View.VISIBLE);
        eduAdapter.notifyDataSetChanged();
        layout.setVisibility(View.GONE);
        moreDetails.setVisibility(View.VISIBLE);
        Log.v("Number of items",String.valueOf(eduAdapter.getCount()));
    }

    private void updateUI(){
        eduListView.setVisibility(View.VISIBLE);
    }
    private ArrayList<eduDetails> generateItemsList(){
        return null;
    }
}
