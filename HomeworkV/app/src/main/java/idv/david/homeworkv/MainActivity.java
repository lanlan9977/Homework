package idv.david.homeworkv;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvTeam;
    private List<Team> teamList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTeams();
        findViews();
    }

    private void initTeams() {
        // teamList儲存ListView各列對應的資料
        teamList = new ArrayList<>();
        teamList.add(new Team(1, R.drawable.p1, getString(R.string.team1)));
        teamList.add(new Team(2, R.drawable.p2, getString(R.string.team2)));
        teamList.add(new Team(3, R.drawable.p3, getString(R.string.team3)));
        teamList.add(new Team(4, R.drawable.p4, getString(R.string.team4)));
        teamList.add(new Team(5, R.drawable.p5, getString(R.string.team5)));
        teamList.add(new Team(6, R.drawable.p6, getString(R.string.team6)));
        teamList.add(new Team(7, R.drawable.p7, getString(R.string.team7)));
        teamList.add(new Team(8, R.drawable.p8, getString(R.string.team8)));
        teamList.add(new Team(9, R.drawable.p9, getString(R.string.team9)));
        teamList.add(new Team(10, R.drawable.p10, getString(R.string.team10)));
    }

    public void findViews() {
        lvTeam = findViewById(R.id.lvTeam);
        // 呼叫setAdapter()方法設定掌控ListView內容物的Adapter
        lvTeam.setAdapter(new TeamAdapter(this, teamList));

        // 使用者點選ListView上的任一列時會呼叫onItemClick()方法並傳遞view參數，
        // view參數代表被點選的View元件，也就是TeamAdapter.getView()的convertView參數，
        // 在此為list_item.xml內的LinearLayout元件
        lvTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team team = (Team) parent.getItemAtPosition(position);
                String info = team.getId() + " " + team.getName();
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class TeamAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;//加載布局
        private List<Team> teamList;

        public TeamAdapter(Context context, List<Team> teamList) {
            this.teamList = teamList;
            // 呼叫getSystemService()方法取得LayoutInflater物件，
            // 可以透過該物件取得指定layout檔案內容後初始化成View物件
            layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            // 一樣做法
//            layoutInflater = LayoutInflater.from(context);

        }

        @Override
        // ListView總列數
        public int getCount() {
            return teamList.size();
        }


        @Override
        // 回傳該列物件
        public Object getItem(int position) {
            return teamList.get(position);
        }

        @Override
        // 較無實際應用
        public long getItemId(int position) {
            return teamList.get(position).getId();
        }

        @Override
        // 依照position回傳該列資料所需呈現的UI畫面(View)
        public View getView(int position, View convertView, ViewGroup parent) {
            // 一個convertView就是ListView一列資料的畫面，
            // 因為每一列資料外觀都一樣，只有資料值不同，所以載入相同layout檔案，
            // 第一次還未載入layout，所以必須呼叫layoutInflater.inflate()載入layout檔案並指派給convertView
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(R.layout.listview_team, parent, false);
                holder.ivLogo = convertView.findViewById(R.id.ivLogo);
                holder.tvId = convertView.findViewById(R.id.tvId);
                holder.tvName = convertView.findViewById(R.id.tvName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            // 依照position取得teamList內的team物件
            final Team team = teamList.get(position);
            holder.ivLogo.setImageResource(team.getLogo());
            holder.tvId.setText(String.valueOf(team.getId()));
            holder.tvName.setText(team.getName());
            holder.tvId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String info=String.valueOf(team.getId());
                    Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();
                }
            });
            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String info=String.valueOf(team.getName());
                    Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        private class ViewHolder {
            ImageView ivLogo;
            TextView tvName, tvId;


        }
    }
}