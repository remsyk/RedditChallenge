package com.example.redditchallenge

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.redditchallenge.models.RickMortyModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chipgroup_gender.view.*
import java.util.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataManager.getCharacterList().observe(this, androidx.lifecycle.Observer {
            recyclerview_main.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            val adapter = CharacterRecyclerAdapter(this, it)
            recyclerview_main.adapter = adapter
        })

        chip_group_gender.chip_male.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                DataManager.getFilteredCharacters2("male")
            }
        }

        chip_group_gender.chip_female.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                DataManager.getFilteredCharacters2("female")
            }
        }

        chip_group_gender.chip_genderless.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                DataManager.getFilteredCharacters2("genderless")
            }
        }

        chip_group_gender.chip_unknown.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                DataManager.getFilteredCharacters2("unknown")
            }
        }



    }


}
