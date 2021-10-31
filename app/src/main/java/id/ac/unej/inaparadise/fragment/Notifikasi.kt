package id.ac.unej.inaparadise.fragment

import android.support.v4.app.Fragment
import android.view.View
import id.ac.unej.inaparadise.adapter.DaftarNotifikasiAdapter
import id.ac.unej.inaparadise.model.DaftarNotifikasi
import java.util.ArrayList

class Notifikasi : Fragment() {
    var daftarNotifikasi: MutableList<DaftarNotifikasi>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_notifikasi, container, false)
        val notifikasi: RecyclerView = root.findViewById(R.id.daftar_notifikasi)
        daftarNotifikasi = ArrayList<DaftarNotifikasi>()
        val adapter = DaftarNotifikasiAdapter(
            daftarNotifikasi,
            object : DaftarNotifikasiAdapter.OnItemClickListener {
                override fun onItemClick(model: DaftarNotifikasi) {
                    val chat = Intent(activity, ChatActivity::class.java)
                    chat.putExtra("nama", model.getNama())
                    startActivity(chat)
                }
            })
        populate()
        notifikasi.setLayoutManager(LinearLayoutManager(activity))
        notifikasi.setAdapter(adapter)
        adapter.notifyDataSetChanged()
        return root
    }

    fun populate() {
        //String nama, String isi, long waktu, int foto
        daftarNotifikasi!!.add(
            DaftarNotifikasi(
                "Ludfi Ika P",
                "Hari ini mau gathering dimana?",
                2,
                R.drawable.profil_2
            )
        )
        daftarNotifikasi!!.add(
            DaftarNotifikasi(
                "Erinda",
                "Ada pagelaran di kota",
                6,
                R.drawable.profil_3
            )
        )
        daftarNotifikasi!!.add(
            DaftarNotifikasi(
                "Aleq",
                "Saya punya solusi untuk itu",
                10,
                R.drawable.profil_1
            )
        )
    }
}