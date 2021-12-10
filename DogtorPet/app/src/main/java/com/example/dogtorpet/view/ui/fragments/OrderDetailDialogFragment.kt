package com.example.dogtorpet.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.dogtorpet.databinding.FragmentOrderDetailDialogBinding
import com.example.dogtorpet.model.Products
import com.squareup.picasso.Picasso

class OrderDetailDialogFragment : DialogFragment() {

    private var _binding: FragmentOrderDetailDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderDetailDialogBinding.inflate(inflater, container, false)
        var view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = arguments?.getSerializable("product") as Products

        binding.tvNameProduct.text = products.nombre
        binding.tvDescriptionProduct.text = products.descripcion
        binding.tvPriceProduct.text = products.precio
        Picasso.get().load(products.url).into(binding.ivProduct)

        binding.btBuyProduct.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}