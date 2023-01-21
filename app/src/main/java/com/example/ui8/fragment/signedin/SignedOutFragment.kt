package com.example.ui8.fragment.signedin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ui8.R
import com.example.ui8.databinding.FragmentSignedOutBinding

class SignedOutFragment : Fragment() {
    private lateinit var vm: SignedOutViewModel
    private lateinit var binding: FragmentSignedOutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignedOutBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, SignedOutViewModelFactory(requireContext().applicationContext))
            .get(SignedOutViewModel::class.java)
        //OnBoard
        vm.resultLive.observe(viewLifecycleOwner, Observer { seenOnBoard ->
            if (seenOnBoard){
                //findNavController().navigate(R.)
            } else{
                findNavController().navigate(R.id.onBoardFragment)
            }
        })
        vm.get()
    }
}