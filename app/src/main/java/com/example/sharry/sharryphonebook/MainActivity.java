package com.example.sharry.sharryphonebook;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {

    private String[] listview_names =  {
            "Ammar Mazhar",
            "Ayesha Ali",
            "Alfreda Aschenbrenner",
            "Alice Asaro",
            "Annetta Abasta",
            "Ashanti Aoki",
            "Ashly Amico",
            "Brad Boulton",
            "Candi Cuesta",
            "Catrina Cruzado",
            "Christeen Coll",
            "Christie Corby",
            "Cortney Cho",
            "Despina Donahoe",
            "Echo Eich",
            "Eleonora Efaw",
            "Estrella Eshleman",
            "Eugena Esker",
            "Garth Gingerich",
            "Hugh Holzman",
            "Ian Israel",
            "Jarrett Juneau",
            "Jenniffer Jimerson",
            "Joann Joynt",
            "Johnny Junior",
            "Ka Kittinger",
            "Leesa Losee",
            "Leida Leake",
            "Louella Lovitt",
            "Lourdes Lasker",
            "Marilyn Modzelewski",
            "Marni Mccook",
            "Maryjane Melchior",
            "Micaela Mata",
            "Nathanael Nielsen",
            "Nery Nesbit",
            "Nicolette Nace",
            "Noemi Newton",
            "Olene Ottesen",
            "Patrice Palacio",
            "Shelby Seago",
            "Shizue Stengel",
            "Stan Saad",
            "Star Sitzes",
            "Stepanie Shearer",
            "Tamie Tippit",
            "Tammara Trumbo",
            "Teodoro Turnipseed",
            "Towanda Trostle",
            "Valeria Vangilder",
            "Venetta Vitello",
            "Willia Wimmer",};
    private String[] listview_Phones =  {"03007346525","03216853836","03017645856","03458734762","03557346525","03005676525"
    ,"03007346123","03224346525","03034546525","03012346525","03005676525","03008765525","03007654525","03007346525",
    "03007346525","03007346525","030073478925","03007346785","03007346500","03007346501","03007346225","03007346555",
    "03008756874","03005674575","0300734876","03007340000","03000046525","03000456734","032256784566","03057656786","033216853836",
    "03007345675","030098765432","03007376575","03001122335","03000006525","03007340000","03007987625","0300734876785",
    "03007345265","03007347654","03007346525","03215067854","03056699765","03004567845","03015678456","03456545673","03000006525",
    "03007346665","03007656873","03008737654","03007347655"};
    private static int[] listview_images = {R.drawable.shape,R.drawable.shape1,R.drawable.shape2,R.drawable.shape3,R.drawable.shape4,R.drawable.shape5,R.drawable.shape6,R.drawable.shape7,R.drawable.shape8,R.drawable.shape9,R.drawable.shape10,R.drawable.shape11,R.drawable.shape12,R.drawable.shape13,R.drawable.shape14,R.drawable.shape15,R.drawable.shape16,R.drawable.shape17,R.drawable.shape18,R.drawable.shape19,R.drawable.shape20,R.drawable.shape21,R.drawable.shape22,R.drawable.shape23,R.drawable.shape24,R.drawable.shape25,R.drawable.shape26,R.drawable.shape27};
    static Context mcontext;
    private ListView lv;
    private static ArrayList<String> array_sort;
    private static ArrayList<String> array_sort1;
    private static ArrayList<Integer> Values;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(android.R.id.list);
        array_sort=new ArrayList<String> (Arrays.asList(listview_names));
        array_sort1=new ArrayList<String>();
        Values=new ArrayList<Integer>();
        for (int index = 0; index < listview_Phones.length; index++)
        {
            array_sort1.add(listview_Phones[index]);
        }

        setListAdapter(new bsAdapter(this));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3)
            {
                Toast.makeText(getApplicationContext(), array_sort.get(position),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),OPEN.class);
                intent.putExtra("KEY_StringName",array_sort.get(position));
                intent.putExtra("KEY_StringName1",array_sort1.get(position));
                TextView t=(TextView)findViewById(R.id.imageview);
                intent.putExtra("KEY",Values.get(position).toString());
                StringBuilder sb = new StringBuilder();
                String input=array_sort.get(position).toString();
                for(String s : input.split(" ")){
                    sb.append(s.charAt(0));
                }

                intent.putExtra("KEY_StringName2",sb.toString());
                startActivity(intent);
            }
        });
    }
    public static class bsAdapter extends BaseAdapter
    {
        Activity cntx;
        public bsAdapter(Activity context)
        {
            // TODO Auto-generated constructor stub
            this.cntx=context;
        }

        public int getCount()
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }
        @Override

        public Object getItem(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.get(position);
        }

        public long getItemId(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View row=null;
            LayoutInflater inflater=cntx.getLayoutInflater();
            row=inflater.inflate(R.layout.list_item, null);
            TextView tv = (TextView) row.findViewById(R.id.title);
            tv.setText(array_sort.get(position));
            TextView tv1 = (TextView) row.findViewById(R.id.title1);
            tv1.setText(array_sort1.get(position));
            TextView img = (TextView) row.findViewById(R.id.imageview);
            //Random generator=new Random();
            //int indx=generator.nextInt(listview_images.length);
            Character c=tv.getText().charAt(0);
            if (c == 'A')
            {
                Values.add(position, 0);
                img.setBackgroundResource(listview_images[0]);
            }
            if (c == 'B')
            {
                Values.add(position, 1);
                img.setBackgroundResource(listview_images[1]);
            }
            if (c == 'C')
            {
                Values.add(position, 2);
                img.setBackgroundResource(listview_images[2]);
            }
            if (c == 'D')
            {
                Values.add(position, 3);
                img.setBackgroundResource(listview_images[3]);
            }
            if (c == 'E')
            {
                Values.add(position, 4);
                img.setBackgroundResource(listview_images[4]);
            }
            if (c == 'F')
            {
                Values.add(position, 5);
                img.setBackgroundResource(listview_images[5]);
            }
            if (c == 'G')
            {
                Values.add(position, 6);
                img.setBackgroundResource(listview_images[6]);
            }
            if (c == 'H')
            {
                Values.add(position, 7);
                img.setBackgroundResource(listview_images[7]);
            }
            if (c == 'I')
            {
                Values.add(position, 8);
                img.setBackgroundResource(listview_images[8]);
            }
            if (c == 'J')
            {
                Values.add(position, 9);
                img.setBackgroundResource(listview_images[9]);
            }
            if (c == 'K')
            {
                Values.add(position, 10);
                img.setBackgroundResource(listview_images[10]);
            }
            if (c == 'L')
            {
                Values.add(position, 11);
                img.setBackgroundResource(listview_images[11]);
            }
            if (c == 'M')
            {
                Values.add(position, 12);
                img.setBackgroundResource(listview_images[12]);
            }
            if (c == 'N')
            {
                Values.add(position, 13);
                img.setBackgroundResource(listview_images[13]);
            }
            if (c == 'O')
            {
                Values.add(position, 14);
                img.setBackgroundResource(listview_images[14]);
            }
            if (c == 'P')
            {
                Values.add(position, 15);
                img.setBackgroundResource(listview_images[15]);
            }
            if (c == 'Q')
            {
                Values.add(position, 16);
                img.setBackgroundResource(listview_images[16]);
            }
            if (c == 'R')
            {
                Values.add(position, 17);
                img.setBackgroundResource(listview_images[17]);
            }
            if (c == 'S')
            {
                Values.add(position, 18);
                img.setBackgroundResource(listview_images[18]);
            }
            if (c == 'T')
            {
                Values.add(position, 19);
                img.setBackgroundResource(listview_images[19]);
            }
            if (c == 'U')
            {
                Values.add(position, 20);
                img.setBackgroundResource(listview_images[20]);
            }
            if (c == 'V')
            {
                Values.add(position, 21);
                img.setBackgroundResource(listview_images[21]);
            }
            if (c == 'W')
            {
                Values.add(position, 22);
                img.setBackgroundResource(listview_images[22]);
            }
            if (c == 'X')
            {
                Values.add(position, 23);
                img.setBackgroundResource(listview_images[23]);
            }
            if (c == 'Y')
            {
                Values.add(position, 24);
                img.setBackgroundResource(listview_images[24]);
            }
            if (c == 'Z')
            {
                Values.add(position, 25);
                img.setBackgroundResource(listview_images[25]);
            }

            StringBuilder sb = new StringBuilder();
            String input=tv.getText().toString();
            for(String s : input.split(" ")){
                sb.append(s.charAt(0));
            }
            img.setText(sb);
            return row;
        }
    }
}
