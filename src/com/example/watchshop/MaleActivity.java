package com.example.watchshop;




import com.example.watchshop.*;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MaleActivity extends Activity {
	
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	String mTitle="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);
        start();
        
        mTitle=(String)getTitle();
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_Layout);
        mDrawerList=(ListView)findViewById(R.id.drawer_list);
        mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.icon,R.string.drawer_open,R.string.drawer_close){
        	@Override
        	public void onDrawerClosed(View drawerView) {
        		getActionBar().setTitle(mTitle);
        		invalidateOptionsMenu();
        	}
        	
        	@Override
        	public void onDrawerOpened(View drawerView) {
        		getActionBar().setTitle("SORT BY");
        		invalidateOptionsMenu();
        	}
        };
        
        
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getBaseContext(),R.layout.drawer_list_item,getResources().getStringArray(R.array.SORT_BY));
        mDrawerList.setAdapter(adapter);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String[] sortby=getResources().getStringArray(R.array.SORT_BY);
				mTitle=sortby[position];
				SortByFragment sFragment=new SortByFragment();
				Bundle data=new Bundle();
				data.putInt("position",position);
				sFragment.setArguments(data);
				android.app.FragmentManager fragmentManager=getFragmentManager();
				FragmentTransaction ft=fragmentManager.beginTransaction();
				ft.replace(R.id.content_frame,sFragment);
				ft.commit();
				mDrawerLayout.closeDrawer(mDrawerList);
				
				
			}
        	
        });
        
        
        }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
    	
    	super.onPostCreate(savedInstanceState);
    	mDrawerToggle.syncState();
    }
    public void start()
    {
    	int imgs[]=
    		{ R.drawable.w4, R.drawable.w6, R.drawable.w9, 
    	R.drawable.w10,
    	R.drawable.w11,
    	R.drawable.w16,
    	R.drawable.w19,
    	R.drawable.w21,
    	R.drawable.w24,
    	R.drawable.w18
    	};
    	String[]x={"1","2","3","4","5","6","7","8","9","10"};
    	WatchshopAdapter aa=new WatchshopAdapter(this,imgs,x);
	     ListView list=(ListView)findViewById(R.id.listView1);
		list.setAdapter(aa);
		/*list.setOnItemClickListener
		(
				new OnItemClickListener()
				{
					public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,long arg3)
					{
						Watch w = (Watch)list.getItemAtPosition(arg2);
						Bundle b=new Bundle();
						
						//b.putInt("rid",s.getPictures());
						Intent i=new Intent(MaleActivity.this,ImagePreviewActivity.class);
						i.putExtras(b);
						i.putExtra("bitmap",(w.getPictures()).getBitmap());
						//i.putExtra("Cart", (w.getCartButton()));
						//i.putExtra("Cart", (w.getCartButton()));
						
						//i.putExtra(name, value)
						MaleActivity.this.startActivity(i);
					}
				}
		
    );*/
}

    public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.male, menu);
		return true;
	}

       @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(mDrawerToggle.onOptionsItemSelected(item))
    	{
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	boolean drawerOpen=mDrawerLayout.isDrawerOpen(mDrawerList);
    	menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
    	return super.onPrepareOptionsMenu(menu);
    }
    
}
