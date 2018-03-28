package com.example.guest.messages.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.messages.Constants;
import com.example.guest.messages.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.etCreateMessage) EditText etCreateMessageLabel;
    @BindView(R.id.bSubmitMessage) Button bSubmitMessageLabel;
    private String mMessage;
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mMessageRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mMessageRef = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_MESSAGE);

        super.onCreate(savedInstanceState);
        setContentView(com.example.guest.messages.R.layout.activity_main);
        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//
//        mEditor = mSharedPreferences.edit();

        etCreateMessageLabel.setOnClickListener(this);
        bSubmitMessageLabel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == bSubmitMessageLabel){
            String message = etCreateMessageLabel.getText().toString();
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

//    private void addToSharedPreferences(String message) {
//        mEditor.putString(Constants.PREFERENCES_MESSAGE_KEY, message).apply();
//}
}
