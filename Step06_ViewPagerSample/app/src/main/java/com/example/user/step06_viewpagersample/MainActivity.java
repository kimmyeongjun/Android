package com.example.user.step06_viewpagersample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    // static 맴버 메소드에서 참조 되어야 함으로 static 으로 선언한다.
    static List<CountryDto> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //모델 객체 생성
        countries=new ArrayList<>();
        //셈플 데이터
        countries.add(new CountryDto(R.drawable.austria, "오스트리아"));
        countries.add(new CountryDto(R.drawable.belgium, "벨기에"));
        countries.add(new CountryDto(R.drawable.brazil, "브라질"));
        countries.add(new CountryDto(R.drawable.france, "프랑스"));
        countries.add(new CountryDto(R.drawable.germany, "독일"));
        countries.add(new CountryDto(R.drawable.greece, "그리스"));
        countries.add(new CountryDto(R.drawable.israel, "이스라엘"));
        countries.add(new CountryDto(R.drawable.italy, "이탈리아"));
        countries.add(new CountryDto(R.drawable.japan, "일본"));
        countries.add(new CountryDto(R.drawable.korea, "대한민국"));
        countries.add(new CountryDto(R.drawable.poland, "폴란드"));
        countries.add(new CountryDto(R.drawable.spain, "스페인"));
        countries.add(new CountryDto(R.drawable.usa, "미국"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            //인자로 전달된 인덱스에 해당하는 CountryDto 객체를 Bundle 객체에 담고
            Bundle args = new Bundle();
            args.putSerializable("dto", countries.get(sectionNumber));
            //생성한 Fragment 객체의 인자로 전달한다.
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //fragment_main.xml 에 정의된 View 객체의 참조값 얻어오기
            ImageView imageView=(ImageView)rootView.findViewById(R.id.imageView);
            TextView textView=(TextView)rootView.findViewById(R.id.textView);
            //인자로 전달된 Bundle 객체
            Bundle args=getArguments();
            //Bundle 객체에 "dto" 라는 키값으로 전달된 객체를 얻어온다.
            CountryDto dto=(CountryDto)args.get("dto");
            //dto 객체에 담긴 내용을 View 에 반영
            imageView.setImageResource(dto.getImgResId());
            textView.setText(dto.getName());
            //View 객체 리턴해주기
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }
        //총 나라의 갯수 리턴 하기
        @Override
        public int getCount() {
            // Show 3 total pages.
            return countries.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //position 에 해당하는 국가의 이름 리턴
            //이 예제에서는 필요 없음
            return countries.get(position).getName();
        }
    }
}
