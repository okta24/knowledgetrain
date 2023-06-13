package com.shahruie.www.Knowledge_Train;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class English2 extends Activity implements OnNavigationListener {
    private static final String KEY_SELECTED_PAGE = "KEY_SELECTED_PAGE";
    private static final String KEY_SELECTED_CLASS = "KEY_SELECTED_CLASS";
   // private static final ArrayList<TransformerItem> TRANSFORM_CLASSES;
   private static int[] word_voice;
    private static String[] word_name;
    private static int[] word_images;
     public static int frag_position=0;
    public static Context baseContext;
    private final static String TAG = "Knowledge_Train";
    static List<String> names;
    private static final String ORIGINAL_MP3_FILE = "original.mp3";
    private static final String PROCESSED_RAW_FILE = "processed.raw";
    ImageView play_btn , next ,prev;
    private int mSelectedItem;
    private static  ViewPager mPager;
    private PageAdapter mAdapter;

    private static MediaPlayer mediaPlayer;
    private static boolean isplaying=false;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseContext = getBaseContext();
        setContentView(R.layout.activity_main3);
        int selectedPage = 0;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(KEY_SELECTED_CLASS);
            selectedPage = savedInstanceState.getInt(KEY_SELECTED_PAGE);
        }
        Question_library question_library=new Question_library();
        word_images =question_library.get_words_img();
        word_name =question_library.get_ewords();
        word_voice =question_library.get_sounds_of_words();
         next = (ImageView) findViewById(R.id.next_img);
        prev = (ImageView) findViewById(R.id.prev_img);
        next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mPager.setCurrentItem(mPager.getCurrentItem()+1);
             }
         });
         prev.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mPager.setCurrentItem(mPager.getCurrentItem()-1);
             }
         });
         play_btn = (ImageView) findViewById(R.id.fab);
        Resources res = getResources();
        Drawable drawable = res.getDrawable( R.drawable.play_img );
        play_btn.setImageDrawable(drawable);
        play_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if ((mPager.getCurrentItem() > 5) && (!loadData())) {
                    play_btn.setVisibility(View.GONE);
                    Intent serviceIntent = new Intent("ir.cafebazaar.pardakht.InAppBillingService.BIND");
                    serviceIntent.setPackage("com.farsitel.bazaar");
                    List<ResolveInfo> intentServices =  baseContext.getPackageManager().queryIntentServices(serviceIntent, 0);
                    if (serviceIntent != null)
                        if (intentServices != null && intentServices.isEmpty() == false) {
                             Intent newActivity = new Intent(baseContext, Pardakht.class);
                             startActivity(newActivity);
                        } else
                            Toast.makeText(baseContext, "برای خریداری نسخه اصلی بایستی برنامه بازار بر روی گوشی شما نصب باشد.", Toast.LENGTH_LONG).show();
                } else {
                        play();
                }}
        });
        final ArrayAdapter<TransformerItem> actionBarAdapter = new ArrayAdapter<TransformerItem>(
                getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1);
        mAdapter = new PageAdapter(getFragmentManager());
        mPager = (ViewPager) findViewById(R.id.container);
        mPager.setOffscreenPageLimit(13);
        mPager.setAdapter(mAdapter);
       // mPager.setPageTransformer(true, new BackgroundToForegroundTransformer());
        mPager.setCurrentItem(selectedPage);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
                if(mediaPlayer != null)
                {
                    stopPlaying();
                }
            }
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                // Check if this is the page you want.
            }
        });

        final ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setListNavigationCallbacks(actionBarAdapter, this);
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

            //noinspection ResourceType
            actionBar.setDisplayOptions(actionBar.getDisplayOptions() ^ ActionBar.DISPLAY_SHOW_TITLE);

            actionBar.setSelectedNavigationItem(mSelectedItem);
        }

    }

    @Override
    public boolean onNavigationItemSelected(int position, long itemId) {
        mSelectedItem = position;
        try {
            //mPager.setPageTransformer(true, new CubeOutTransformer());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_SELECTED_CLASS, mSelectedItem);
        outState.putInt(KEY_SELECTED_PAGE, mPager.getCurrentItem());
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String EXTRA_POSITION = "EXTRA_POSITION";
       /* private static final int[] COLORS = new int[] { 0xFF33B5E5, 0xFFAA66CC, 0xFF99CC00, 0xFFFFBB33, 0xFFFF4444,
                0xFF33B5E5, 0xFFAA66CC, 0xFF99CC00, 0xFFFFBB33, 0xFFFF4444,0xFF33B5E5, 0xFFAA66CC, 0xFF99CC00};*/
       /* private static final int[] imgs = new int[] { R.drawable.ic_info, R.drawable.ic_play};*/

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view;

                final int position = getArguments().getInt(EXTRA_POSITION);
                view = inflater.inflate(R.layout.fragment_main, container, false);
                final ImageView imageViewPosition = (ImageView) view.findViewById(R.id.frag_img);
                final TextView frag_title = (TextView) view.findViewById(R.id.frag_title);
                frag_position = position - 1;
                Log.d("frag", frag_position + "");
                Log.d("pager", mPager.getCurrentItem() + "");
                frag_title.setText(word_name[frag_position]);
                imageViewPosition.setImageResource(word_images[frag_position]);
                //frag_title.setBackgroundColor(COLORS[frag_position]);
                return view;
            }


    }

    private final class PageAdapter extends FragmentStatePagerAdapter {

        public PageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            final Bundle bundle = new Bundle();
            bundle.putInt(PlaceholderFragment.EXTRA_POSITION, position + 1);
            frag_position=position;
            Log.d("fragpage",frag_position+"");
            Log.d("pager",mPager.getCurrentItem()+"");
            final PlaceholderFragment fragment = new PlaceholderFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 13;
        }

    }

    private static final class TransformerItem {

        final String title;
        final Class<? extends PageTransformer> clazz;

        public TransformerItem(Class<? extends PageTransformer> clazz) {
            this.clazz = clazz;
            title = clazz.getSimpleName();
        }

        @Override
        public String toString() {
            return title;
        }

    }
    /**
     */
    private static Boolean loadData() {
        SharedPreferences pref;
        pref =baseContext.getSharedPreferences("MyPref3",MODE_PRIVATE);
        Boolean mIsPremium =  pref.getBoolean("mIsPremium", false);
        return mIsPremium;
    }
private  void play(){
    if (!isplaying) {
        mediaPlayer = MediaPlayer.create(baseContext, word_voice[mPager.getCurrentItem()]);
        mediaPlayer.start();
        Resources res = baseContext.getResources();
        Drawable drawable = res.getDrawable( R.drawable.stop_img );
        play_btn.setImageDrawable(drawable);
        isplaying=true;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                isplaying=false;
                Resources res = baseContext.getResources();
                Drawable drawable = res.getDrawable(R.drawable.play_img);
                play_btn.setImageDrawable(drawable);
            }
        });
    }
    else {
        stopPlaying();
    }
    }
    private  void stopPlaying() {
        if (isplaying) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            Resources res = baseContext.getResources();
            Drawable drawable = res.getDrawable(R.drawable.play_img);
            play_btn.setImageDrawable(drawable);
            isplaying = false;
        }
        }
    @Override
    protected void onDestroy()
    {
        if(mediaPlayer != null)
        {
           mediaPlayer.stop();
        }
        super.onDestroy();
    }

}
