package com.mayurphadte.checkerappiitb2017;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;



public class TicketActivity extends AppCompatActivity {

    String boardingPoint, destination, timeStamp, time2Stamp;
    DatabaseReference myRefuser;
    TextView placeName,place2Name, timeFrame, time2Frame;
    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_resource);


        String user_ID = getIntent().getExtras().getString("User ID");

        Log.d("Hi", user_ID);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRefuser = database.getReference("user").child(user_ID);
        //DatabaseReference myRefuser = database.getReference("user").child("gtW5oxaTf8Vt1Nzq3XydvSUl7ry2");
        placeName = (TextView) findViewById(R.id.placeName);
        place2Name = (TextView) findViewById(R.id.place2Name);
        timeFrame = (TextView) findViewById(R.id.timeFrame);
        time2Frame = (TextView) findViewById(R.id.time2Frame);
        /*boardingPoint = myRefuser.child("boardingPoint");
        destination = myRefuser.child("destination").toString();
        timeStamp = myRefuser.child("timeStamp").toString();
        time2Stamp = myRefuser.child("time2Stamp").toString();

        placeName.setText(boardingPoint);
        place2Name.setText(destination);
        String formatted1Time = timeStamp;
        String formatted2Time = time2Stamp;

        Log.d("Time is :", formatted1Time);
        timeFrame.setText(formatted1Time);
        time2Frame.setText(formatted2Time);*/

    }

        @Override
        protected void onStart() {
            super.onStart();
            myRefuser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    currentUser = dataSnapshot.getValue(User.class);
                    Log.d("Hi","Hello");

                   boardingPoint= currentUser.getBoardingPoint();
                    Toast.makeText(TicketActivity.this,boardingPoint, Toast.LENGTH_LONG).show();

                    placeName.setText(currentUser.getBoardingPoint());
                    place2Name.setText(currentUser.getDestination());

                    timeFrame.setText(currentUser.getTimeStamp());
                    time2Frame.setText(currentUser.getTime2Stamp());

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }


            });

        }
}
