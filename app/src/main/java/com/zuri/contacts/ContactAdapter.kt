package com.zuri.contacts

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zuri.contacts.databinding.ContactItemBinding

class ContactAdapter:RecyclerView.Adapter<ContactAdapter.ContactViewholder>() {

    private val contacts = mutableListOf<Contact>()

    inner class ContactViewholder(private val binding:ContactItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItem(contact:Contact){
            binding.nameTv.text = contact.name
            binding.numberTv.text = contact.number

        }
    }
    fun setupContacts(contact: List<Contact>){
        this.contacts.addAll(contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewholder {
       return ContactViewholder(
           ContactItemBinding.inflate(
               LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewholder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}