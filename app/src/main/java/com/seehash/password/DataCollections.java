package com.seehash.password;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DataCollections extends AppCompatActivity {

    long process1, process2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initialize();

    }

    private void initialize()
    {
        prepareArraryList();

        prepareLinkedList();
    }

    private void prepareArraryList()
    {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        for (int x = 0; x< 10000; x++)
        {
            HashMap<String, String> map = new HashMap<>();

            map.put("nos", "" + x);

            arrayList.add(map);
        }

        processArraryList(arrayList);
    }

    private void prepareLinkedList()
    {
        LinkedList<HashMap<String, String>> linkedList = new LinkedList<>();

        for (int x = 0; x< 10000; x++)
        {
            HashMap<String, String> map = new HashMap<>();

            map.put("nos", "" + x);

            linkedList.add(map);
        }

        processLinkedList(linkedList);
    }

    private void processArraryList(ArrayList<HashMap<String, String>> arrayList)
    {
        long time1 = System.currentTimeMillis();

        for (int x = 0; x< 10000; x++)
        {
            HashMap<String, String> map = arrayList.get(x);

            System.out.println(map.get("nos"));

        }

        long time2 = System.currentTimeMillis();

        process1 = (time2 - time1);
    }

    private void processLinkedList(LinkedList<HashMap<String, String>> list)
    {
        long time1 = System.currentTimeMillis();

        for (int x = 0; x< 10000; x++)
        {
            HashMap<String, String> map = list.get(x);

            System.out.println(map.get("nos"));

        }

        long time2 = System.currentTimeMillis();

        Log.d("Array List", "" + process1);

        Log.d("Linked List", "" + (time2 - time1));
    }

}
