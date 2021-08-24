package co.urbanraw.samplefragmentproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavBar = findViewById(R.id.bottomNavigationView);
        bottomNavBar.setBackground(null);

        bottomNavBar.setOnNavigationItemSelectedListener(item -> {
            onNavigationItemSelected(item);
            return true;
        });

        replaceFragment(new Fragment1());


    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
//                    case R.id.profile:
//                        Toast.makeText(HomeActivity.this, "Profile press!", Toast.LENGTH_SHORT).show();
//                        return true;
            case R.id.item1:
                replaceFragment(new Fragment1());
                return true;
            case R.id.item2:
                replaceFragment(new Fragment2());
                return true;
            case R.id.item3:
                replaceFragment(new Fragment3());
                return true;
            default:
                return MainActivity.super.onOptionsItemSelected(item);
        }
    }



    public void replaceFragment(Fragment fragment)
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutmain,fragment);
        fragmentTransaction.commit();


    }







}