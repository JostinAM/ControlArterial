package com.example.controlarterial

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.controlarterial.adapter.TomaArterialAdapter
import com.example.controlarterial.databinding.FragmentFirstBinding
import com.example.controlarterial.entity.TomaArterial
import com.example.controlarterial.viewModel.TomaArterialViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //MVVM
    private lateinit var tomaArterialViewModel: TomaArterialViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

//        val interceptor = HttpLoggingInterceptor()
//
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val client = OkHttpClient
//            .Builder()
//            .addInterceptor(AuthInterceptor("ezPnykXgMF2mvQTyfZt2SMQhfbVVHpzVZkmSH7qXhcynO-28rg"))
//            .addInterceptor(interceptor)
//            .build()
//
//        val gson = GsonBuilder().setPrettyPrinting().create()
//
//        val retrofit = Retrofit
//            .Builder()
//            .baseUrl("https://crudapi.co.uk/api/v1/")
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val apiService = retrofit.create(TomaArterialDAO::class.java)
//
//        val item = TomaArterial(_uuid = null, sistolica = 22, distolica = 223, ritmo = 100)
//        var items = ArrayList<TomaArterial>()
//
//        items.add(item)
//
//        val listView = view.findViewById<ListView>(R.id.listTomasArteriales)
//
//        val adapter = context?.let { TomaArterialAdapter(it, items) }
//
//        listView.adapter = adapter


        val listView = view.findViewById<ListView>(R.id.listTomasArteriales)

        val adapter = TomaArterialAdapter(requireContext(), mutableListOf<TomaArterial>())

        listView.adapter = adapter

        tomaArterialViewModel =
            ViewModelProvider(requireActivity()).get(TomaArterialViewModel::class.java)

        tomaArterialViewModel.listLiveData.observe(viewLifecycleOwner) { elements ->
            adapter.clear()
            Log.d("FirstFragment", "onViewCreated: $elements")
            adapter.addAll(elements)
            adapter.notifyDataSetChanged()
        }

        GlobalScope.launch(Dispatchers.Main) {
//            var salida = gson.toJson(item)
//            print(salida)
//
//            val createdItem = apiService.createItem(items)
//
//            val arteriales = apiService.getItems()
//
//            print(arteriales)

            tomaArterialViewModel.listTomaArterial()!!

//            withContext(Dispatchers.Main) {
//                // Procesar la respuesta del API
//
//            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}