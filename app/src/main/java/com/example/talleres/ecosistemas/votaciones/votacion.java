package com.example.talleres.ecosistemas.votaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class votacion extends AppCompatActivity {

    Button btn_hulk;
    TextView tv_hulk;

    private Button btn_iron;
    private TextView tv_iron;
    private Button btn_capitan;
    private TextView tv_capitan;
    private Button btn_spider;
    private TextView tv_spider;
    private Button btn_thor;
    private TextView tv_thor;
    private Button btn_viuda;
    private TextView tv_viuda;

    FirebaseDatabase db;
    DatabaseReference ref_vengadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);
        db = FirebaseDatabase.getInstance();
        ref_vengadores = db.getReference().child("vengadores");

        btn_hulk = findViewById(R.id.btn_hulk);
        tv_hulk = findViewById(R.id.tv_hulk);
        btn_iron = findViewById(R.id.btn_iron);
        tv_iron = findViewById(R.id.tv_iron);
        btn_capitan = findViewById(R.id.btn_capitan);
        tv_capitan = findViewById(R.id.tv_capitan);
        btn_spider = findViewById(R.id.btn_spider);
        tv_spider = findViewById(R.id.tv_spider);
        btn_thor = findViewById(R.id.btn_thor);
        tv_thor = findViewById(R.id.tv_thor);
        btn_viuda = findViewById(R.id.btn_viuda);
        tv_viuda = findViewById(R.id.tv_viuda);

        btn_hulk.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            ejecutarvotacionvengadores(btn_hulk, tv_hulk);



                                        }
                                    }
        );

        btn_capitan.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               ejecutarvotacionvengadores(btn_capitan, tv_capitan);
                                           }
                                       }
        );

        btn_iron.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            ejecutarvotacionvengadores(btn_iron, tv_iron
                                            );
                                        }
                                    }
        );

        btn_spider.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              ejecutarvotacionvengadores(btn_spider, tv_spider);
                                          }
                                      }
        );

        btn_thor.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            ejecutarvotacionvengadores(btn_thor, tv_thor);
                                        }
                                    }
        );
        btn_viuda.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             ejecutarvotacionvengadores(btn_viuda, tv_viuda);
                                         }
                                     }
        );
    }

    public void ejecutarvotacionvengadores(Button btn_hulk, TextView tv_hulk){
        String vengador = btn_hulk.getText().toString();
        String cantidad = tv_hulk.getText().toString();

        int votos = Integer.parseInt(cantidad) + 1;
        Voto voto = new Voto(vengador, votos);
        ref_vengadores.child(vengador).setValue(voto);

        tv_hulk.setText(votos+"");
    }

}
