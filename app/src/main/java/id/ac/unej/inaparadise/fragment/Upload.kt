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
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.View
import android.widget.GridView
import id.ac.unej.inaparadise.adapter.GridViewAdapter
import android.widget.AdapterView
import id.ac.unej.inaparadise.adapter.AdapterDaftarPesan
import java.util.ArrayList

class Upload : Fragment() {
    var daftarFeed: MutableList<DaftarFeed>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_upload, container, false)
        val upload: FloatingActionButton = root.findViewById(R.id.upload)
        upload.setOnClickListener { }
        val feed: RecyclerView = root.findViewById(R.id.umpan)
        daftarFeed = ArrayList()
        val adapter = FeedAdapter(daftarFeed, object : FeedAdapter.OnItemClickListener {
            override fun onItemClick(model: DaftarFeed?) {}
        })
        populate()
        feed.layoutManager = LinearLayoutManager(activity)
        feed.adapter = adapter
        adapter.notifyDataSetChanged()
        return root
    }

    fun populate() {
        //int foto, int fotoUploader, String uploader, long waktu
        daftarFeed!!.add(DaftarFeed(R.drawable.foto_1, R.drawable.profil_1, "Aleq", 1))
        daftarFeed!!.add(DaftarFeed(R.drawable.foto_2, R.drawable.profil_2, "Ludfi", 3))
        daftarFeed!!.add(DaftarFeed(R.drawable.foto_3, R.drawable.profil_3, "Erinda", 5))
        daftarFeed!!.add(DaftarFeed(R.drawable.foto_4, R.drawable.profil_2, "Ludfi", 6))
    }
}