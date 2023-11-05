package com.example.tablelayout

import android.os.Bundle
import android.view.Gravity

import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.tablelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var editTextVersion: EditText
    private lateinit var editTextCodeName: EditText
    private lateinit var addButton: Button
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextVersion = findViewById(R.id.editTextVersion)
        editTextCodeName = findViewById(R.id.editTextCodeName)
        addButton = findViewById(R.id.addButton)
        tableLayout = findViewById(R.id.tableLayout)

        val headerRow = TableRow(this)
        headerRow.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)

        val deviceHeader = createHeaderCell("Version")
        val versionHeader = createHeaderCell("Code Name")

        headerRow.addView(deviceHeader)
        headerRow.addView(versionHeader)

        tableLayout.addView(headerRow)

        addRowToTable("Android 11", "Pie")
        addRowToTable("Android 12", "Oreo")

        addButton.setOnClickListener {
            val version = editTextVersion.text.toString()
            val codeName = editTextCodeName.text.toString()
            addRowToTable(version, codeName)
            editTextVersion.text.clear()
            editTextCodeName.text.clear()
        }
    }


    private fun addRowToTable(version: String, codeName: String) {
        val dataRow = TableRow(this)
        dataRow.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        dataRow.setBackgroundResource(R.drawable.row_devider)

        val versionText = createDataCell(version)
        val codeNameText = createDataCell(codeName)

        dataRow.addView(versionText)
        dataRow.addView(codeNameText)

        tableLayout.addView(dataRow)
    }

    private fun createHeaderCell(text: String): TextView {
        val textView = TextView(this)
        textView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        textView.text = text
        textView.setPadding(5, 5, 5, 5)
        textView.setBackgroundResource(R.drawable.header_background)
        textView.setTextColor(resources.getColor(R.color.black))
        textView.gravity = Gravity.CENTER
        return textView
    }

    private fun createDataCell(text: String): TextView {
        val textView = TextView(this)
        textView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        textView.text = text
        textView.setPadding(5, 5, 5, 5)
        textView.setBackgroundResource(R.drawable.cell_background)
        textView.setTextColor(resources.getColor(R.color.black))
        textView.gravity = Gravity.CENTER
        return textView
    }


}