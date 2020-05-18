package com.cadastralshop.loginui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cadastralshop.loginui.adapter.KatalogAdapters
import com.cadastralshop.loginui.model.KatalogItem

class Dashboard : AppCompatActivity() , AdapterView.OnItemClickListener{

    private var recyclerView:RecyclerView ? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList:ArrayList<KatalogItem> ? = null
    private var katalogAdapters: KatalogAdapters? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, GridLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList= setDataList()
        katalogAdapters = KatalogAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = katalogAdapters

    }

    private fun setDataList() : ArrayList<KatalogItem>{

        var items:ArrayList<KatalogItem> = ArrayList()

        items.add(KatalogItem(R.drawable.bucket, "Cuci tangan"))
        items.add(KatalogItem(R.drawable.hanging, "Cuci Kering"))
        items.add(KatalogItem(R.drawable.cucikilat, "Cuci Kilat"))
        items.add(KatalogItem(R.drawable.scales, "Cuci Komplit"))
        items.add(KatalogItem(R.drawable.security, "Cuci Helm"))
        items.add(KatalogItem(R.drawable.trainers, "Cuci Sepatu"))

        return items
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var items: KatalogItem = arrayList!!.get(position)
        Toast.makeText(applicationContext, items.iconNames, Toast.LENGTH_LONG). show()

    }

}
