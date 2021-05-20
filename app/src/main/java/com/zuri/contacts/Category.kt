package com.zuri.contacts

class Category(val categoryName:String) {
}



//package com.zuri.contacts
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class CategoryAdapter(private val cardTitle:Array<String>,private val onContactClick:Clicks):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val cardTitle: TextView = itemView.findViewById(R.id.categoryText)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.category,parent,false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.cardTitle.text =cardTitle[position]
//
//        holder.cardTitle.setOnClickListener {
//            onContactClick.onClick(cardTitle[position])
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return cardTitle.size
//    }
//}





