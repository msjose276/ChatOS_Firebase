package com.example.mateusjose.newchatos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mateusjose.newchatos.Fragments.FragmentTabContacts;
import com.example.mateusjose.newchatos.Fragments.FragmentTabExplor;
import com.example.mateusjose.newchatos.Fragments.FragmentTabMessages;

/**
 * Created by mateusjose on 2/15/18.
 */

public class TabsPager extends FragmentStatePagerAdapter{


    public TabsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){

            case 0:
                return "Contactos";
            case 1:
                return "Mensagem";
            case 2:
                return "Contactos";

        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){

            case 0:
                FragmentTabContacts fragmentTabContacts=new FragmentTabContacts();
                return fragmentTabContacts;
            case 1:
                FragmentTabMessages fragmentTabMessages=new FragmentTabMessages();
                return fragmentTabMessages;
            case 2:
                FragmentTabExplor fragmentTabExplor=new FragmentTabExplor();
                return fragmentTabExplor;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
