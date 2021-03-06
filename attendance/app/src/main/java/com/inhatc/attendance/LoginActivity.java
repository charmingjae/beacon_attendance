package com.inhatc.attendance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtLoginNUM;
    EditText edtLoginPW;
    Button btnDoLogin;
    ProgressDialog progressDialog;
    //define firebase object
    FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtLoginNUM = (EditText)findViewById(R.id.edtLoginNUM);
        edtLoginPW = (EditText)findViewById(R.id.edtLoginPW);
        btnDoLogin = (Button)findViewById(R.id.btnDoLogin);
        btnDoLogin.setOnClickListener(this);


        //initializig firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            Query query = reference.child("consumers").orderByChild("userId").equalTo(firebaseAuth.getCurrentUser().getEmail());
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        for(DataSnapshot issue : snapshot.getChildren()){

                            Log.w("ISSUE : ", issue.child("userPosition").getValue().toString());
                            if(issue.child("userPosition").getValue().toString().equals("customer")){
                                Log.i("status : ", "True");
                                startActivity(new Intent(getApplicationContext(), BeaconDetectActivity.class));
                                finish();
                            }
                            else{
                                Log.i("status : ", "False");
                                finish();
                                startActivity(new Intent(getApplicationContext(), ReservationStatusActivity.class));
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            // How to get logined user email
//            Log.i("LoginActivity",firebaseAuth.getCurrentUser().getEmail());
            // ?????? ????????? ???????????? ??? ??????????????? ?????????
            finish();
            // ????????? UserInfo ??????????????? ??????.
//            startActivity(new Intent(getApplicationContext(), UserInfoActivity.class));
            // ?????? ?????? ?????????????????? ?????? ??????
//            startActivity(new Intent(getApplicationContext(), BeaconDetectActivity.class));
        }
    }

    //firebase userLogin method
    private void userLogin(){
        String email = edtLoginNUM.getText().toString().trim();
        String password = edtLoginPW.getText().toString().trim();

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("?????????????????????. ?????? ????????? ?????????...");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            finish();
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "????????? ??????!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == btnDoLogin) {
            userLogin();
        }
    }

}
