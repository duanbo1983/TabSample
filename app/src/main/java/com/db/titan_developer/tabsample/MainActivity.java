package com.db.titan_developer.tabsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tabsample);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        final TabWidget tabWidget = tabHost.getTabWidget();
        final FrameLayout tabContent = tabHost.getTabContentView();

        // Get the original tab textviews and remove them from the viewgroup.
        TextView[] originalTextViews = new TextView[tabWidget.getTabCount()];
        for (int index = 0; index < tabWidget.getTabCount(); index++) {
            originalTextViews[index] = (TextView) tabWidget.getChildTabViewAt(index);
        }
        tabWidget.removeAllViews();

        // Ensure that all tab content childs are not visible at startup.
        for (int index = 0; index < tabContent.getChildCount(); index++) {
            tabContent.getChildAt(index).setVisibility(View.GONE);
        }

        // Create the tabspec based on the textview childs in the xml file.
        // Or create simple tabspec instances in any other way...
        for (int index = 0; index < originalTextViews.length; index++) {
            final TextView tabWidgetTextView = originalTextViews[index];
            final View tabContentView = tabContent.getChildAt(index);
            TabHost.TabSpec tabSpec = tabHost.newTabSpec((String) tabWidgetTextView.getTag());
            tabSpec.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String tag) {
                    return tabContentView;
                }
            });
            if (tabWidgetTextView.getBackground() == null) {
                tabSpec.setIndicator(tabWidgetTextView.getText());
            } else {
                tabSpec.setIndicator(tabWidgetTextView.getText(), tabWidgetTextView.getBackground());
            }
            tabHost.addTab(tabSpec);
        }

		tabHost.setCurrentTab(0);
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
}
