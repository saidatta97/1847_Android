package com.example.materialapp;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {


    profile name= new profile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

        ViewPager vpager = findViewById(R.id.pager);
        vpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        TabLayout tab= findViewById(R.id.tabLayout);
        tab.setupWithViewPager(vpager);


    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new frag1(); //ChildFragment1 at position 0
                case 1:
                    return new frag2(); //ChildFragment2 at position 1


            }
            return null; //does not happen
        }

        @Override
        public int getCount() {
            return 2; //three fragments
        }






        @Override
        public CharSequence getPageTitle(int position) {
            String title = getItem(position).getClass().getName();
            return title.subSequence(title.lastIndexOf(".") + 1, title.length());
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.ok:

                TextInputEditText uname= findViewById(R.id.name);
                uname.setText(name.name);


                MaterialTextView test2= findViewById(R.id.nametxt);
                test2.setText(uname.getText().toString());

                TextInputEditText phone= findViewById(R.id.mobile);
                phone.setText(name.phone);

                TextInputEditText email= findViewById(R.id.email);
                email.setText(name.email);


                TextInputEditText password= findViewById(R.id.password);
                password.setText(name.password);

                TextInputEditText repassword= findViewById(R.id.repassword);
                repassword.setText(name.password);





        }
        return super.onOptionsItemSelected(item);
    }


}