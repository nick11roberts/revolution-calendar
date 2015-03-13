package io.nick11roberts.github.revolutioncalendar;

import android.app.ActionBar;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.software.shell.fab.ActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RevolutionCalendar extends ActionBarActivity {

    private Toolbar toolbar;
    private TextView displayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revolution_calendar);

        ActionButton actionButton = (ActionButton) findViewById(R.id.action_button);
        actionButton.playShowAnimation();

        Calendar calendar = Calendar.getInstance();

        Typeface fontToolbar = Typeface.createFromAsset(getAssets(),"fonts/LeagueScript.otf");
        SpannableString s = new SpannableString(getResources().getString(R.string.app_name));
        s.setSpan(new CustomTypefaceSpan("LeagueScript.otf", fontToolbar), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        Typeface fontTextView = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Thin.ttf");
        SpannableString sDisplayDate = new SpannableString(String.format("%1$tb  %1$td  %1$tY", calendar));
        sDisplayDate.setSpan(new CustomTypefaceSpan("Roboto-Thin.ttf", fontTextView ), 0, sDisplayDate.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        displayDate = new TextView(this);
        displayDate.setTextColor(getResources().getColor(R.color.icons));
        displayDate.setTextSize(1, 36);
        displayDate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.weight = 1.0f;
        params.gravity=17;
        displayDate.setText(sDisplayDate);
        displayDate.setLayoutParams(params);

        toolbar = (Toolbar) findViewById(R.id.revolutionary_toolbar);
        toolbar.setMinimumHeight((int)(height/2.61803398875));
        toolbar.addView(displayDate);
        toolbar.setTitle(s);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_revolution_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }
}
