package com.example.controlarterial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.controlarterial.R
import com.example.controlarterial.entity.TomaArterial

class TomaArterialAdapter(context: Context, tomasArteriales: List<TomaArterial>):
    ArrayAdapter<TomaArterial>(context, 0, tomasArteriales) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val tomaArterial = getItem(position)

        val sistolicaTextView = view!!.findViewById<TextView>(R.id.sistolica)
        val distolicaTextView = view!!.findViewById<TextView>(R.id.distolica)
        val ritmoTextView = view!!.findViewById<TextView>(R.id.ritmo)

        distolicaTextView.text = tomaArterial!!.distolica.toString()
        sistolicaTextView.text = tomaArterial!!.sistolica.toString()
        ritmoTextView.text = tomaArterial!!.ritmo.toString()

        return view
    }
}