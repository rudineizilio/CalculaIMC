package pr.edu.utfpr.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        etPeso.requestFocus();
    }

    private void btCalcularOnClick() {
        if (etPeso.getText().toString().isEmpty()) {
            etPeso.setError("Campo peso deve ser preenchido.");
            etPeso.requestFocus();
            return;
        }

        if (etAltura.getText().toString().isEmpty()) {
            etAltura.setError("Campo altura deve ser preenchido.");
            etAltura.requestFocus();
            return;
        }

        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());
        double resultado = peso / Math.pow(altura, 2);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        tvResultado.setText(decimalFormat.format(resultado));
    }

    private void btLimparOnClick() {
        etPeso.setText("");
        etAltura.setText("");
        tvResultado.setText("0.0");
        etPeso.requestFocus();
    }
}