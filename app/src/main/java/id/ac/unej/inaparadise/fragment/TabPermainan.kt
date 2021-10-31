package id.ac.unej.inaparadise.fragment

import android.support.v4.app.Fragment
import android.view.View
import id.ac.unej.inaparadise.ui.MapActivity

class TabPermainan : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_tab_permainan, container, false)
        val gridview: GridView = root.findViewById<GridView>(R.id.menu_kebudayaan)
        gridview.setAdapter(GridViewAdapter(activity))
        gridview.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, v: View, position: Int, id: Long) {
//                Toast.makeText(HelloGridView.this, "" + position, Toast.LENGTH_SHORT).show();
                startActivity(Intent(activity, MapActivity::class.java))
            }
        })
        return root
    }
}