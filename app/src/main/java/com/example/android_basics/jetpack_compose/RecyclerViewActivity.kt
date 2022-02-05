package com.example.android_basics.jetpack_compose

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_basics.R
import com.example.android_basics.jetpack_compose.dataset.SampleData

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvList)
        val adapter = RvListAdapter(SampleData.conversationSample)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

}

class RvListAdapter(val messages: List<Message>) : RecyclerView.Adapter<RvListAdapter.RvHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val current = System.currentTimeMillis()
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        val result = RvHolder(view)
        Log.d("TAG", "Time Take by OnCreateViewHolder: ${System.currentTimeMillis() - current}")
        return result
    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        val current = System.currentTimeMillis()

        holder.title?.text = messages[position].name
        holder.subtitle?.text = messages[position].desc

        holder.title1?.text = messages[position].name
        holder.subtitle1?.text = messages[position].desc

        holder.title2?.text = messages[position].name
        holder.subtitle2?.text = messages[position].desc

        holder.title3?.text = messages[position].name
        holder.subtitle3?.text = messages[position].desc

        holder.title4?.text = messages[position].name
        holder.subtitle4?.text = messages[position].desc

        holder.title5?.text = messages[position].name
        holder.subtitle5?.text = messages[position].desc

        holder.title6?.text = messages[position].name
        holder.subtitle6?.text = messages[position].desc

        holder.title7?.text = messages[position].name
        holder.subtitle7?.text = messages[position].desc

        holder.title8?.text = messages[position].name
        holder.subtitle6?.text = messages[position].desc

        holder.title8?.text = messages[position].name
        holder.subtitle8?.text = messages[position].desc

        holder.title9?.text = messages[position].name
        holder.subtitle9?.text = messages[position].desc

        Log.d("TAG", "Time taken by onBindViewHolder : ${System.currentTimeMillis() - current}")
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    class RvHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView? = itemView.findViewById<TextView>(R.id.title)
        val subtitle: TextView? = itemView.findViewById<TextView>(R.id.subtitle)

        val title1: TextView? = itemView.findViewById<TextView>(R.id.title1)
        val subtitle1: TextView? = itemView.findViewById<TextView>(R.id.subtitle1)

        val title2: TextView? = itemView.findViewById<TextView>(R.id.title2)
        val subtitle2: TextView? = itemView.findViewById<TextView>(R.id.subtitle2)

        val title3: TextView? = itemView.findViewById<TextView>(R.id.title3)
        val subtitle3: TextView? = itemView.findViewById<TextView>(R.id.subtitle3)

        val title4: TextView? = itemView.findViewById<TextView>(R.id.title4)
        val subtitle4: TextView? = itemView.findViewById<TextView>(R.id.subtitle4)

        val title5: TextView? = itemView.findViewById<TextView>(R.id.title5)
        val subtitle5: TextView? = itemView.findViewById<TextView>(R.id.subtitle5)

        val title6: TextView? = itemView.findViewById<TextView>(R.id.title6)
        val subtitle6: TextView? = itemView.findViewById<TextView>(R.id.subtitle6)

        val title7: TextView? = itemView.findViewById<TextView>(R.id.title7)
        val subtitle7: TextView? = itemView.findViewById<TextView>(R.id.subtitle7)

        val title8: TextView? = itemView.findViewById<TextView>(R.id.title8)
        val subtitle8: TextView? = itemView.findViewById<TextView>(R.id.subtitle8)

        val title9: TextView? = itemView.findViewById<TextView>(R.id.title9)
        val subtitle9: TextView? = itemView.findViewById<TextView>(R.id.subtitle9)
    }
}