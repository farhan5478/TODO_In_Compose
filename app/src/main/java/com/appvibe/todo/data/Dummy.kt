package com.appvibe.todo.data

import com.appvibe.todo.presentation.model.DropDown

object Dummy {
    fun menuItemList() : List<DropDown>{
        return listOf(DropDown(1,"Today",true),DropDown(2,"Yesterday",false), DropDown(3,"Tomorrow",false))
    }
}