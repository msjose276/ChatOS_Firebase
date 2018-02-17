package com.example.mateusjose.newchatos.Adaptor;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mateusjose.newchatos.Objects.Contact;
import com.example.mateusjose.newchatos.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mateusjose on 1/9/18.
 */

public class ItemAdaptor extends ArrayAdapter<Contact> {

    List<Contact> listCard;
    LayoutInflater layoutInflater;
    int fragmentType;
    public ItemAdaptor(@NonNull Context context, @NonNull List objects) {
        super(context, R.layout.item_card, objects);
        listCard=objects;
        layoutInflater=LayoutInflater.from(context);
        //if no fragmentType is defined
        fragmentType=0;
    }

    public ItemAdaptor(@NonNull Context context, @NonNull List objects,int fragmentType) {
        super(context, R.layout.item_card, objects);
        listCard=objects;
        layoutInflater=LayoutInflater.from(context);
        this.fragmentType=fragmentType;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView=layoutInflater.inflate(R.layout.item_card,parent,false);
        }

        // get the views
        TextView fullName= (TextView) convertView.findViewById(R.id.tvFullName);
        TextView numberOfMessages= (TextView) convertView.findViewById(R.id.tvNumberOfMessages);
        CircleImageView profileImage= (CircleImageView) convertView.findViewById(R.id.ciImage);

        //set the full name of the contact
        fullName.setText(listCard.get(position).getFirstName() +" "+ listCard.get(position).getLastName());

        // check if the contact has messages not read. if yes, it shows. else it makes the textview invisible
        if(listCard.get(position).getNumberOfMessagesNotRead()==0)
            numberOfMessages.setVisibility(View.INVISIBLE);
        else
            numberOfMessages.setText(Integer.toString(listCard.get(position).getNumberOfMessagesNotRead()));


        // check if the contact has profile picture . if it does not set the profile picture to a general picture
        if(listCard.get(position).getProfilePicture()==null)
            profileImage.setImageBitmap(BitmapFactory.decodeResource(convertView.getResources(), R.drawable.user_general_image));
        else
            profileImage.setImageBitmap(listCard.get(position).getProfilePicture());

        if(listCard.get(position).getIsOnline()==true){
            //set the width for the border
            profileImage.setBorderWidth(10);
            //set the color for the border
            profileImage.setBorderColor(Color.rgb(240,165,40));


        }
        else
            profileImage.setBorderWidth(0);

        // define the color for different fragments
        if(fragmentType==0){
            // white for contact fragment
            fullName.setTextColor(Color.WHITE);

        }else if(fragmentType==1){
            //dark for the message fragment
            fullName.setTextColor(Color.rgb(2,30,67));
        }
        else if (fragmentType==2){
            // white for explor
            fullName.setTextColor(Color.WHITE);
        }

        return convertView;
    }

}
