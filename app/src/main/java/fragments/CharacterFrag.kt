package fragments

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.bumblebee,
            R.drawable.optimus,
            R.drawable.grimlock,
            R.drawable.hound,
            R.drawable.ironhead,
            R.drawable.megatron,
            R.drawable.ratchet,
            R.drawable.sentinelprime,
            R.drawable.starscream

        )

        title = arrayOf(
            getString(R.string.bumbelbee),
            getString(R.string.optimus),
            getString(R.string.grimlock),
            getString(R.string.hound),
            getString(R.string.ironhide),
            getString(R.string.megatron),
            getString(R.string.mudflap_skids),
            getString(R.string.ratchet),
            getString(R.string.starscream),
            getString(R.string.sentinel),
        )
        description = arrayOf(
            getString(R.string.desc_bumbelbee),
            getString(R.string.desc_optimus),
            getString(R.string.desc_grimlock),
            getString(R.string.desc_hound),
            getString(R.string.desc_ironhide),
            getString(R.string.desc_megatron),
            getString(R.string.desc_mudflap_skids),
            getString(R.string.desc_ratchet),
            getString(R.string.desc_starscream),
            getString(R.string.desc_sentinel),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
