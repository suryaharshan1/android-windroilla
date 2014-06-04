package com.nandini.littleturn;
	 
	import android.os.Bundle;
	import android.app.Activity;
	 
	import android.view.MenuItem;
	import android.widget.TextView;
	import android.support.v4.app.NavUtils;
	import android.annotation.TargetApi;
	import android.content.Intent;
	import android.os.Build;
	 
	public class DisplayMessageActivity extends Activity {
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	         
	        // Get the message from the intent
	        Intent intent = getIntent();
	         
	        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
	 
	        // Create the text view
	        TextView textView = new TextView(this);
	        textView.setTextSize(40);
	         
	         
	        // Set the String in the text box
	        textView.setText(message);
	         
	        // Set the activity with this new text
	        setContentView(textView);
	        // Show the Up button in the action bar.
	        setupActionBar();
	    }
 
	    /**
  * Set up the {@link android.app.ActionBar}, if the API is available.
	     */
	    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	    private void setupActionBar() {
	        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	            getActionBar().setDisplayHomeAsUpEnabled(true);
	        }
	    }
	 
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case android.R.id.home:

	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	 
	}
