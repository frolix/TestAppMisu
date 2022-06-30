package com.example.misutestapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.misutestapp.databinding.ActivityMainBinding
import com.example.misutestapp.databinding.FragmentDoctorsListBinding
import com.example.misutestapp.model.DoctorModel
import com.example.misutestapp.presentation.adapter.DoctorsListAdapter


class DoctorsListFragment : Fragment() {
    private lateinit var binding: FragmentDoctorsListBinding
    private lateinit var adapter: DoctorsListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setDataInAdapter()

    }

    private fun initView() {
        adapter = DoctorsListAdapter()
        binding.doctorsRecyclerView.adapter = adapter
        binding.doctorsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())


    }


    private fun setDataInAdapter(){

        adapter.setItems(
            arrayListOf(
                DoctorModel(
                    "Гордищенко",
                    "Анастасія",
                    "Батьківна",
                    listOf("Діти 0-16 р.", "Дорослі", "Covid-19"),
                    "м. Рівне",
                    "Лікар спеціалізується на сімейній медицині",
                    "Сімейний лікар",
                    "https://thumbs.dreamstime.com/z/covid-healthcare-workers-online-medicine-concept-professional-female-asian-doctor-nurse-scrubs-showing-smartphone-covid-197001012.jpg"
                ),
                DoctorModel(
                    "Дмитренко",
                    "Галина",
                    "Patronymic",
                    listOf("Діти 0-3 р.", "Дорослі"),
                    "м. Кам'янець-Подільський",
                    "Проводить первинний лікарський патронаж новонародженого",
                    "Сімейний лікар",
                    "https://media.istockphoto.com/id/179011088/uk/%D1%84%D0%BE%D1%82%D0%BE/%D1%96%D0%BD%D0%B4%D1%96%D0%B9%D1%81%D1%8C%D0%BA%D0%B8%D0%B9-%D0%BB%D1%96%D0%BA%D0%B0%D1%80.webp?s=612x612&w=is&k=20&c=VT-z34JA7lD6M_owAifrrrBl4NLth2oQeC-KYNtvPH4="
                ),
                DoctorModel(
                    "Омельчук",
                    "Інна",
                    "Patronymic",
                    listOf("Діти 0-16 р.", "Дорослі", "Covid-19"),
                    "м. Одесса",
                    "Веде прийом для дітей від народження",
                    "Сімейний лікар",
                    "https://thumbs.dreamstime.com/z/female-nurse-tablet-attractive-using-computer-hospital-34479187.jpg"
                ),
                DoctorModel(
                    "Латишева",
                    "Ольга",
                    "Patronymic",
                    listOf("Дорослі", "Covid-19"),
                    "м. Дніпро",
                    "Діагностика та лікування захворювань дорослих; консультації з приводу вакцинації",
                    "Сімейний лікар",
                    "https://thumbs.dreamstime.com/z/professional-thinking-medical-woman-doctor-27686670.jpg"
                ),
                DoctorModel(
                    "Швець",
                    "Павло",
                    "Patronymic",
                    listOf("Діти 7-16 р.", "Дорослі", "Covid-19"),
                    "м. Львів",
                    "Здійснює прийом паціентів амбулаторно",
                    "Сімейний лікар",
                    ""
                ),
                DoctorModel(
                    "Surname",
                    "Name",
                    "Patronymic",
                    listOf("Діти 7-16 р.", "Дорослі", "Covid-19","Діти 7-16 р.", "Дорослі", "Covid-19"),
                    "Poltava",
                    "text",
                    "Сімейний лікар",
                    ""
                ),
            )
        )
    }

}