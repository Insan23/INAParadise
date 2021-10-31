package id.ac.unej.inaparadise.fragment

import android.support.v4.app.Fragment
import android.view.View
import id.ac.unej.inaparadise.adapter.AdapterDaftarPesan
import id.ac.unej.inaparadise.model.DaftarKontak
import java.util.ArrayList

class TabKomunitas : Fragment() {
    var listKomunitas: MutableList<DaftarKontak>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_tab_komunitas, container, false)
        val komunitas: RecyclerView = root.findViewById(R.id.komunitasku)
        listKomunitas = ArrayList<DaftarKontak>()
        val adapterKomunitas =
            AdapterDaftarPesan(listKomunitas, object : AdapterDaftarPesan.OnItemClickListener {
                override fun onItemClick(model: DaftarKontak) {
                    val chat = Intent(activity, ChatActivity::class.java)
                    chat.putExtra("nama", model.getNama())
                    startActivity(chat)
                }
            })
        populate()
        komunitas.setLayoutManager(LinearLayoutManager(context))
        komunitas.setAdapter(adapterKomunitas)
        adapterKomunitas.notifyDataSetChanged()
        return root
    }

    fun populate() {
        listKomunitas!!.add(
            DaftarKontak(
                "0",
                "Event Lukis Lumajang",
                "Ella - Sukses buat acaranya",
                R.drawable.logo_1
            )
        )
        listKomunitas!!.add(
            DaftarKontak(
                "0",
                "Pameran Lukis Top",
                "Hani - Event nasional kembali",
                R.drawable.logo_2
            )
        )
    }
}