package com.example.hellow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import kotlin.Suppress;

public class MainActivity extends AppCompatActivity {

    Button boton = null;
    TextView txtVista = null;
    EditText txtMensaje = null;
    CheckBox check = null;
    CalendarView calendarVista = null;
    String fechaCalendario = null;
    String miSalida = "";
    ImageButton imgboton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boton = findViewById(R.id.btnImprimir);
        txtMensaje = findViewById(R.id.txtHolaMundo);
        txtVista = findViewById(R.id.txtView);
        check = findViewById(R.id.checkBox);
        calendarVista = findViewById(R.id.calendar);
        imgboton = findViewById(R.id.imgbtn);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String hora = formatoHora.format(new Date());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date miFecha = null;
        calendarVista.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Long tiempo = calendarVista.getDate();
                //fechaCalendario = formatoFecha.format(tiempo);
                //fechaCalendario = fechaCalendario.concat(String.valueOf(Year)).concat(String.valueOf(Month)).concat(String.valueOf(Day));
                fechaCalendario = year + "/" + month + "/" + dayOfMonth;
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miSalida += "" + txtMensaje.getText();
                miSalida += ", " + check.isChecked();
                miSalida += ", " + hora;
                miSalida += ", " + fechaCalendario;
                Toast.makeText(getApplicationContext(), miSalida, Toast.LENGTH_SHORT).show();
                miSalida = "";

                Snackbar snack = Snackbar.make(v, "Hola Mundo, estoy en clase de Android", Snackbar.LENGTH_LONG);
                snack.show();
            }
        });

        imgboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puente = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(puente);
            }
        });
    }
}