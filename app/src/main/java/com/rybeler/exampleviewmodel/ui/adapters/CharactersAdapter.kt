package com.rybeler.exampleviewmodel.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rybeler.exampleviewmodel.data.models.Character
import com.rybeler.exampleviewmodel.databinding.CharacterLayoutBinding

class CharactersAdapter(
    private val characters: List<Character>,
) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characterData = characters[position]

        holder.binding.nameText.text = characterData.name
        holder.binding.descriptionText.text =
            characterData.description.ifEmpty { "No description" }
//        val imageURL = characterData.thumbnail.path
        val imageURL = "https://c8.alamy.com/comp/CPNCC5/captain-america-the-first-avenger-CPNCC5.jpg"
        Glide.with(holder.binding.root.context)
            .load(imageURL)
            .into(holder.binding.imageView);
    }
}

class CharacterViewHolder(val binding: CharacterLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)