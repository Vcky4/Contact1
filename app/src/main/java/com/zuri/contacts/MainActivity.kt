package com.zuri.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.zuri.contacts.databinding.ActivityFamilyBinding
import com.zuri.contacts.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), Clicks {

    private lateinit var binding: ActivityMainBinding
    private val adapter = CategoryAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val adapter = CategoryAdapter(this)
        val gridLayout = GridLayoutManager(this, 2)
        categoryRv.layoutManager = gridLayout
        categoryRv.adapter = adapter
        setUpData(binding)

    }
    override fun onClick(position: String) {
        val intent = Intent(this, Family::class.java)
        intent.putExtra("name", position)
        startActivity(intent)
    }

    private fun setUpData(binding: ActivityMainBinding){
        binding.categoryRv.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_category, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.inputCategory)
        val save = view.findViewById<Button>(R.id.saveCategory)

        name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                save.isEnabled = s?.length!=0
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        val alertDialog = builder.create()

        save.setOnClickListener{
            val category = Category(name.text.toString())
            val categories = mutableListOf(category)
            adapter.setupCategory(categories)
            alertDialog.dismiss()
        }


        binding.categoryButton.setOnClickListener{
            alertDialog.show();
        }
    }
}