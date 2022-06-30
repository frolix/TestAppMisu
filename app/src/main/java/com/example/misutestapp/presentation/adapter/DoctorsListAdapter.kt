package com.example.misutestapp.presentation.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.misutestapp.R
import com.example.misutestapp.utils.TextIconDrawable
import com.example.misutestapp.databinding.ItemDoctorBinding
import com.example.misutestapp.model.DoctorModel
import com.google.android.material.chip.Chip

class DoctorsListAdapter internal constructor() :
    RecyclerView.Adapter<DoctorsListAdapter.ViewHolder>() {
    private var doctorList = ArrayList<DoctorModel>()

    fun   setItems(items: ArrayList<DoctorModel>) {
        this.doctorList.clear()
        this.doctorList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(
            doctorList[position]
        )
    }

    override fun getItemCount() = doctorList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemDoctorBinding.bind(itemView)

        @SuppressLint("SimpleDateFormat")
        fun onBind(
            doctorModel: DoctorModel,
        ) {

            if (doctorModel.photoUrl.isNullOrEmpty()) {

                val drawable = TextIconDrawable().apply {
                    text =
                        doctorModel.name?.get(0)?.plus(doctorModel.surname?.get(0).toString()) ?: ""
                    textColor = Color.BLACK
                }
                Glide.with(binding.imageDoctor.context).load(drawable).circleCrop()
                    .into(binding.imageDoctor)
            } else {

                Glide.with(binding.imageDoctor.context).load(doctorModel.photoUrl)
                    .diskCacheStrategy(
                        DiskCacheStrategy.ALL
                    ).circleCrop()
                    .into(binding.imageDoctor)
            }
            binding.doctorName.text = "${doctorModel.name} ${doctorModel.surname}"
            binding.professionDoctor.text = doctorModel.profession
            binding.location.text = doctorModel.location

            doctorModel.filterList?.forEach {
                val chip = Chip(binding.doctorFilterListView.context)
                chip.isClickable = false
                chip.setChipBackgroundColorResource(R.color.white)
                chip.chipStrokeColor = ColorStateList.valueOf(
                    Color.parseColor("#D2BFBFBF")
                )
                chip.chipStrokeWidth = 1.toFloat()
                chip.setTextColor(Color.BLUE)
                chip.text = it
                binding.doctorFilterListView.addView(chip)
            }
            binding.descriptionDoctor.text = doctorModel.description.toString()


        }
    }
}