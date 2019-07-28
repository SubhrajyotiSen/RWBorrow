/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.raywenderlich.android.borrow

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
  SearchView.OnQueryTextListener, SearchView.OnCloseListener {

  private lateinit var borrowRecyclerViewAdapter: BorrowRecyclerViewAdapter

  companion object {
    val INTENT_EXTRA_KEY = "BORROW_ID"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    borrowRecyclerViewAdapter = BorrowRecyclerViewAdapter(object : RecyclerViewItemClickListener {
      override fun onItemClicked(borrowedItemModel: BorrowedItemModel) {
        startBorrowItemActivity(borrowedItemModel.id)
      }
    })

    recyclerView.adapter = borrowRecyclerViewAdapter
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.addItemDecoration(DividerItemDecoration(this))

    fab.setOnClickListener {
      startBorrowItemActivity()
    }
  }

  private fun startBorrowItemActivity(id: Long? = null) {
    // create intent and start activity to add/edit borrowed item
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)
    val searchItem = menu?.findItem(R.id.action_search)
    val searchView = searchItem?.actionView as SearchView
    searchView.setOnQueryTextListener(this)
    searchView.setOnCloseListener(this)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle item selection
    when (item.itemId) {
      R.id.sort_by_name -> {
        // query the database and sort by the name of the borrowed item
      }
      R.id.sort_by_date_added -> {
        // query the database and sort by the date added
      }
      R.id.action_search -> {
        // start search
      }
    }
    item.isChecked = true
    return super.onOptionsItemSelected(item)
  }

  override fun onQueryTextSubmit(query: String?): Boolean {
    if (query != null) {
      queryForText(query)
    }
    return false
  }

  override fun onQueryTextChange(newText: String?): Boolean {
    if (newText != null) {
      queryForText(newText)
    }
    return false
  }

  override fun onDestroy() {
    // cancel subscription
    super.onDestroy()
  }

  private fun queryForText(query: String) {
    // query database for items whose name contain the query text
  }

  override fun onClose(): Boolean {
    // reset recyclerview to original state from search
    return false
  }
}