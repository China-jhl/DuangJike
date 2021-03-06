package info.free.duangjike

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.widget.ImageButton
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    @BindView(R.id.tab_layout)
    lateinit var tabLayout: TabLayout
    @BindView(R.id.view_pager)
    lateinit var viewPager: ViewPager
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.save_btn)
    lateinit var saveBtn: ImageButton

    private var adapter: AnimationAdapter? = null
    private var fragments: MutableList<PageFragment> = emptyList<PageFragment>().toMutableList()

    init {
        fragments.add(PageFragment.newInstance(/*R.string.anim_fall,*/ R.layout.fragment_fall_down))
        fragments.add(PageFragment.newInstance(/*R.string.anim_fall,*/ R.layout.fragment_flip_dot))
        fragments.add(PageFragment.newInstance(/*R.string.anim_fall,*/ R.layout.fragment_flipboard_like))
        fragments.add(PageFragment.newInstance(/*R.string.anim_fall,*/ R.layout.fragment_like_around))
        fragments.add(PageFragment.newInstance(/*R.string.anim_fall,*/ R.layout.fragment_ruler))
    }

    @OnClick(R.id.play_btn)
    fun playAnimation() {
        adapter?.curFragment?.startAnimation()
    }

    @OnClick(R.id.save_btn)
    fun saveGif() {
        adapter?.curFragment?.saveGif()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        toolbar.setTitle(R.string.anim_fall)
        setSupportActionBar(toolbar)

        adapter = AnimationAdapter(supportFragmentManager, fragments)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
