package com.zuri.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.zuri.contacts.databinding.ActivityFamilyBinding
import com.zuri.contacts.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.category.*

class Family : AppCompatActivity() {
    private lateinit var binding: ActivityFamilyBinding
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFamilyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contactRv.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        var display = intent.getStringExtra("name")
        var action = supportActionBar
        action!!.title = display
        setUpData(binding)
    }
    private fun setUpData(binding: ActivityFamilyBinding){
        binding.contactRv.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.inputName)
        val no = view.findViewById<TextView>(R.id.phoneNumer)
        val save = view.findViewById<Button>(R.id.save)

        no.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                save.isEnabled = s?.length==11
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        val alertDialog = builder.create()

        save.setOnClickListener{
            val contact = Contact(name.text.toString(),no.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupContacts(contacts)
            alertDialog.dismiss()
        }


        binding.flotButton.setOnClickListener{
            alertDialog.show();
        }
    }
}