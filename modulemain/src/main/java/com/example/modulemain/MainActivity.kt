package com.example.modulemain

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.*
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ScreenUtils
import com.example.modulelibs.base.BaseActivity
import com.example.modulelibs.util.Contance
import com.example.modulemain.databinding.ActivityModuleMainBinding


@Route(path = Contance.ACTIVITY_MAIN)
class MainActivity : BaseActivity() {

    private lateinit var binding:ActivityModuleMainBinding
    private lateinit var mainRecycleAdapter:MainRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_module_main)
        //var recyclerView = findViewById<RecyclerView>(R.id.recycler_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_module_main)

        initRecycler()

    }

    fun initRecycler(){
        var beanList = ArrayList<MyBean>()
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 2))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 2))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 2))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 2))
        beanList.add(MyBean(type = 1))
        beanList.add(MyBean(type = 2))
        beanList.add(MyBean(type = 1))

        mainRecycleAdapter = MainRecycleAdapter(this)
        //设置布局形式
        setRecyclerLayoutManager()
        //自定义分割线
        setRecyclerItemDecoration()

        binding.recyclerMain.adapter = mainRecycleAdapter
        //mainRecycleAdapter.notifyDataSetChanged()
        mainRecycleAdapter.submitList(beanList)

        binding.tvRecyclerview.setOnClickListener{
//            beanList.add(MyBean())
//            mainRecycleAdapter.notifyDataSetChanged()
            var beanList2:ArrayList<MyBean> = ArrayList()
            beanList2.addAll(mainRecycleAdapter.currentList)
            beanList2.removeAt(1)
            mainRecycleAdapter.submitList(beanList2)
        }
    }

    fun setRecyclerLayoutManager(){
        //线性布局
        binding.recyclerMain.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //网格布局
        //binding.recyclerMain.layoutManager = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        //瀑布流
        //binding.recyclerMain.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        //流式布局
        //binding.recyclerMain.layoutManager = FlexboxLayoutManager(this)
    }

    fun setRecyclerItemDecoration(){
        //自定义分割线
//        binding.recyclerMain.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL).apply {
//            setDrawable(resources.getDrawable(R.drawable.ic_launcher_background,null))
//        })
        //自定义分割线
        binding.recyclerMain.addItemDecoration(object: RecyclerView.ItemDecoration(){
            //列表背景层
            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDraw(c, parent, state)
                val paint = Paint()
                paint.color = Color.BLUE
                c.drawRect(0f, 0f, ScreenUtils.getScreenWidth().toFloat(), ScreenUtils.getScreenHeight().toFloat(), paint)
            }
            //列表上层
            override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDrawOver(c, parent, state)
                val paint = Paint()
                paint.color = Color.RED
                c.drawRect(0f, 100f, 3000f, 200f, paint)
            }
            //item边距
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                //设置item对于group的边距
                outRect.set(10,10,10,10)
            }
        })
    }

}
