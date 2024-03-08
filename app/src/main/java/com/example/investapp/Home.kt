package com.example.investapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.investapp.databinding.FragmentAccountBinding
import com.example.investapp.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Home : Fragment() {
    private lateinit var assetAdapter : AssetAdapter
    private lateinit var investAdapter : InvestAdapter
    private lateinit var assrecycle: RecyclerView
    private lateinit var newsRecycle: RecyclerView

    private lateinit var assetArrayList : ArrayList<asset>
    private lateinit var investArrayList : ArrayList<investGuide>
    private lateinit var binding: FragmentHomeBinding


    lateinit var cardImage: Array<Int>
    lateinit var heading: Array<String>
    lateinit var descrip: Array<String>

    lateinit var investImage: Array<Int>
    lateinit var nheading: Array<String>
    lateinit var subheading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentHomeBinding.inflate(inflater,container, false)

        assetCards()
        investcard()
        assrecycle = binding.asscards
        assrecycle.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        assrecycle.setHasFixedSize(true)
        assetAdapter = AssetAdapter(assetArrayList)
        assrecycle.adapter= assetAdapter

        newsRecycle = binding.invguide
        newsRecycle.layoutManager = LinearLayoutManager(context)
        newsRecycle.setHasFixedSize(true)
        investAdapter = InvestAdapter(investArrayList)
        newsRecycle.adapter= investAdapter

        return binding.root




    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



        private fun assetCards(): ArrayList<asset> {
            assetArrayList = arrayListOf()

            cardImage = arrayOf(
                R.drawable.dolar,
                R.drawable.silva,
                R.drawable.platim,
                R.drawable.dolar,
                R.drawable.silva,

                )
            heading = arrayOf(
                "Gold",
                "Silva",
                "Platin",
                "Gold",
                "Silva",
            )
            descrip = arrayOf(
                "30% return",
                "60% return",
                "90% return",
                "30% return",
                "60% return",
            )

            for (i in cardImage.indices) {
                val rasset = asset(cardImage[i], heading[i], descrip[i])
                assetArrayList.add(rasset)

            }
            return assetArrayList

        }


        private fun investcard(): ArrayList<investGuide> {
            investArrayList = arrayListOf<investGuide>()
            investImage = arrayOf(
                R.drawable.news1,
                R.drawable.news2,
                R.drawable.news1,
                R.drawable.news2,
                R.drawable.news1
            )
            nheading = arrayOf(
                "Basic type of investment",
                "How much can you start with",
                "What is the best Crypto?",
                "Current trends",
                "Investment market patterns",
            )
            subheading = arrayOf(
                "This is how you set foot into 2024 stock market. What next?",
                "What do you like to see? it's a very different market.",
                "With the approaching halving of bitcoin, it is easily the best option",
                "lets look into NFT and bitcoin ETF's have are dominating the current market",
                "you need to look into the trends that show Bullish market with the progress of the year",
            )
            for (i in investImage.indices) {
                val mnews = investGuide(investImage[i], nheading[i], subheading[i])
                investArrayList.add(mnews)
            }
            return investArrayList
        }
}




