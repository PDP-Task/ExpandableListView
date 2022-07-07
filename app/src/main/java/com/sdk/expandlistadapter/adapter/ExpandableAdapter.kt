package com.sdk.expandlistadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import com.sdk.expandlistadapter.R

class ExpandableAdapter(
    private val context: Context,
    private val title: MutableList<String>,
    private val subtitle: MutableList<MutableList<String>>
) : BaseExpandableListAdapter() {

    lateinit var onClick: (String) -> Unit

    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return subtitle[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): Any {
        return title[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return subtitle[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean = false


    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var myConvertView = convertView
        if (myConvertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            myConvertView = inflater.inflate(R.layout.title_layout, null)
        }
        val title: TextView = myConvertView!!.findViewById(R.id.textView)
        title.text = getGroup(groupPosition).toString()
        return myConvertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var myConvertView = convertView
        if (myConvertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            myConvertView = inflater.inflate(R.layout.sub_title_layout, null)
        }
        val subTitle: TextView = myConvertView!!.findViewById(R.id.textView)
        val text = getChild(groupPosition, childPosition).toString()
        subTitle.text = text
        myConvertView.setOnClickListener {
            onClick.invoke(text)
        }
        return myConvertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
}