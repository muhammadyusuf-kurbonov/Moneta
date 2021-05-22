package harshbarash.github.io;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {


    MaterialEditText et_username, et_password, et_email;
    Button registerbtn;
    Toolbar toolbar;

    String username, email, password;

    FirebaseAuth mAuth;

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = findViewById(R.id.toolbarregis);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        et_username = findViewById(R.id.reg_username);
        et_email = findViewById(R.id.reg_email);
        et_password = findViewById(R.id.reg_password);
        registerbtn = findViewById(R.id.register_Account_btn);

        mAuth = FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(v -> {

            email = et_email.getText().toString();
            password = et_password.getText().toString();
            username = et_username.getText().toString();


            if (TextUtils.isEmpty(email)) {
                et_email.setError("Введите почту");
            } else if (TextUtils.isEmpty(username)) {
                et_username.setError("Введите имя пользователя");

            } else if (TextUtils.isEmpty(password)) {
                et_password.setError("Введите пароль");

            } else if (password.length() < 6) {

                et_password.setError("Минимум 6 символов");
            } else {


                registerUser(username, password, email);
            }

        });





    }

    private void registerUser(final String username, String password, final String email) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {

                FirebaseUser user = mAuth.getCurrentUser();

                if (user != null) {
                    reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());


                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("username", username);
                    hashMap.put("email", email);
                    hashMap.put("id", user.getUid());
                    hashMap.put("imageURL", "default");
                    hashMap.put("status", "offline");


                    reference.setValue(hashMap).addOnCompleteListener(task1 -> {


                        if (task1.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Успешный вход", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    });

                }

            }



        });

    }


}