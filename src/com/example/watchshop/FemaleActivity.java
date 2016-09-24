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

public class FemaleActivity extends Activity {
	DrawerLayout nDrawerLayout;
	ListView nDrawerList;
	ActionBarDrawerToggle nDrawerToggle;
	String nTitle="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);
        start();
        nTitle=(String)getTitle();
        nDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_Layout1);
        nDrawerList=(ListView)findViewById(R.id.drawer_list1);
        nDrawerToggle=new ActionBarDrawerToggle(this,nDrawerLayout,R.drawable.icon,R.string.drawer_open,R.string.drawer_close){
        	@Override
        	public void onDrawerClosed(View drawerView) {
        		getActionBar().setTitle(nTitle);
        		invalidateOptionsMenu();
        	}
        	
        	@Override
        	public void onDrawerOpened(View drawerView) {
        		getActionBar().setTitle("SORT BY");
        		invalidateOptionsMenu();
        	}
        };
        nDrawerLayout.setDrawerListener(nDrawerToggle);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(getBaseContext(),R.layout.drawer_list_item,getResources().getStringArray(R.array.SORT_BY));
        nDrawerList.setAdapter(adapter1);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        nDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String[] sortby=getResources().getStringArray(R.array.SORT_BY);
				nTitle=sortby[position];
				SortByFragment ssFragment=new SortByFragment();
				Bundle data1=new Bundle();
				data1.putInt("position",position);
				ssFragment.setArguments(data1);
				android.app.FragmentManager fragmentManager1=getFragmentManager();
				FragmentTransaction ft1=fragmentManager1.beginTransaction();
				ft1.replace(R.id.content_frame1,ssFragment);
				ft1.commit();
				nDrawerLayout.closeDrawer(nDrawerList);
				
				
			}
        	
        });
        }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
    	
    	super.onPostCreate(savedInstanceState);
    	nDrawerToggle.syncState();
    
    }
    public void start()
    {
    
    	int imgs[]={
              R.drawable.f1,
             R.drawable.f2, 
             R.drawable.f3,
             R.drawable.f4,
             R.drawable.f5,
             R.drawable.f6,
             R.drawable.f7,
             R.drawable.f8,
             R.drawable.f9,
             R.drawable.f10 };
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
						Intent i=new Intent(FemaleActivity.this,ImagePreviewActivity.class);
						i.putExtras(b);
						i.putExtra("bitmap",(w.getPictures()).getBitmap());
						//i.putExtra("Cart", (w.getCartButton()));
						//i.putExtra("Cart", (w.getCartButton()));
						
						//i.putExtra(name, value)
						FemaleActivity.this.startActivity(i);
					}
				}
		
    );*/

    }
    public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.female, menu);
		return true;
	}

    @Override
   public boolean onOptionsItemSelected(MenuItem item) {
   	if(nDrawerToggle.onOptionsItemSelected(item))
   	{
   		return true;
   	}
   	return super.onOptionsItemSelected(item);
   }
   @Override
   public boolean onPrepareOptionsMenu(Menu menu) {
   	boolean drawerOpen=nDrawerLayout.isDrawerOpen(nDrawerList);
   	menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
   	return super.onPrepareOptionsMenu(menu);
   }
   
    }
    

