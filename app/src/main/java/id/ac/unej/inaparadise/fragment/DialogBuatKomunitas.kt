package id.ac.unej.inaparadise.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import id.ac.unej.inaparadise.R
import android.widget.ArrayAdapter
import id.ac.unej.inaparadise.model.DaftarFeed
import android.support.v7.widget.RecyclerView
import id.ac.unej.inaparadise.adapter.FeedAdapter
import android.support.v7.widget.LinearLayoutManager
import id.ac.unej.inaparadise.adapter.DaftarNotifikasiAdapter
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.GridView
import id.ac.unej.inaparadise.adapter.GridViewAdapter
import android.widget.AdapterView
import android.widget.Spinner
import id.ac.unej.inaparadise.adapter.AdapterDaftarPesan

class DialogBuatKomunitas : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dialog_buat_komunitas, container, false)
        val spinner = view.findViewById<Spinner>(R.id.tipe_komunitas)
        val adapter = ArrayAdapter.createFromResource(
            context,
            R.array.tipe_komunitas,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        view.findViewById<View>(R.id.selesai).setOnClickListener { dismiss() }
        return view
    }
}