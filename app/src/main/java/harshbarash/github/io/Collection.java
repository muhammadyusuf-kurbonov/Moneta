package harshbarash.github.io;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Collection extends AppCompatActivity {

    String id, nominal_value;

    public Collection(String id, String nominal_value) {
        this.id = id;
        this.nominal_value = nominal_value;
    }

    public String getId() {
        return id;
    }

    public String getNominal_value() {
        return nominal_value;
    }

    public void setNominal_value(String nominal_value) {
        this.nominal_value = nominal_value;
    }

    public void setId(String id) {
        this.id = id;
    }

}
