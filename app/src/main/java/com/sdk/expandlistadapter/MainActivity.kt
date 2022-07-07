package com.sdk.expandlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import com.sdk.expandlistadapter.adapter.ExpandableAdapter
import com.sdk.expandlistadapter.util.ObjectList

class MainActivity : AppCompatActivity() {
    private lateinit var expandableAdapter: ExpandableAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expandableListView: ExpandableListView = findViewById(R.id.listView)

        ObjectList.title.add("Programming languages")
        ObjectList.title.add("Football Clubs")

        ObjectList.subTitle.add(ObjectList.languageList())
        ObjectList.subTitle.add(ObjectList.footballClubs())

        expandableAdapter = ExpandableAdapter(
            this,
            ObjectList.title,
            ObjectList.subTitle
        )

        expandableListView.setAdapter(
            expandableAdapter
        )
        expandableAdapter.onClick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}