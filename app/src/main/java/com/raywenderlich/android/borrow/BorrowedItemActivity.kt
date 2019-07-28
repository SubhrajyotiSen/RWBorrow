package com.raywenderlich.android.borrow

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_edit.*
import java.util.*


class BorrowedItemActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

  private val calendar = Calendar.getInstance()
  private lateinit var datePickerDialog: DatePickerDialog

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_edit)

    datePickerDialog = DatePickerDialog(
      this, this, calendar.get(Calendar.YEAR), calendar.get(
        Calendar.MONTH
      ), calendar.get(Calendar.DAY_OF_MONTH)
    )

    date_button.setOnClickListener {
      // show date picker dialog
    }

    fab.setOnClickListener {
      /** check input values, insert in database and also close activity
       *  if existing item is opened, update the entry
       */
    }
  }

  override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
    // create formatted date string from selected date
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.add_edit_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle item selection
    return when (item.itemId) {
      R.id.delete -> {
        deleteBorrowedItem()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun deleteBorrowedItem() {
    // delete borrowed item from database and close activity
  }
}
