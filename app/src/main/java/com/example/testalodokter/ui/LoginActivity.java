package com.example.testalodokter.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testalodokter.R;
import com.example.testalodokter.utils.Session;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText etUsername, etPassword;
    private Button btLogin;
    private String mUsername, mPassword;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new Session(this);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);

        //set disable button
        disableBtLogin();

        //check Session
        checkSession();

        //enabled button
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mUsername = editable.toString();
                mPassword = String.valueOf(etPassword.getText());
                if (mUsername.length() != 0 && mPassword.length() != 0) {
                    enabledBtLogin();
                } else {
                    disableBtLogin();
                }
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPassword = editable.toString();
                mUsername = String.valueOf(etUsername.getText());
                if (mUsername.length() != 0 && mPassword.length() != 0) {
                    enabledBtLogin();
                } else {
                    disableBtLogin();
                }
            }
        });

        btLogin.setOnClickListener(this);
    }

    private void checkSession() {
        if (!session.getStatus().equals("false")){
            startActivity(new Intent(this, HomeActivity.class));
        }
    }

    private void enabledBtLogin() {
        btLogin.setEnabled(true);
        btLogin.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    private void disableBtLogin() {
        btLogin.setEnabled(false);
        btLogin.setBackgroundColor(getResources().getColor(R.color.grey));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btLogin) {
            loginVerification(mUsername, mPassword);
        }
    }

    private void loginVerification(String mUsername, String mPassword) {
        if (mUsername.equals("work.suharjora@gmail.com") && mPassword.equals("P@ssw0rd")){
            session.setStatus("true");
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else {
            Toast.makeText(this, R.string.label_failed_verification_login, Toast.LENGTH_SHORT).show();
        }
    }
}