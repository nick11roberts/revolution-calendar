package io.nick11roberts.github.revolutioncalendar;

import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.software.shell.fab.ActionButton;

import java.util.Calendar;


public class RevolutionCalendar extends ActionBarActivity {

    private Toolbar toolbar;
    private TextView displayDate;
    private TextView displayTitle;

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




        toolbar = (Toolbar) findViewById(R.id.revolutionary_toolbar);

        displayTitle = (TextView) findViewById(R.id.title_text_view);
        displayTitle.setTextColor(getResources().getColor(R.color.icons));
        displayTitle.setTextSize(1, 24);
        displayTitle.setText(s);

        displayDate = (TextView) findViewById(R.id.date_text_view);
        displayDate.setTextColor(getResources().getColor(R.color.icons));
        displayDate.setTextSize(1, 36);
        displayDate.setText(sDisplayDate);

        toolbar.setMinimumHeight((int)(height/2.61803398875));

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
