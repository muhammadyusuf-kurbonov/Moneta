package harshbarash.github.io;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Define extends AppCompatActivity {

    //  Если не удобно создавать через ресурсы
//    private static final String[] VALUES = new String[]{
//            "1 Рубль", "2 рубля", "5 рублей", "10 рублей"};


    AutoCompleteTextView value;
    Button addBtn;

    ProgressDialog pd;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.define);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Данные добавлены");

        String[] values = getResources().getStringArray(R.array.coins);

        value = findViewById(R.id.value);
        addBtn = findViewById(R.id.addBtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, values);
        value.setAdapter(adapter);

        pd = new ProgressDialog(this);

        db = FirebaseFirestore.getInstance();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ввод данных
                String nominal_value  = value.getText().toString().trim();
                // Обновление данных
                uploadData(nominal_value);
            }
        });


    }

    private void uploadData(String nominal_value) {
        // вывод на прогрес бар
        pd.setTitle("Добавление файла в Fierstore");
        pd.show();
        String id = UUID.randomUUID().toString();

        Map<String, Object> doc= new HashMap<>();
        doc.put("id", id);
        doc.put("title", nominal_value);

        //добавление данных
        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //успешно добавлен - приход сюда

                pd.dismiss();
                Toast.makeText(Define.this, "Обновленно", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //если неудачно, то сюда
                pd.dismiss();
                Toast.makeText(Define.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
