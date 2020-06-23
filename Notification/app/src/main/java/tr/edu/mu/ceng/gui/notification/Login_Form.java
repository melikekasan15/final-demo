package tr.edu.mu.ceng.gui.notification;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {
    EditText mcity, mFullName, mEmail, mPassword, mPhone;
    TextView mCreatBtn;
    Button mgirisbtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);

        mFullName = findViewById(R.id.fullName);
        mcity = findViewById(R.id.city);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mgirisbtn = findViewById(R.id.girisbtn);
        mCreatBtn =findViewById(R.id.createText);

        mgirisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required");
                    return;
                }

                if (password.length() < 8) {
                    mPassword.setError("Password must be >= 8 character");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login_Form.this, "Giriş Başarılı.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(Login_Form.this, "Error!." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mCreatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
