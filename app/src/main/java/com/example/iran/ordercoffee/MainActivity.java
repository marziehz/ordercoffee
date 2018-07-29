package com.example.iran.ordercoffee;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private int americanoprice = 3;
    private int cappuccinoprice = 3;
    private float latteprice = 4.25f;
    private float mochaprice = 4.5f;
    private float price = 0;


    public float Calculate() {

        EditText americano = findViewById(R.id.americano);
        EditText capuccino = findViewById(R.id.capuccino);
        EditText latte = findViewById(R.id.latte);
        EditText mocha = findViewById(R.id.mocha);


        int a = Integer.parseInt(tryParse(americano));
        int c = Integer.parseInt(tryParse(capuccino));
        int l = Integer.parseInt(tryParse(latte));
        int m = Integer.parseInt(tryParse(mocha));

        price += americanoprice * a + cappuccinoprice * c + latteprice * l + mochaprice * m;

        return price;
    }


    public static String tryParse(EditText editText) {

        if (!TextUtils.isEmpty(editText.getText().toString())) {
            return editText.getText().toString();
        } else {
            return "0";
        }
    }

    public String display() {

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.emailaddress);
        EditText americano = findViewById(R.id.americano);
        EditText capuccino = findViewById(R.id.capuccino);
        EditText latte = findViewById(R.id.latte);
        EditText mocha = findViewById(R.id.mocha);
        CheckBox milk = findViewById(R.id.milk);
        CheckBox sugar = findViewById(R.id.sugar);


        String summaryy = "";

        if (!TextUtils.isEmpty(name.getText().toString()) && !TextUtils.isEmpty(email.getText().toString())) {

            summaryy += "Name: " + name.getText().toString() + "\n";
            summaryy += "Email Address: " + email.getText().toString() + "\n";
            summaryy += "americano: " + americano.getText().toString() + "\n";
            summaryy += "capuccino: " + capuccino.getText().toString() + "\n";
            summaryy += "latte: " + latte.getText().toString() + "\n";
            summaryy += "mocha: " + mocha.getText().toString() + "\n";
            summaryy += "milk : " + milk.isChecked() + "\n";
            summaryy += "sugar : " + sugar.isChecked() + "\n";
            summaryy += "price= " + Calculate() + "$" + "\n";

            return summaryy;

        } else if (TextUtils.isEmpty(name.getText().toString())) {
            return "enter your name";
        } else if (TextUtils.isEmpty(email.getText().toString())) {
            return "enter your email";
        }
        return null;
    }


    public void order(View view) {
        TextView summary = findViewById(R.id.summary);
        summary.setText(display());


    }


    public void web(View view) {

        Uri webpage = Uri.parse("https://google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    public void phone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "+1 881-1123"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void map(View view) {


        Uri uri = Uri.parse("geo:32.565838,54.301374");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
