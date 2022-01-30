package com.dingyi.tree_sitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dingyi.tree_sitter.databinding.ActivityMainBinding
import ai.serenade.treesitter.Languages
import ai.serenade.treesitter.Node
import ai.serenade.treesitter.Parser
import android.util.Log


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Parser().use { parser ->
            parser.setLanguage(Languages.python())
            parser.parseString("def foo(bar, baz):\n  print(bar)\n  print(baz)").use { tree ->
                val root = tree.rootNode
                Log.e("tree-sitter", root.toString())
                Log.e("tree-sitter",tree.toString())
            }
        }

    }


    companion object {
        // Used to load the 'tree_sitter' library on application startup.
        init {
            System.loadLibrary("tree_sitter")
        }
    }
}