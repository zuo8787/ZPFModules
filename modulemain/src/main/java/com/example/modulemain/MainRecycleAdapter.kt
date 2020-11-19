package com.example.modulemain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @ProjectName: ZPFModules
 * @Package: com.example.modulemain
 * @ClassName: MainRecycleAdapter
 * @Description: java类作用描述
 * @Author: 左鹏飞
 * @CreateDate: 20-11-16 下午4:39
 * @UpdateUser: 左鹏飞
 * @UpdateDate: 20-11-16 下午4:39
 * @UpdateRemark: 更新说明
 */
class MainRecycleAdapter(
//    private var beanList:ArrayList<MyBean>,
    private var context: Context
) : ListAdapter<MyBean,RecyclerView.ViewHolder>(MyDiffUtilsCallback()) {

    private val LAYOUT1 = 1
    private val LAYOUT2 = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            LAYOUT1 ->{
                MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_main_item,parent,false))
            }
            LAYOUT2 ->{
                MyViewHolder2(LayoutInflater.from(parent.context).inflate(R.layout.recycle_main_item2,parent,false))
            }
            else->{
                MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_main_item,parent,false))
            }
        }
    }

//    override fun getItemCount(): Int {
//        return beanList.size
//    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyViewHolder -> {
                holder.tvItem.setOnClickListener{
                    Toast.makeText(context,holder.tvItem.text,Toast.LENGTH_LONG).show()
                }
                holder.btnItem.setOnClickListener{
                    Toast.makeText(context,holder.btnItem.text,Toast.LENGTH_LONG).show()
                }
            }
            is MyViewHolder2 -> {
                holder.tvItem.setOnClickListener{
                    Toast.makeText(context,holder.tvItem.text,Toast.LENGTH_LONG).show()
                }
                holder.btnItem.setOnClickListener{
                    Toast.makeText(context,holder.btnItem.text,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position).type){
            1 ->{
                LAYOUT1
            }
            2 ->{
                LAYOUT2
            }
            else ->{
                LAYOUT1
            }
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItem:TextView = itemView.findViewById(R.id.tv_item)
        val btnItem:Button = itemView.findViewById(R.id.btn_item)
    }

    class MyViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItem:TextView = itemView.findViewById(R.id.tv_item)
        val btnItem:Button = itemView.findViewById(R.id.btn_item)
    }

}

class MyDiffUtilsCallback: DiffUtil.ItemCallback<MyBean>() {
    override fun areItemsTheSame(oldItem: MyBean, newItem: MyBean): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyBean, newItem: MyBean): Boolean {
        return oldItem == newItem
    }

}