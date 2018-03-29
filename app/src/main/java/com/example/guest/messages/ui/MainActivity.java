package com.example.guest.messages.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.messages.Constants;
import com.example.guest.messages.R;
import com.example.guest.messages.adapters.MessageListAdapter;
import com.example.guest.messages.models.Chat;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.etCreateMessage) EditText etCreateMessageLabel;
    @BindView(R.id.bSubmitMessage) Button bSubmitMessageLabel;
    @BindView(R.id.rvMessages) RecyclerView mRvMessages;
    private String mMessage;
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mMessageRef;
    private ValueEventListener mMessageRefListener;
    private FirebaseRecyclerAdapter mFirebaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.guest.messages.R.layout.activity_main);
        ButterKnife.bind(this);


    }



    @Override
    public void onClick(View v){
        if(v == bSubmitMessageLabel){

            String message = etCreateMessageLabel.getText().toString();
//            Chat chat = new Chat(message, "Ross","3/28/18");
            saveMessageToFirebase(message);
//            System.out.println(message);
//            addToSharedPreferences(message);
//            mMessage = mSharedPreferences.getString(Constants.PREFERENCES_MESSAGE_KEY, null);
//            Log.d("Shared Pref Location", mMessage);

        }
    }
    public void saveMessageToFirebase(String message) {
        mMessageRef.push().setValue(message);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMessageRef.removeEventListener(mMessageRefListener);
    }

//    private void addToSharedPreferences(String message) {
//        mEditor.putString(Constants.PREFERENCES_MESSAGE_KEY, message).apply();
//}
}
