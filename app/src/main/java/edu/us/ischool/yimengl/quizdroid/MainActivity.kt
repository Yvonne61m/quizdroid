package edu.us.ischool.yimengl.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.content.Intent



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val List: ListView = findViewById(R.id.list)
        val items = arrayOf("Math", "Physics", "Marvel Super Heroes")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items)
        List.adapter = adapter
        List.setOnItemClickListener{
            parent, view, position, id ->
            val intent = Intent(this, topicOverview::class.java)
            intent.putExtra("item", items[position])
            startActivity(intent)
        }
    }
}
