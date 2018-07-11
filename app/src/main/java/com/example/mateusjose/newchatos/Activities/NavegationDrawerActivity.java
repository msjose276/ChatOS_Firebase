package com.example.mateusjose.newchatos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
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

import com.example.mateusjose.newchatos.R;
import com.example.mateusjose.newchatos.TabsPager;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

import static com.example.mateusjose.newchatos.Activities.ExchangeMessageActivity.ANONYMOUS;

public class NavegationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private String mUsername;


    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build());


    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;


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


        //**************** for sliding menu

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        ViewPager viewPager=(ViewPager)findViewById(R.id.container);
        TabsPager tabsPager=new TabsPager(getSupportFragmentManager());

        viewPager.setAdapter(tabsPager);
        tabLayout.setupWithViewPager(viewPager);
        //********************** end of sliding menu


        //check if the user is logged in
        mFirebaseAuth = FirebaseAuth.getInstance();
        checkIfLogIn();

        Intent main = new Intent(getBaseContext(), ExchangeMessageActivity.class);
        startActivity(main);

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


        } else if (id == R.id.nav_newGroupChat) {


            Toast.makeText(getBaseContext(), "nav_newGroupChat", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_pendents) {

            Toast.makeText(getBaseContext(), "nav_pendents", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_recents) {

            Toast.makeText(getBaseContext(), "nav_recents", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_blocked) {
            Toast.makeText(getBaseContext(), "nav_blocked", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_settings) {
            Toast.makeText(getBaseContext(), "nav_settings", Toast.LENGTH_LONG).show();
        }else if (id == R.id.nav_info) {
            Toast.makeText(getBaseContext(), "nav_info", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void checkIfLogIn(){

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                //if the user is signed in
                if (user != null) {
                    Toast.makeText(NavegationDrawerActivity.this, "you are logged in", Toast.LENGTH_SHORT).show();
                    //Intent main = new Intent(getBaseContext(), UserProfileActivity.class);
                    //startActivity(main);

                } else {
                    mUsername = ANONYMOUS;
                    // Create and launch sign-in intent
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

    }


    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}
