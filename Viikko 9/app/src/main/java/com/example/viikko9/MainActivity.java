package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Spinner valTeatteri;
    Spinner valPvm;
    Spinner valEnnen;
    Spinner valJalkeen;
    Spinner valElo;
    Button katsoButton;
    int selecItem;
    int valinta;
    int valintaEnnen;
    int valintaJalkeen;
    String tId;
    String pvm;
    TextView text;
    Context context;
    ArrayAdapter<String> pvmAdapter;
    ArrayAdapter<String> theatreAdapter;
    ArrayAdapter<String> valEnnenAdapter;
    ArrayAdapter<String> valJalkeenAdapter;
    ArrayList<Theatre> theatreList = new ArrayList<Theatre>();
    ArrayList<String> IDList = new ArrayList<String>();
    ArrayList<Show> showsList = new ArrayList<Show>();
    ArrayList<String> imgList = new ArrayList<>();
    RecyclerView recyclerView;
    String ennenKello;
    String jalkeenKello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        valTeatteri = findViewById(R.id.valTeatteri);
        valPvm = findViewById(R.id.valPvm);

        katsoButton = findViewById(R.id.katsoButton);
        recyclerView = findViewById(R.id.recyclerView);

        getTheaters();
        addDatesToSpinner();

        katsoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getShows();
            }
        });

    }

    public void getTheaters() {
        theatreList = new ArrayList<>();
        theatreList = ReadXML.readTheatreAreaXML();
        ArrayList<String> tempNameList = new ArrayList<>();

        IDList.clear();
        for (int i = 0; i < theatreList.size(); i++) {
            tempNameList.add(theatreList.get(i).getName());
            IDList.add(theatreList.get(i).getId());
        }

        theatreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tempNameList);
        theatreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        valTeatteri.setAdapter(theatreAdapter);
        valTeatteri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valinta = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void addDatesToSpinner() {

        Date currentDate = new Date();

        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTime(currentDate);

        int daysForward = 14;

        ArrayList<String> allDays = new ArrayList<String>();
        SimpleDateFormat mFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < daysForward; i++) {
            // Add day to list
            allDays.add(mFormat.format(mCalendar.getTime()));
            // Move next day
            mCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        pvmAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, allDays);
        pvmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        valPvm.setAdapter(pvmAdapter);

        valPvm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pvm = valPvm.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void getShows() {
        String valitTheater = String.valueOf(IDList.get(valinta));
        System.out.println(valitTheater);
        showsList = ReadXML.readScheduleXML(valitTheater, pvm);
        imgList = ReadXML.readImgXML(valitTheater, pvm);

        if (showsList.isEmpty()) {
            MyAdapter myAdapter = new MyAdapter(this, showsList, imgList);
            Toast.makeText(MainActivity.this, "Ei näytöksiä valitulle päivälle.", Toast.LENGTH_LONG).show();
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            MyAdapter myAdapter = new MyAdapter(this, showsList, imgList);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }


}