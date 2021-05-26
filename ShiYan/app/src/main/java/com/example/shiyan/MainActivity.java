package com.example.shiyan;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shiyan.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview=(ListView)findViewById(R.id.listview);
        this.registerForContextMenu(listview);
        String[] string=new String[]{"张三","李四","王五","齐六","吕八","周九"};
        listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,string));
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuinfo)
    {
        menu.setHeaderTitle("号码操作");
        //添加菜单项
        menu.add(0,1,0,"删除");
        menu.add(0,2,0,"修改");
        menu.add(0,3,0,"保存");

    }
    //菜单单击响应
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        //获得当前被选择的菜单项的信息
        switch (item.getItemId())
        {
            case 1:
                DisplayToast("删除成功");
                break;
            case 2:
                DisplayToast("修改成功");
                break;
            case 3:
                DisplayToast("保存成功");
                break;
        }
        return  true;
    }
    public void DisplayToast(String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}