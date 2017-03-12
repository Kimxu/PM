package kimxu.me.PM;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kimxu.me.PM.frag.GMFragment;
import kimxu.me.PM.frag.OnFragmentInteractionListener;
import kimxu.me.PM.frag.TabFragment;
import kimxu.me.PM.utils.Tools;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class MainActivity extends BaseActivity implements OnFragmentInteractionListener{
    private VerticalTabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<MenuBean> menus = new ArrayList<>();
        Collections.addAll(menus
                , new MenuBean(R.drawable.man_01_pressed, R.drawable.man_01_none, "登陆花")
                , new MenuBean(R.drawable.man_02_pressed, R.drawable.man_02_none, "货品管理")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "往来管理")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "我的商圈")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "采购入库")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "采购订货")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "店铺调入")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "店铺调出")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "销售订货")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "销售开单")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "盘点管理")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "统计分析")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "统计图表")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "系统设置")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "用户帮助")
                , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "退出系统")
                , new MenuBean(R.drawable.man_04_pressed, R.drawable.man_04_none, "我的商圈"));

        setContentView(R.layout.activity_main);
        tabLayout = (VerticalTabLayout) findViewById(R.id.tabLayout);
        List<Fragment> fragments = getFragments();
        tabLayout.setupWithFragment(getSupportFragmentManager(), R.id.fragmentContainer, fragments
                , new TabAdapter() {
                    @Override
                    public int getCount() {
                        return menus.size();
                    }

                    @Override
                    public QTabView.TabBadge getBadge(int position) {
                        return null;
                    }

                    @Override
                    public QTabView.TabIcon getIcon(int position) {
                        MenuBean menu = menus.get(position);
                        return new TabView.TabIcon.Builder()
                                .setIcon(menu.mSelectIcon, menu.mNormalIcon)
                                .setIconGravity(Gravity.START)
                                .setIconMargin(Tools.dp2px(mActivity, 5))
                                .setIconSize(Tools.dp2px(mActivity, 15), Tools.dp2px(mActivity, 15))
                                .build();
                    }

                    @Override
                    public QTabView.TabTitle getTitle(int position) {
                        return new QTabView.TabTitle.Builder()
                                .setContent(menus.get(position).mTitle)
                                .setTextSize(12)
                                .setTextColor(0xFF000000,0xFF000000)
                                .build();
                    }

                    @Override
                    public int getBackground(int position) {
                        return 0;
                    }
                });
        tabLayout.setTabSelected(2);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GMFragment fragment = GMFragment.newInstance("","");
            Bundle bundle = new Bundle();
            bundle.putString("index", String.valueOf(i));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        return fragments;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}
