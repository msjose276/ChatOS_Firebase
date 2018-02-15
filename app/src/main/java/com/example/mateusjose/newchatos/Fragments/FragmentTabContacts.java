package com.example.mateusjose.newchatos.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mateusjose.newchatos.Contact;
import com.example.mateusjose.newchatos.ItemAdaptor;
import com.example.mateusjose.newchatos.NavegationDrawerActivity;
import com.example.mateusjose.newchatos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusjose on 1/9/18.
 */

public class FragmentTabContacts extends android.support.v4.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View page=inflater.inflate(R.layout.tab_general,container,false);
        page.setBackgroundResource(R.color.orange);


        final List<Contact> listOfContacts=new ArrayList<>();
        listOfContacts.add(new Contact("Jose","Manuel","8129292903",BitmapFactory.decodeResource(this.getResources(), R.drawable.bonita)));
        listOfContacts.add(new Contact("mae","812000000"));
        listOfContacts.add(new Contact("joaquim"," fernando","8127777777"));
        listOfContacts.add(new Contact("puto da paraboloca","317888888888"));
        listOfContacts.add(new Contact("marcia","marilia","333331234131",BitmapFactory.decodeResource(this.getResources(), R.drawable.bonita)));
        listOfContacts.add(new Contact("edna","sibo","234234545542"));
        listOfContacts.add(new Contact("pai","235354542"));


        //Mateus: call and set the card adaptor
        ItemAdaptor adaptor = new ItemAdaptor(getContext(),listOfContacts,0);
        final ListView listView = (ListView) page.findViewById(R.id.lvItem);
        listView.setAdapter(adaptor);

        //mateus: set onclick listner for the list of items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(), NavegationDrawerActivity.class);
                startActivity(intent);
            }
        });


        return page;
    }
}
