package com.example.watchshop;




import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class KidsActivity extends Activity {
	DrawerLayout oDrawerLayout;
	ListView oDrawerList;
	ActionBarDrawerToggle oDrawerToggle;
	String oTitle="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        start();
        oTitle=(String)getTitle();
        oDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_Layout2);
        oDrawerList=(ListView)findViewById(R.id.drawer_list2);
        oDrawerToggle=new ActionBarDrawerToggle(this,oDrawerLayout,R.drawable.icon,R.string.drawer_open,R.string.drawer_close){
        	@Override
        	public void onDrawerClosed(View drawerView) {
        		getActionBar().setTitle(oTitle);
        		invalidateOptionsMenu();
        	}
        	
        	@Override
        	public void onDrawerOpened(View drawerView) {
        		getActionBar().setTitle("SORT BY");
        		invalidateOptionsMenu();
        	}
        };
        
        
        oDrawerLayout.setDrawerListener(oDrawerToggle);
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(getBaseContext(),R.layout.drawer_list_item,getResources().getStringArray(R.array.SORT_BY));
        oDrawerList.setAdapter(adapter2);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        oDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String[] sortby1=getResources().getStringArray(R.array.SORT_BY1);
				oTitle=sortby1[position];
				SortBy1Fragment skFragment=new SortBy1Fragment();
				Bundle data2=new Bundle();
				data2.putInt("position",position);
				skFragment.setArguments(data2);
				android.app.FragmentManager fragmentManager2=getFragmentManager();
				FragmentTransaction ft2=fragmentManager2.beginTransaction();
				ft2.replace(R.id.content_frame2,skFragment);
				ft2.commit();
				oDrawerLayout.closeDrawer(oDrawerList);
				
				
			}
        	
        });
        }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
    	
    	super.onPostCreate(savedInstanceState);
    	oDrawerToggle.syncState();
    }
    
    public void start()
    {
    
    	int imgs[]={
     R.drawable.k4,
    	R.drawable.k6,
    	R.drawable.k9,
    	R.drawable.k10,
        R.drawable.k1,
    	R.drawable.k2,
        R.drawable.k3,
    	R.drawable.k5,
    	R.drawable.k7,
    	R.drawable.k8 };
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
						Intent i=new Intent(KidsActivity.this,ImagePreviewActivity.class);
						i.putExtras(b);
						i.putExtra("bitmap",(w.getPictures()).getBitmap());
						//i.putExtra("Cart", (w.getCartButton()));
						//i.putExtra("Cart", (w.getCartButton()));
						
						//i.putExtra(name, value)
				KidsActivity.this.startActivity(i);
					}
				}
		
    );*/

    }
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.kids, menu);
		return true;
	}


    @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 	if(oDrawerToggle.onOptionsItemSelected(item))
 	{
 		return true;
 	}
 	return super.onOptionsItemSelected(item);
 }
 @Override
 public boolean onPrepareOptionsMenu(Menu menu) {
 	boolean drawerOpen=oDrawerLayout.isDrawerOpen(oDrawerList);
 	menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
 	return super.onPrepareOptionsMenu(menu);
 }
 

    
}
