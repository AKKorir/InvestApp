package com.example.investapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.investapp.databinding.FragmentAccountBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Account.newInstance] factory method to
 * create an instance of this fragment.
 */
class Account : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var binding: FragmentAccountBinding
    private lateinit var toolbar: Toolbar
    private lateinit var profRecycle: RecyclerView
    private lateinit var profilearrayList : ArrayList<profile_list>
    private lateinit var profileAdapter : ProfileAdapter
    lateinit var profile_icon: Array<Int>
    lateinit var profile_value: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileCard()
        binding = FragmentAccountBinding. inflate(inflater, container,false)
        profRecycle = binding. profileview
        profRecycle.layoutManager = LinearLayoutManager(context)
        profRecycle.setHasFixedSize(true)
        profileAdapter = ProfileAdapter(profilearrayList)
        profRecycle.adapter= profileAdapter





        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Account.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Account().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun profileCard() {
        profilearrayList = arrayListOf()

        profile_icon = arrayOf(
            R.drawable.baseline_contacts_24,
            R.drawable.baseline_money_24,
            R.drawable.baseline_bank_24,
            R.drawable.baseline_document_24,
            R.drawable.baseline_settings,

            )
        profile_value = arrayOf(
            "Contact Info",
            "Source of Funding ",
            "Bank Account Info",
            "Document Info",
            "Settings",
        )

        for (i in profile_icon.indices) {
            val rasset = profile_list(profile_icon[i], profile_value[i])
            profilearrayList.add(rasset)

        }


}
}