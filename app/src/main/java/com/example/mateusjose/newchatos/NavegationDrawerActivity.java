package com.example.mateusjose.newchatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mateusjose.newchatos.Menu_Activities.MenuBlockedActivity;
import com.example.mateusjose.newchatos.Menu_Activities.MenuInfoActivity;
import com.example.mateusjose.newchatos.Menu_Activities.MenuNewChatActivity;
import com.example.mateusjose.newchatos.Menu_Activities.MenuNewGroupChatActivity;
import com.example.mateusjose.newchatos.Menu_Activities.MenuPendentsActivity;
import com.example.mateusjose.newchatos.Menu_Activities.MenuRecentsActivity;
import com.example.mateusjose.newchatos.Menu_Activities.MenuSettingsActivity;

public class NavegationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_newChat) {
            // Handle the camera action
            Intent main = new Intent(getBaseContext(), MenuNewChatActivity.class);
            startActivity(main);

        } else if (id == R.id.nav_newGroupChat) {

            Intent main = new Intent(getBaseContext(), MenuNewGroupChatActivity.class);
            startActivity(main);
            Toast.makeText(getBaseContext(), "nav_newGroupChat", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_pendents) {
            Intent main = new Intent(getBaseContext(), MenuPendentsActivity.class);
            startActivity(main);
            Toast.makeText(getBaseContext(), "nav_pendents", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_recents) {
            Intent main = new Intent(getBaseContext(), MenuRecentsActivity.class);
            startActivity(main);
            Toast.makeText(getBaseContext(), "nav_recents", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_blocked) {
            Intent main = new Intent(getBaseContext(), MenuBlockedActivity.class);
            startActivity(main);
            Toast.makeText(getBaseContext(), "nav_blocked", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_settings) {
            Intent main = new Intent(getBaseContext(), MenuSettingsActivity.class);
            startActivity(main);
            Toast.makeText(getBaseContext(), "nav_settings", Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_info) {
            Intent main = new Intent(getBaseContext(), MenuInfoActivity.class);
            startActivity(main);
            Toast.makeText(getBaseContext(), "nav_info", Toast.LENGTH_LONG).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
