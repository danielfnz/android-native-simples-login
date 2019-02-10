package br.com.danielfnz.simpleslogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nome = getIntent().getStringExtra("nome");
        String photo_url = getIntent().getStringExtra("photo_url");

        ImageView photo = (ImageView) findViewById(R.id.photo_url);
        TextView userName = (TextView) findViewById(R.id.name);

        Button logout = (Button) findViewById(R.id.logout);

        Picasso.get().load(photo_url).into(photo);
        userName.setText(nome);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(activity);
            }
        });
    }
}
