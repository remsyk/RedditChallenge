package com.example.redditchallenge

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.redditchallenge.models.RickMortyModel
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview_character.view.*
import kotlinx.android.synthetic.main.viewgroup_details.view.*

class CharacterRecyclerAdapter(private val context: Context, _data: List<RickMortyModel.Result?>): RecyclerView.Adapter<CharacterRecyclerAdapter.ViewHolder>() {

    private var data:List<RickMortyModel.Result?> = _data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_character,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {

            Picasso.get().load(data[position]?.image).into(image)
            name.text = data[position]?.name
            status.text = data[position]?.status
            species.text = data[position]?.species
            gender.text = data[position]?.gender
            origin.text =  data[position]?.origin?.name
            location.text = data[position]?.location?.name

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image : ImageView = view.imageview_character
        val name: MaterialTextView=  view.include_details.name
        val status: MaterialTextView=  view.include_details.status
        val species: MaterialTextView=  view.include_details.species
        val gender: MaterialTextView=  view.include_details.gender
        val origin: MaterialTextView=  view.include_details.origin
        val location: MaterialTextView=  view.include_details.location
    }
}