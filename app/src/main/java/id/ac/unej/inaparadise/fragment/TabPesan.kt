package id.ac.unej.inaparadise.fragment

import android.support.v4.app.Fragment
import android.view.View
import id.ac.unej.inaparadise.adapter.AdapterDaftarPesan
import id.ac.unej.inaparadise.model.DaftarKontak
import java.util.ArrayList

class TabPesan : Fragment() {
    var listPrioritas: List<DaftarKontak>? = null
    var listSemuaChat: MutableList<DaftarKontak>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_tab_pesan, container, false)
        val prioritas: RecyclerView = root.findViewById(R.id.prioritas)
        val semuaChat: RecyclerView = root.findViewById(R.id.semua_chat)
        listPrioritas = ArrayList<DaftarKontak>()
        listSemuaChat = ArrayList<DaftarKontak>()
        val adapterPrioritas =
            AdapterDaftarPesan(listPrioritas, object : AdapterDaftarPesan.OnItemClickListener {
                override fun onItemClick(model: DaftarKontak) {
                    val chat = Intent(activity, ChatActivity::class.java)
                    chat.putExtra("nama", model.getNama())
                    startActivity(chat)
                }
            })
        val adapterSemuaChat =
            AdapterDaftarPesan(listSemuaChat, object : AdapterDaftarPesan.OnItemClickListener {
                override fun onItemClick(model: DaftarKontak) {
                    val chat = Intent(activity, ChatActivity::class.java)
                    chat.putExtra("nama", model.getNama())
                    startActivity(chat)
                }
            })
        prioritas.setLayoutManager(LinearLayoutManager(context))
        semuaChat.setLayoutManager(LinearLayoutManager(context))
        populate()
        prioritas.setAdapter(adapterPrioritas)
        semuaChat.setAdapter(adapterSemuaChat)
        adapterPrioritas.notifyDataSetChanged()
        adapterSemuaChat.notifyDataSetChanged()
        return root
    }

    fun populate() {
        //String id, String nama, String preview
        listSemuaChat!!.add(
            DaftarKontak(
                "0",
                "Ludfi Ika P",
                "Hari ini mau gathering dimana?",
                R.drawable.profil_2
            )
        )
        listSemuaChat!!.add(
            DaftarKontak(
                "0",
                "Aleq",
                "Saya punya solusi untuk itu",
                R.drawable.profil_1
            )
        )
        listSemuaChat!!.add(
            DaftarKontak(
                "0",
                "Erinda",
                "Ada pagelaran di kota",
                R.drawable.profil_3
            )
        )
    }
}