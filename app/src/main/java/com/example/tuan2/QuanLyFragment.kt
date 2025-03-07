package com.example.tuan2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class QuanLyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Gắn layout vào Fragment
        val view = inflater.inflate(R.layout.fragment_quanly, container, false)

        // Ánh xạ View
        val edtNhanVien = view.findViewById<EditText>(R.id.edtNhanVien)
        val btnDoiNhanVien = view.findViewById<Button>(R.id.btnDoiNhanVien)
        val checkSach1 = view.findViewById<CheckBox>(R.id.checkSach1)
        val checkSach2 = view.findViewById<CheckBox>(R.id.checkSach2)
        val btnThem = view.findViewById<Button>(R.id.btnThem)

        // Xử lý sự kiện nút Đổi
        btnDoiNhanVien.setOnClickListener {
            Toast.makeText(requireContext(), "Nhân viên đã được đổi", Toast.LENGTH_SHORT).show()
        }

        // Xử lý sự kiện nút Thêm
        btnThem.setOnClickListener {
            val sachMuon = mutableListOf<String>()
            if (checkSach1.isChecked) sachMuon.add("Sách 01")
            if (checkSach2.isChecked) sachMuon.add("Sách 02")

            val message = if (sachMuon.isNotEmpty()) {
                "Đã thêm: ${sachMuon.joinToString(", ")}"
            } else {
                "Chưa chọn sách nào"
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}

