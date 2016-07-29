package com.example.android.welcometochapinumc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WelcomeScreen extends AppCompatActivity {


    Fragment currentFragment = new WelcomeScreenActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

    }


        //This method will select the right fragment based on which button is pushed

        public void selectFrag (View view){

            if (view == findViewById(R.id.toWelcomeScreen))
                {
                    currentFragment = new WelcomeScreenActivity();
                }

            else if (view == findViewById(R.id.toWorshipTimes))
                {
                    currentFragment = new WorshipTimes();
                }

            else if (view == findViewById(R.id.toWelcomeCenter))
                {
                    currentFragment = new WelcomeCenter();
                }

            else if (view == findViewById(R.id.toChildrensMinistry))
                {
                    currentFragment = new ChildrensMinistry();
                }

            else if (view == findViewById(R.id.toNewMembers))
                {
                    currentFragment = new NewMembers();
                }

            else if (view == findViewById(R.id.toFindOutMore))
                {
                    currentFragment = new FindOutMore();
                }

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragHolder, currentFragment);
            ft.commit();


        }







    // this method is used to access the users geolocation services and provide directions to the church.
    public void goToMaps(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri churchLocation = Uri.parse("geo:0,0?q=415+Lexington+Avenue+Chapin+SC");
        intent.setData(churchLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    //This method will send an email to Natalie with subject filled in

    public void emailNatalie (View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "natalie@chapinumc.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Questions about Children's Ministry");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //This method will send email to chris with subject filled in

    public void emailChris (View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "chris@chapinumc.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Questions about New Member Class");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // This method will pull up the dialer with churches number
    public void callChurch(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "8033452801"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // this method will pull up browser to UMC team
    public void toOurTeam(View view) {
        Uri webpage = Uri.parse("http://chapinumc.com/about-cumc/team");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // this method will pull up browser to  who we are page
    public void toWhoWeAre(View view) {
        Uri webpage = Uri.parse("http://chapinumc.com/about-cumc/who-we-are");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



}
