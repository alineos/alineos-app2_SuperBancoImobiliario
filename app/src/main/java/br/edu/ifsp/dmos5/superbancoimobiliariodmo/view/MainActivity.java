package br.edu.ifsp.dmos5.superbancoimobiliariodmo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.dmos5.superbancoimobiliariodmo.R;
import br.edu.ifsp.dmos5.superbancoimobiliariodmo.model.CreditCard;
import br.edu.ifsp.dmos5.superbancoimobiliariodmo.model.StarBank;
import kotlin.jvm.Strictfp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEditText;
    private TextView outputTextView;

    private Button mButton;
    private Button newsButton;
    private Button pro_laboreButton;
    private Button kButton;
    private Button cButton;
    private Button plusButton;
    private Button subButton;
    private Button resetButton;

    private StarBank sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sb.getInstance();
        setContentView(R.layout.activity_main);

        resetButton = findViewById(R.id.button_to_reset);
        resetButton.setOnClickListener(this);


        mButton = findViewById(R.id.button_to_m);
        mButton.setOnClickListener(this);
        newsButton = findViewById(R.id.btn_to_noticias);
        newsButton.setOnClickListener(this);
        pro_laboreButton = findViewById(R.id.btn_to_pro_labore);
        pro_laboreButton.setOnClickListener(this);
        kButton = findViewById(R.id.button_to_k);
        kButton.setOnClickListener(this);
        cButton = findViewById(R.id.button_to_c);
        cButton.setOnClickListener(this);
        plusButton = findViewById(R.id.btn_to_somar);
        plusButton.setOnClickListener(this);
        subButton = findViewById(R.id.btn_to_subtrair);
        subButton.setOnClickListener(this);

        inputEditText = findViewById(R.id.edittext_input);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_to_reset:
                sb.setInstance(null);
                sb.getInstance();
                sb.startCreditCards();
                break;

            case R.id.button_to_m:
                tornaMilhar();
                break;
            case R.id.btn_to_noticias:

                break;
            case R.id.btn_to_pro_labore:
                prolabore();
                break;
            case R.id.button_to_k:
                //necessita emular o cartão
                break;
            case R.id.button_to_c:

                break;
            case R.id.btn_to_somar:

                break;
            case R.id.btn_to_subtrair:

                break;
        }
    }


    void tornaMilhar() {
        double value;
        boolean error = false;

        try {
            value = Double.valueOf(inputEditText.getText().toString());
            if (value < 999) {
                value *= 1000;

            } else {
                error = true;

            }
        } catch (Exception e) {
            error = true;

            throw new RuntimeException(e);
        }
 
        if (error) {
            Toast.makeText(this, R.string.exception_invalid_value, Toast.LENGTH_SHORT).show();
            inputEditText.setText("");
        } else {
            inputEditText.setText("" + value);
        }
    }

    void prolabore() {
        for (CreditCard card : sb.getListCard()) {
            sb.roundCompleted(card, 2000);
        }
    }


}